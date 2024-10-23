package com.dao;

import com.entity.JinhuodanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JinhuodanView;

/**
 * 商品进货 Dao 接口
 *
 * @author 
 */
public interface JinhuodanDao extends BaseMapper<JinhuodanEntity> {

   List<JinhuodanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
