package com.entity.vo;

import com.entity.YujiaOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 瑜伽预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yujia_order")
public class YujiaOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 瑜伽
     */

    @TableField(value = "yujia_id")
    private Integer yujiaId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yujia_order_time")
    private Date yujiaOrderTime;


    /**
     * 订单类型
     */

    @TableField(value = "yujia_order_types")
    private Integer yujiaOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "yujia_order_payment_types")
    private Integer yujiaOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：瑜伽
	 */
    public Integer getYujiaId() {
        return yujiaId;
    }


    /**
	 * 获取：瑜伽
	 */

    public void setYujiaId(Integer yujiaId) {
        this.yujiaId = yujiaId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getYujiaOrderTime() {
        return yujiaOrderTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setYujiaOrderTime(Date yujiaOrderTime) {
        this.yujiaOrderTime = yujiaOrderTime;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getYujiaOrderTypes() {
        return yujiaOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setYujiaOrderTypes(Integer yujiaOrderTypes) {
        this.yujiaOrderTypes = yujiaOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getYujiaOrderPaymentTypes() {
        return yujiaOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setYujiaOrderPaymentTypes(Integer yujiaOrderPaymentTypes) {
        this.yujiaOrderPaymentTypes = yujiaOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
