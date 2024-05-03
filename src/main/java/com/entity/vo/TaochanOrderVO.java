package com.entity.vo;

import com.entity.TaochanOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 套餐购买
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("taochan_order")
public class TaochanOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 套餐
     */

    @TableField(value = "taochan_id")
    private Integer taochanId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 实付价格
     */

    @TableField(value = "taochan_order_true_price")
    private Double taochanOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "taochan_order_types")
    private Integer taochanOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "taochan_order_payment_types")
    private Integer taochanOrderPaymentTypes;


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
	 * 设置：套餐
	 */
    public Integer getTaochanId() {
        return taochanId;
    }


    /**
	 * 获取：套餐
	 */

    public void setTaochanId(Integer taochanId) {
        this.taochanId = taochanId;
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
	 * 设置：实付价格
	 */
    public Double getTaochanOrderTruePrice() {
        return taochanOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setTaochanOrderTruePrice(Double taochanOrderTruePrice) {
        this.taochanOrderTruePrice = taochanOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getTaochanOrderTypes() {
        return taochanOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setTaochanOrderTypes(Integer taochanOrderTypes) {
        this.taochanOrderTypes = taochanOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getTaochanOrderPaymentTypes() {
        return taochanOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setTaochanOrderPaymentTypes(Integer taochanOrderPaymentTypes) {
        this.taochanOrderPaymentTypes = taochanOrderPaymentTypes;
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
