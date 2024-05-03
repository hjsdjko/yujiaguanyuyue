package com.dao;

import com.entity.TaochanOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TaochanOrderView;

/**
 * 套餐购买 Dao 接口
 *
 * @author 
 */
public interface TaochanOrderDao extends BaseMapper<TaochanOrderEntity> {

   List<TaochanOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
