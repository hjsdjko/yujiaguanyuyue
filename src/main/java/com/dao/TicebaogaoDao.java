package com.dao;

import com.entity.TicebaogaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TicebaogaoView;

/**
 * 体测报告 Dao 接口
 *
 * @author 
 */
public interface TicebaogaoDao extends BaseMapper<TicebaogaoEntity> {

   List<TicebaogaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
