package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YujiaOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 瑜伽预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yujia_order")
public class YujiaOrderView extends YujiaOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String yujiaOrderValue;
	/**
	* 支付类型的值
	*/
	@ColumnInfo(comment="支付类型的字典表值",type="varchar(200)")
	private String yujiaOrderPaymentValue;

	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;
	//级联表 瑜伽
		/**
		* 瑜伽名称
		*/

		@ColumnInfo(comment="瑜伽名称",type="varchar(200)")
		private String yujiaName;
		/**
		* 瑜伽照片
		*/

		@ColumnInfo(comment="瑜伽照片",type="varchar(200)")
		private String yujiaPhoto;
		/**
		* 瑜伽类型
		*/
		@ColumnInfo(comment="瑜伽类型",type="int(11)")
		private Integer yujiaTypes;
			/**
			* 瑜伽类型的值
			*/
			@ColumnInfo(comment="瑜伽类型的字典表值",type="varchar(200)")
			private String yujiaValue;
		/**
		* 场地信息
		*/

		@ColumnInfo(comment="场地信息",type="varchar(200)")
		private String yujiaAddress;
					 
		/**
		* 瑜伽 的 教练
		*/
		@ColumnInfo(comment="教练",type="int(11)")
		private Integer yujiaJiaolianId;
		/**
		* 点击次数
		*/

		@ColumnInfo(comment="点击次数",type="int(11)")
		private Integer yujiaClicknum;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yujiaDelete;
		/**
		* 简介详情
		*/

		@ColumnInfo(comment="简介详情",type="text")
		private String yujiaContent;



	public YujiaOrderView() {

	}

	public YujiaOrderView(YujiaOrderEntity yujiaOrderEntity) {
		try {
			BeanUtils.copyProperties(this, yujiaOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getYujiaOrderValue() {
		return yujiaOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setYujiaOrderValue(String yujiaOrderValue) {
		this.yujiaOrderValue = yujiaOrderValue;
	}
	//当前表的
	/**
	* 获取： 支付类型的值
	*/
	public String getYujiaOrderPaymentValue() {
		return yujiaOrderPaymentValue;
	}
	/**
	* 设置： 支付类型的值
	*/
	public void setYujiaOrderPaymentValue(String yujiaOrderPaymentValue) {
		this.yujiaOrderPaymentValue = yujiaOrderPaymentValue;
	}


	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}
	//级联表的get和set 瑜伽

		/**
		* 获取： 瑜伽名称
		*/
		public String getYujiaName() {
			return yujiaName;
		}
		/**
		* 设置： 瑜伽名称
		*/
		public void setYujiaName(String yujiaName) {
			this.yujiaName = yujiaName;
		}

		/**
		* 获取： 瑜伽照片
		*/
		public String getYujiaPhoto() {
			return yujiaPhoto;
		}
		/**
		* 设置： 瑜伽照片
		*/
		public void setYujiaPhoto(String yujiaPhoto) {
			this.yujiaPhoto = yujiaPhoto;
		}
		/**
		* 获取： 瑜伽类型
		*/
		public Integer getYujiaTypes() {
			return yujiaTypes;
		}
		/**
		* 设置： 瑜伽类型
		*/
		public void setYujiaTypes(Integer yujiaTypes) {
			this.yujiaTypes = yujiaTypes;
		}


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

		/**
		* 获取： 场地信息
		*/
		public String getYujiaAddress() {
			return yujiaAddress;
		}
		/**
		* 设置： 场地信息
		*/
		public void setYujiaAddress(String yujiaAddress) {
			this.yujiaAddress = yujiaAddress;
		}
		/**
		* 获取：瑜伽 的 教练
		*/
		public Integer getYujiaJiaolianId() {
			return yujiaJiaolianId;
		}
		/**
		* 设置：瑜伽 的 教练
		*/
		public void setYujiaJiaolianId(Integer yujiaJiaolianId) {
			this.yujiaJiaolianId = yujiaJiaolianId;
		}

		/**
		* 获取： 点击次数
		*/
		public Integer getYujiaClicknum() {
			return yujiaClicknum;
		}
		/**
		* 设置： 点击次数
		*/
		public void setYujiaClicknum(Integer yujiaClicknum) {
			this.yujiaClicknum = yujiaClicknum;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


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

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYujiaDelete() {
			return yujiaDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYujiaDelete(Integer yujiaDelete) {
			this.yujiaDelete = yujiaDelete;
		}

		/**
		* 获取： 简介详情
		*/
		public String getYujiaContent() {
			return yujiaContent;
		}
		/**
		* 设置： 简介详情
		*/
		public void setYujiaContent(String yujiaContent) {
			this.yujiaContent = yujiaContent;
		}


	@Override
	public String toString() {
		return "YujiaOrderView{" +
			", yujiaOrderValue=" + yujiaOrderValue +
			", yujiaOrderPaymentValue=" + yujiaOrderPaymentValue +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuDelete=" + yonghuDelete +
			", yujiaName=" + yujiaName +
			", yujiaPhoto=" + yujiaPhoto +
			", yujiaAddress=" + yujiaAddress +
			", yujiaClicknum=" + yujiaClicknum +
			", yujiaDelete=" + yujiaDelete +
			", yujiaContent=" + yujiaContent +
			"} " + super.toString();
	}
}
