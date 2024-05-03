package com.entity.vo;

import com.entity.TaochanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 套餐
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("taochan")
public class TaochanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 套餐名称
     */

    @TableField(value = "taochan_name")
    private String taochanName;


    /**
     * 套餐照片
     */

    @TableField(value = "taochan_photo")
    private String taochanPhoto;


    /**
     * 套餐类型
     */

    @TableField(value = "taochan_types")
    private Integer taochanTypes;


    /**
     * 价格
     */

    @TableField(value = "taochan_new_money")
    private Double taochanNewMoney;


    /**
     * 点击次数
     */

    @TableField(value = "taochan_clicknum")
    private Integer taochanClicknum;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "taochan_delete")
    private Integer taochanDelete;


    /**
     * 套餐简介
     */

    @TableField(value = "taochan_content")
    private String taochanContent;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 设置：套餐名称
	 */
    public String getTaochanName() {
        return taochanName;
    }


    /**
	 * 获取：套餐名称
	 */

    public void setTaochanName(String taochanName) {
        this.taochanName = taochanName;
    }
    /**
	 * 设置：套餐照片
	 */
    public String getTaochanPhoto() {
        return taochanPhoto;
    }


    /**
	 * 获取：套餐照片
	 */

    public void setTaochanPhoto(String taochanPhoto) {
        this.taochanPhoto = taochanPhoto;
    }
    /**
	 * 设置：套餐类型
	 */
    public Integer getTaochanTypes() {
        return taochanTypes;
    }


    /**
	 * 获取：套餐类型
	 */

    public void setTaochanTypes(Integer taochanTypes) {
        this.taochanTypes = taochanTypes;
    }
    /**
	 * 设置：价格
	 */
    public Double getTaochanNewMoney() {
        return taochanNewMoney;
    }


    /**
	 * 获取：价格
	 */

    public void setTaochanNewMoney(Double taochanNewMoney) {
        this.taochanNewMoney = taochanNewMoney;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getTaochanClicknum() {
        return taochanClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setTaochanClicknum(Integer taochanClicknum) {
        this.taochanClicknum = taochanClicknum;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getTaochanDelete() {
        return taochanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setTaochanDelete(Integer taochanDelete) {
        this.taochanDelete = taochanDelete;
    }
    /**
	 * 设置：套餐简介
	 */
    public String getTaochanContent() {
        return taochanContent;
    }


    /**
	 * 获取：套餐简介
	 */

    public void setTaochanContent(String taochanContent) {
        this.taochanContent = taochanContent;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
