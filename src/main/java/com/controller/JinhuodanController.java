
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 商品进货
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jinhuodan")
public class JinhuodanController {
    private static final Logger logger = LoggerFactory.getLogger(JinhuodanController.class);

    private static final String TABLE_NAME = "jinhuodan";

    @Autowired
    private JinhuodanService jinhuodanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private GongyingshangService gongyingshangService;//供应商信息
    @Autowired
    private ShangpinService shangpinService;//商品
    @Autowired
    private ShangpinChuruInoutService shangpinChuruInoutService;//出入库
    @Autowired
    private ShangpinChuruInoutListService shangpinChuruInoutListService;//出入库详情
    @Autowired
    private TuihuodanService tuihuodanService;//商品退货
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = jinhuodanService.queryPage(params);

        //字典表数据转换
        List<JinhuodanView> list =(List<JinhuodanView>)page.getList();
        for(JinhuodanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JinhuodanEntity jinhuodan = jinhuodanService.selectById(id);
        if(jinhuodan !=null){
            //entity转view
            JinhuodanView view = new JinhuodanView();
            BeanUtils.copyProperties( jinhuodan , view );//把实体数据重构到view中
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(jinhuodan.getYuangongId());
            if(yuangong != null){
            BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongId(yuangong.getId());
            }
            //级联表 供应商信息
            //级联表
            GongyingshangEntity gongyingshang = gongyingshangService.selectById(jinhuodan.getGongyingshangId());
            if(gongyingshang != null){
            BeanUtils.copyProperties( gongyingshang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setGongyingshangId(gongyingshang.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JinhuodanEntity jinhuodan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jinhuodan:{}",this.getClass().getName(),jinhuodan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            jinhuodan.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JinhuodanEntity> queryWrapper = new EntityWrapper<JinhuodanEntity>()
            .eq("yuangong_id", jinhuodan.getYuangongId())
            .eq("gongyingshang_id", jinhuodan.getGongyingshangId())
            .eq("jinhuodan_name", jinhuodan.getJinhuodanName())
            .eq("jinhuodan_types", jinhuodan.getJinhuodanTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JinhuodanEntity jinhuodanEntity = jinhuodanService.selectOne(queryWrapper);
        if(jinhuodanEntity==null){
            jinhuodan.setInsertTime(new Date());
            jinhuodan.setCreateTime(new Date());
            jinhuodanService.insert(jinhuodan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JinhuodanEntity jinhuodan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jinhuodan:{}",this.getClass().getName(),jinhuodan.toString());
        JinhuodanEntity oldJinhuodanEntity = jinhuodanService.selectById(jinhuodan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            jinhuodan.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jinhuodan.getJinhuodanFile()) || "null".equals(jinhuodan.getJinhuodanFile())){
                jinhuodan.setJinhuodanFile(null);
        }

            jinhuodanService.updateById(jinhuodan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JinhuodanEntity> oldJinhuodanList =jinhuodanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jinhuodanService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yuangongId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<JinhuodanEntity> jinhuodanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JinhuodanEntity jinhuodanEntity = new JinhuodanEntity();
//                            jinhuodanEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            jinhuodanEntity.setGongyingshangId(Integer.valueOf(data.get(0)));   //供应商 要改的
//                            jinhuodanEntity.setJinhuodanUuidNumber(data.get(0));                    //进货单编号 要改的
//                            jinhuodanEntity.setJinhuodanName(data.get(0));                    //进货单名称 要改的
//                            jinhuodanEntity.setJinhuodanFile(data.get(0));                    //进货单 要改的
//                            jinhuodanEntity.setJinhuodanTypes(Integer.valueOf(data.get(0)));   //进货类型 要改的
//                            jinhuodanEntity.setCaozuoTime(sdf.parse(data.get(0)));          //进货时间 要改的
//                            jinhuodanEntity.setJinhuodanContent("");//详情和图片
//                            jinhuodanEntity.setJinhuodanBeizhuContent("");//详情和图片
//                            jinhuodanEntity.setInsertTime(date);//时间
//                            jinhuodanEntity.setCreateTime(date);//时间
                            jinhuodanList.add(jinhuodanEntity);


                            //把要查询是否重复的字段放入map中
                                //进货单编号
                                if(seachFields.containsKey("jinhuodanUuidNumber")){
                                    List<String> jinhuodanUuidNumber = seachFields.get("jinhuodanUuidNumber");
                                    jinhuodanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jinhuodanUuidNumber = new ArrayList<>();
                                    jinhuodanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jinhuodanUuidNumber",jinhuodanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //进货单编号
                        List<JinhuodanEntity> jinhuodanEntities_jinhuodanUuidNumber = jinhuodanService.selectList(new EntityWrapper<JinhuodanEntity>().in("jinhuodan_uuid_number", seachFields.get("jinhuodanUuidNumber")));
                        if(jinhuodanEntities_jinhuodanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JinhuodanEntity s:jinhuodanEntities_jinhuodanUuidNumber){
                                repeatFields.add(s.getJinhuodanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [进货单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jinhuodanService.insertBatch(jinhuodanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

