package com.entity.model;

import com.entity.YujiaOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 瑜伽预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YujiaOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 瑜伽
     */
    private Integer yujiaId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yujiaOrderTime;


    /**
     * 订单类型
     */
    private Integer yujiaOrderTypes;


    /**
     * 支付类型
     */
    private Integer yujiaOrderPaymentTypes;


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
