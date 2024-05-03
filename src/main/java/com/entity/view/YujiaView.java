package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YujiaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 瑜伽
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yujia")
public class YujiaView extends YujiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 瑜伽类型的值
	*/
	@ColumnInfo(comment="瑜伽类型的字典表值",type="varchar(200)")
	private String yujiaValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;

	//级联表 教练
		/**
		* 教练姓名
		*/

		@ColumnInfo(comment="教练姓名",type="varchar(200)")
		private String jiaolianName;
		/**
		* 教练头像
		*/

		@ColumnInfo(comment="教练头像",type="varchar(200)")
		private String jiaolianPhoto;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String jiaolianIdNumber;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String jiaolianPhone;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String jiaolianEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer jiaolianDelete;



	public YujiaView() {

	}

	public YujiaView(YujiaEntity yujiaEntity) {
		try {
			BeanUtils.copyProperties(this, yujiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 瑜伽类型的值
	*/
	public String getYujiaValue() {
		return yujiaValue;
	}
	/**
	* 设置： 瑜伽类型的值
	*/
	public void setYujiaValue(String yujiaValue) {
		this.yujiaValue = yujiaValue;
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


	//级联表的get和set 教练

		/**
		* 获取： 教练姓名
		*/
		public String getJiaolianName() {
			return jiaolianName;
		}
		/**
		* 设置： 教练姓名
		*/
		public void setJiaolianName(String jiaolianName) {
			this.jiaolianName = jiaolianName;
		}

		/**
		* 获取： 教练头像
		*/
		public String getJiaolianPhoto() {
			return jiaolianPhoto;
		}
		/**
		* 设置： 教练头像
		*/
		public void setJiaolianPhoto(String jiaolianPhoto) {
			this.jiaolianPhoto = jiaolianPhoto;
		}

		/**
		* 获取： 身份证号
		*/
		public String getJiaolianIdNumber() {
			return jiaolianIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setJiaolianIdNumber(String jiaolianIdNumber) {
			this.jiaolianIdNumber = jiaolianIdNumber;
		}

		/**
		* 获取： 联系方式
		*/
		public String getJiaolianPhone() {
			return jiaolianPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setJiaolianPhone(String jiaolianPhone) {
			this.jiaolianPhone = jiaolianPhone;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getJiaolianEmail() {
			return jiaolianEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setJiaolianEmail(String jiaolianEmail) {
			this.jiaolianEmail = jiaolianEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJiaolianDelete() {
			return jiaolianDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJiaolianDelete(Integer jiaolianDelete) {
			this.jiaolianDelete = jiaolianDelete;
		}


	@Override
	public String toString() {
		return "YujiaView{" +
			", yujiaValue=" + yujiaValue +
			", shangxiaValue=" + shangxiaValue +
			", jiaolianName=" + jiaolianName +
			", jiaolianPhoto=" + jiaolianPhoto +
			", jiaolianIdNumber=" + jiaolianIdNumber +
			", jiaolianPhone=" + jiaolianPhone +
			", jiaolianEmail=" + jiaolianEmail +
			", jiaolianDelete=" + jiaolianDelete +
			"} " + super.toString();
	}
}
