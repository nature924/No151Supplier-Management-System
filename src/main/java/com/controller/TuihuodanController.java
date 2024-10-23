
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
 * 商品退货
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tuihuodan")
public class TuihuodanController {
    private static final Logger logger = LoggerFactory.getLogger(TuihuodanController.class);

    private static final String TABLE_NAME = "tuihuodan";

    @Autowired
    private TuihuodanService tuihuodanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private GongyingshangService gongyingshangService;//供应商信息
    @Autowired
    private JinhuodanService jinhuodanService;//商品进货
    @Autowired
    private ShangpinService shangpinService;//商品
    @Autowired
    private ShangpinChuruInoutService shangpinChuruInoutService;//出入库
    @Autowired
    private ShangpinChuruInoutListService shangpinChuruInoutListService;//出入库详情
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
        PageUtils page = tuihuodanService.queryPage(params);

        //字典表数据转换
        List<TuihuodanView> list =(List<TuihuodanView>)page.getList();
        for(TuihuodanView c:list){
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
        TuihuodanEntity tuihuodan = tuihuodanService.selectById(id);
        if(tuihuodan !=null){
            //entity转view
            TuihuodanView view = new TuihuodanView();
            BeanUtils.copyProperties( tuihuodan , view );//把实体数据重构到view中
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(tuihuodan.getYuangongId());
            if(yuangong != null){
            BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongId(yuangong.getId());
            }
            //级联表 供应商信息
            //级联表
            GongyingshangEntity gongyingshang = gongyingshangService.selectById(tuihuodan.getGongyingshangId());
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
    public R save(@RequestBody TuihuodanEntity tuihuodan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tuihuodan:{}",this.getClass().getName(),tuihuodan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            tuihuodan.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<TuihuodanEntity> queryWrapper = new EntityWrapper<TuihuodanEntity>()
            .eq("yuangong_id", tuihuodan.getYuangongId())
            .eq("gongyingshang_id", tuihuodan.getGongyingshangId())
            .eq("tuihuodan_name", tuihuodan.getTuihuodanName())
            .eq("tuihuodan_types", tuihuodan.getTuihuodanTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TuihuodanEntity tuihuodanEntity = tuihuodanService.selectOne(queryWrapper);
        if(tuihuodanEntity==null){
            tuihuodan.setInsertTime(new Date());
            tuihuodan.setCreateTime(new Date());
            tuihuodanService.insert(tuihuodan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TuihuodanEntity tuihuodan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,tuihuodan:{}",this.getClass().getName(),tuihuodan.toString());
        TuihuodanEntity oldTuihuodanEntity = tuihuodanService.selectById(tuihuodan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            tuihuodan.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(tuihuodan.getTuihuodanFile()) || "null".equals(tuihuodan.getTuihuodanFile())){
                tuihuodan.setTuihuodanFile(null);
        }

            tuihuodanService.updateById(tuihuodan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<TuihuodanEntity> oldTuihuodanList =tuihuodanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        tuihuodanService.deleteBatchIds(Arrays.asList(ids));

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
            List<TuihuodanEntity> tuihuodanList = new ArrayList<>();//上传的东西
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
                            TuihuodanEntity tuihuodanEntity = new TuihuodanEntity();
//                            tuihuodanEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            tuihuodanEntity.setGongyingshangId(Integer.valueOf(data.get(0)));   //供应商 要改的
//                            tuihuodanEntity.setTuihuodanUuidNumber(data.get(0));                    //退货单编号 要改的
//                            tuihuodanEntity.setTuihuodanName(data.get(0));                    //退货单名称 要改的
//                            tuihuodanEntity.setTuihuodanFile(data.get(0));                    //退货单 要改的
//                            tuihuodanEntity.setTuihuodanTypes(Integer.valueOf(data.get(0)));   //退货类型 要改的
//                            tuihuodanEntity.setCaozuoTime(sdf.parse(data.get(0)));          //退货时间 要改的
//                            tuihuodanEntity.setTuihuodanContent("");//详情和图片
//                            tuihuodanEntity.setTuihuodanBeizhuContent("");//详情和图片
//                            tuihuodanEntity.setInsertTime(date);//时间
//                            tuihuodanEntity.setCreateTime(date);//时间
                            tuihuodanList.add(tuihuodanEntity);


                            //把要查询是否重复的字段放入map中
                                //退货单编号
                                if(seachFields.containsKey("tuihuodanUuidNumber")){
                                    List<String> tuihuodanUuidNumber = seachFields.get("tuihuodanUuidNumber");
                                    tuihuodanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> tuihuodanUuidNumber = new ArrayList<>();
                                    tuihuodanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("tuihuodanUuidNumber",tuihuodanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //退货单编号
                        List<TuihuodanEntity> tuihuodanEntities_tuihuodanUuidNumber = tuihuodanService.selectList(new EntityWrapper<TuihuodanEntity>().in("tuihuodan_uuid_number", seachFields.get("tuihuodanUuidNumber")));
                        if(tuihuodanEntities_tuihuodanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TuihuodanEntity s:tuihuodanEntities_tuihuodanUuidNumber){
                                repeatFields.add(s.getTuihuodanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [退货单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        tuihuodanService.insertBatch(tuihuodanList);
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

