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
 * 套餐购买
 *
 * @author 
 * @email
 */
@TableName("taochan_order")
public class TaochanOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TaochanOrderEntity() {

	}

	public TaochanOrderEntity(T t) {
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
     * 套餐
     */
    @ColumnInfo(comment="套餐",type="int(11)")
    @TableField(value = "taochan_id")

    private Integer taochanId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "taochan_order_true_price")

    private Double taochanOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "taochan_order_types")

    private Integer taochanOrderTypes;


    /**
     * 支付类型
     */
    @ColumnInfo(comment="支付类型",type="int(11)")
    @TableField(value = "taochan_order_payment_types")

    private Integer taochanOrderPaymentTypes;


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
	 * 获取：套餐
	 */
    public Integer getTaochanId() {
        return taochanId;
    }
    /**
	 * 设置：套餐
	 */

    public void setTaochanId(Integer taochanId) {
        this.taochanId = taochanId;
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
	 * 获取：实付价格
	 */
    public Double getTaochanOrderTruePrice() {
        return taochanOrderTruePrice;
    }
    /**
	 * 设置：实付价格
	 */

    public void setTaochanOrderTruePrice(Double taochanOrderTruePrice) {
        this.taochanOrderTruePrice = taochanOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getTaochanOrderTypes() {
        return taochanOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setTaochanOrderTypes(Integer taochanOrderTypes) {
        this.taochanOrderTypes = taochanOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getTaochanOrderPaymentTypes() {
        return taochanOrderPaymentTypes;
    }
    /**
	 * 设置：支付类型
	 */

    public void setTaochanOrderPaymentTypes(Integer taochanOrderPaymentTypes) {
        this.taochanOrderPaymentTypes = taochanOrderPaymentTypes;
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
        return "TaochanOrder{" +
            ", id=" + id +
            ", taochanId=" + taochanId +
            ", yonghuId=" + yonghuId +
            ", taochanOrderTruePrice=" + taochanOrderTruePrice +
            ", taochanOrderTypes=" + taochanOrderTypes +
            ", taochanOrderPaymentTypes=" + taochanOrderPaymentTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
