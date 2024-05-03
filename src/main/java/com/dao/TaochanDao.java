package com.dao;

import com.entity.TaochanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TaochanView;

/**
 * 套餐 Dao 接口
 *
 * @author 
 */
public interface TaochanDao extends BaseMapper<TaochanEntity> {

   List<TaochanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
