package com.dao;

import com.entity.YujiaOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YujiaOrderView;

/**
 * 瑜伽预约 Dao 接口
 *
 * @author 
 */
public interface YujiaOrderDao extends BaseMapper<YujiaOrderEntity> {

   List<YujiaOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
