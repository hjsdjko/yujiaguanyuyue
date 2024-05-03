package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.TaochanOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 套餐购买
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("taochan_order")
public class TaochanOrderView extends TaochanOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String taochanOrderValue;
	/**
	* 支付类型的值
	*/
	@ColumnInfo(comment="支付类型的字典表值",type="varchar(200)")
	private String taochanOrderPaymentValue;

	//级联表 套餐
		/**
		* 套餐名称
		*/

		@ColumnInfo(comment="套餐名称",type="varchar(200)")
		private String taochanName;
		/**
		* 套餐照片
		*/

		@ColumnInfo(comment="套餐照片",type="varchar(200)")
		private String taochanPhoto;
		/**
		* 套餐类型
		*/
		@ColumnInfo(comment="套餐类型",type="int(11)")
		private Integer taochanTypes;
			/**
			* 套餐类型的值
			*/
			@ColumnInfo(comment="套餐类型的字典表值",type="varchar(200)")
			private String taochanValue;
		/**
		* 价格
		*/
		@ColumnInfo(comment="价格",type="decimal(10,2)")
		private Double taochanNewMoney;
		/**
		* 点击次数
		*/

		@ColumnInfo(comment="点击次数",type="int(11)")
		private Integer taochanClicknum;
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
		private Integer taochanDelete;
		/**
		* 套餐简介
		*/

		@ColumnInfo(comment="套餐简介",type="text")
		private String taochanContent;
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



	public TaochanOrderView() {

	}

	public TaochanOrderView(TaochanOrderEntity taochanOrderEntity) {
		try {
			BeanUtils.copyProperties(this, taochanOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getTaochanOrderValue() {
		return taochanOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setTaochanOrderValue(String taochanOrderValue) {
		this.taochanOrderValue = taochanOrderValue;
	}
	//当前表的
	/**
	* 获取： 支付类型的值
	*/
	public String getTaochanOrderPaymentValue() {
		return taochanOrderPaymentValue;
	}
	/**
	* 设置： 支付类型的值
	*/
	public void setTaochanOrderPaymentValue(String taochanOrderPaymentValue) {
		this.taochanOrderPaymentValue = taochanOrderPaymentValue;
	}


	//级联表的get和set 套餐

		/**
		* 获取： 套餐名称
		*/
		public String getTaochanName() {
			return taochanName;
		}
		/**
		* 设置： 套餐名称
		*/
		public void setTaochanName(String taochanName) {
			this.taochanName = taochanName;
		}

		/**
		* 获取： 套餐照片
		*/
		public String getTaochanPhoto() {
			return taochanPhoto;
		}
		/**
		* 设置： 套餐照片
		*/
		public void setTaochanPhoto(String taochanPhoto) {
			this.taochanPhoto = taochanPhoto;
		}
		/**
		* 获取： 套餐类型
		*/
		public Integer getTaochanTypes() {
			return taochanTypes;
		}
		/**
		* 设置： 套餐类型
		*/
		public void setTaochanTypes(Integer taochanTypes) {
			this.taochanTypes = taochanTypes;
		}


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

		/**
		* 获取： 价格
		*/
		public Double getTaochanNewMoney() {
			return taochanNewMoney;
		}
		/**
		* 设置： 价格
		*/
		public void setTaochanNewMoney(Double taochanNewMoney) {
			this.taochanNewMoney = taochanNewMoney;
		}

		/**
		* 获取： 点击次数
		*/
		public Integer getTaochanClicknum() {
			return taochanClicknum;
		}
		/**
		* 设置： 点击次数
		*/
		public void setTaochanClicknum(Integer taochanClicknum) {
			this.taochanClicknum = taochanClicknum;
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
		public Integer getTaochanDelete() {
			return taochanDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setTaochanDelete(Integer taochanDelete) {
			this.taochanDelete = taochanDelete;
		}

		/**
		* 获取： 套餐简介
		*/
		public String getTaochanContent() {
			return taochanContent;
		}
		/**
		* 设置： 套餐简介
		*/
		public void setTaochanContent(String taochanContent) {
			this.taochanContent = taochanContent;
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


	@Override
	public String toString() {
		return "TaochanOrderView{" +
			", taochanOrderValue=" + taochanOrderValue +
			", taochanOrderPaymentValue=" + taochanOrderPaymentValue +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuDelete=" + yonghuDelete +
			", taochanName=" + taochanName +
			", taochanPhoto=" + taochanPhoto +
			", taochanNewMoney=" + taochanNewMoney +
			", taochanClicknum=" + taochanClicknum +
			", taochanDelete=" + taochanDelete +
			", taochanContent=" + taochanContent +
			"} " + super.toString();
	}
}
