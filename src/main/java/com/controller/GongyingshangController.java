
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
 * 供应商信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongyingshang")
public class GongyingshangController {
    private static final Logger logger = LoggerFactory.getLogger(GongyingshangController.class);

    private static final String TABLE_NAME = "gongyingshang";

    @Autowired
    private GongyingshangService gongyingshangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JinhuodanService jinhuodanService;//商品进货
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
        PageUtils page = gongyingshangService.queryPage(params);

        //字典表数据转换
        List<GongyingshangView> list =(List<GongyingshangView>)page.getList();
        for(GongyingshangView c:list){
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
        GongyingshangEntity gongyingshang = gongyingshangService.selectById(id);
        if(gongyingshang !=null){
            //entity转view
            GongyingshangView view = new GongyingshangView();
            BeanUtils.copyProperties( gongyingshang , view );//把实体数据重构到view中
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
    public R save(@RequestBody GongyingshangEntity gongyingshang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongyingshang:{}",this.getClass().getName(),gongyingshang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GongyingshangEntity> queryWrapper = new EntityWrapper<GongyingshangEntity>()
            .eq("gongyingshang_name", gongyingshang.getGongyingshangName())
            .eq("lianxiren_name", gongyingshang.getLianxirenName())
            .eq("lianxiren_phone", gongyingshang.getLianxirenPhone())
            .eq("lianxiren_address", gongyingshang.getLianxirenAddress())
            .eq("gongyingshang_types", gongyingshang.getGongyingshangTypes())
            .eq("gongyingshang_xinyongdengji_types", gongyingshang.getGongyingshangXinyongdengjiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongyingshangEntity gongyingshangEntity = gongyingshangService.selectOne(queryWrapper);
        if(gongyingshangEntity==null){
            gongyingshang.setCreateTime(new Date());
            gongyingshangService.insert(gongyingshang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongyingshangEntity gongyingshang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,gongyingshang:{}",this.getClass().getName(),gongyingshang.toString());
        GongyingshangEntity oldGongyingshangEntity = gongyingshangService.selectById(gongyingshang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");

            gongyingshangService.updateById(gongyingshang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<GongyingshangEntity> oldGongyingshangList =gongyingshangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        gongyingshangService.deleteBatchIds(Arrays.asList(ids));

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
            List<GongyingshangEntity> gongyingshangList = new ArrayList<>();//上传的东西
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
                            GongyingshangEntity gongyingshangEntity = new GongyingshangEntity();
//                            gongyingshangEntity.setGongyingshangUuidNumber(data.get(0));                    //供应商唯一编号 要改的
//                            gongyingshangEntity.setGongyingshangName(data.get(0));                    //供应商名称 要改的
//                            gongyingshangEntity.setLianxirenName(data.get(0));                    //联系人姓名 要改的
//                            gongyingshangEntity.setLianxirenPhone(data.get(0));                    //联系人手机号 要改的
//                            gongyingshangEntity.setLianxirenAddress(data.get(0));                    //地址 要改的
//                            gongyingshangEntity.setGongyingshangTypes(Integer.valueOf(data.get(0)));   //供应商类型 要改的
//                            gongyingshangEntity.setGongyingshangXinyongdengjiTypes(Integer.valueOf(data.get(0)));   //信用等级 要改的
//                            gongyingshangEntity.setGongyingshangContent("");//详情和图片
//                            gongyingshangEntity.setCreateTime(date);//时间
                            gongyingshangList.add(gongyingshangEntity);


                            //把要查询是否重复的字段放入map中
                                //供应商唯一编号
                                if(seachFields.containsKey("gongyingshangUuidNumber")){
                                    List<String> gongyingshangUuidNumber = seachFields.get("gongyingshangUuidNumber");
                                    gongyingshangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> gongyingshangUuidNumber = new ArrayList<>();
                                    gongyingshangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("gongyingshangUuidNumber",gongyingshangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //供应商唯一编号
                        List<GongyingshangEntity> gongyingshangEntities_gongyingshangUuidNumber = gongyingshangService.selectList(new EntityWrapper<GongyingshangEntity>().in("gongyingshang_uuid_number", seachFields.get("gongyingshangUuidNumber")));
                        if(gongyingshangEntities_gongyingshangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GongyingshangEntity s:gongyingshangEntities_gongyingshangUuidNumber){
                                repeatFields.add(s.getGongyingshangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [供应商唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        gongyingshangService.insertBatch(gongyingshangList);
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

