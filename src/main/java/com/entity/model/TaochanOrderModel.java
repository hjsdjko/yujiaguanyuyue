package com.entity.model;

import com.entity.TaochanOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 套餐购买
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TaochanOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 套餐
     */
    private Integer taochanId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 实付价格
     */
    private Double taochanOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer taochanOrderTypes;


    /**
     * 支付类型
     */
    private Integer taochanOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
