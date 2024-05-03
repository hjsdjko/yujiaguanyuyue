package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 瑜伽预约
 *
 * @author 
 * @email
 */
@TableName("yujia_order")
public class YujiaOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YujiaOrderEntity() {

	}

	public YujiaOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 瑜伽
     */
    @ColumnInfo(comment="瑜伽",type="int(11)")
    @TableField(value = "yujia_id")

    private Integer yujiaId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "yujia_order_time")

    private Date yujiaOrderTime;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "yujia_order_types")

    private Integer yujiaOrderTypes;


    /**
     * 支付类型
     */
    @ColumnInfo(comment="支付类型",type="int(11)")
    @TableField(value = "yujia_order_payment_types")

    private Integer yujiaOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：瑜伽
	 */
    public Integer getYujiaId() {
        return yujiaId;
    }
    /**
	 * 设置：瑜伽
	 */

    public void setYujiaId(Integer yujiaId) {
        this.yujiaId = yujiaId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getYujiaOrderTime() {
        return yujiaOrderTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setYujiaOrderTime(Date yujiaOrderTime) {
        this.yujiaOrderTime = yujiaOrderTime;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getYujiaOrderTypes() {
        return yujiaOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setYujiaOrderTypes(Integer yujiaOrderTypes) {
        this.yujiaOrderTypes = yujiaOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getYujiaOrderPaymentTypes() {
        return yujiaOrderPaymentTypes;
    }
    /**
	 * 设置：支付类型
	 */

    public void setYujiaOrderPaymentTypes(Integer yujiaOrderPaymentTypes) {
        this.yujiaOrderPaymentTypes = yujiaOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "YujiaOrder{" +
            ", id=" + id +
            ", yujiaId=" + yujiaId +
            ", yonghuId=" + yonghuId +
            ", yujiaOrderTime=" + DateUtil.convertString(yujiaOrderTime,"yyyy-MM-dd") +
            ", yujiaOrderTypes=" + yujiaOrderTypes +
            ", yujiaOrderPaymentTypes=" + yujiaOrderPaymentTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
