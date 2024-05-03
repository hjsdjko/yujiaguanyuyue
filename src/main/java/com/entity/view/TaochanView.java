package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.TaochanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 套餐
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("taochan")
public class TaochanView extends TaochanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 套餐类型的值
	*/
	@ColumnInfo(comment="套餐类型的字典表值",type="varchar(200)")
	private String taochanValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;




	public TaochanView() {

	}

	public TaochanView(TaochanEntity taochanEntity) {
		try {
			BeanUtils.copyProperties(this, taochanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 套餐类型的值
	*/
	public String getTaochanValue() {
		return taochanValue;
	}
	/**
	* 设置： 套餐类型的值
	*/
	public void setTaochanValue(String taochanValue) {
		this.taochanValue = taochanValue;
	}
	//当前表的
	/**
	* 获取： 是否上架的值
	*/
	public String getShangxiaValue() {
		return shangxiaValue;
	}
	/**
	* 设置： 是否上架的值
	*/
	public void setShangxiaValue(String shangxiaValue) {
		this.shangxiaValue = shangxiaValue;
	}




	@Override
	public String toString() {
		return "TaochanView{" +
			", taochanValue=" + taochanValue +
			", shangxiaValue=" + shangxiaValue +
			"} " + super.toString();
	}
}
