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
 * 套餐
 *
 * @author 
 * @email
 */
@TableName("taochan")
public class TaochanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TaochanEntity() {

	}

	public TaochanEntity(T t) {
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
     * 套餐名称
     */
    @ColumnInfo(comment="套餐名称",type="varchar(200)")
    @TableField(value = "taochan_name")

    private String taochanName;


    /**
     * 套餐照片
     */
    @ColumnInfo(comment="套餐照片",type="varchar(200)")
    @TableField(value = "taochan_photo")

    private String taochanPhoto;


    /**
     * 套餐类型
     */
    @ColumnInfo(comment="套餐类型",type="int(11)")
    @TableField(value = "taochan_types")

    private Integer taochanTypes;


    /**
     * 价格
     */
    @ColumnInfo(comment="价格",type="decimal(10,2)")
    @TableField(value = "taochan_new_money")

    private Double taochanNewMoney;


    /**
     * 点击次数
     */
    @ColumnInfo(comment="点击次数",type="int(11)")
    @TableField(value = "taochan_clicknum")

    private Integer taochanClicknum;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "taochan_delete")

    private Integer taochanDelete;


    /**
     * 套餐简介
     */
    @ColumnInfo(comment="套餐简介",type="text")
    @TableField(value = "taochan_content")

    private String taochanContent;


    /**
     * 创建时间     homeMain
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
	 * 获取：套餐名称
	 */
    public String getTaochanName() {
        return taochanName;
    }
    /**
	 * 设置：套餐名称
	 */

    public void setTaochanName(String taochanName) {
        this.taochanName = taochanName;
    }
    /**
	 * 获取：套餐照片
	 */
    public String getTaochanPhoto() {
        return taochanPhoto;
    }
    /**
	 * 设置：套餐照片
	 */

    public void setTaochanPhoto(String taochanPhoto) {
        this.taochanPhoto = taochanPhoto;
    }
    /**
	 * 获取：套餐类型
	 */
    public Integer getTaochanTypes() {
        return taochanTypes;
    }
    /**
	 * 设置：套餐类型
	 */

    public void setTaochanTypes(Integer taochanTypes) {
        this.taochanTypes = taochanTypes;
    }
    /**
	 * 获取：价格
	 */
    public Double getTaochanNewMoney() {
        return taochanNewMoney;
    }
    /**
	 * 设置：价格
	 */

    public void setTaochanNewMoney(Double taochanNewMoney) {
        this.taochanNewMoney = taochanNewMoney;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getTaochanClicknum() {
        return taochanClicknum;
    }
    /**
	 * 设置：点击次数
	 */

    public void setTaochanClicknum(Integer taochanClicknum) {
        this.taochanClicknum = taochanClicknum;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getTaochanDelete() {
        return taochanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setTaochanDelete(Integer taochanDelete) {
        this.taochanDelete = taochanDelete;
    }
    /**
	 * 获取：套餐简介
	 */
    public String getTaochanContent() {
        return taochanContent;
    }
    /**
	 * 设置：套餐简介
	 */

    public void setTaochanContent(String taochanContent) {
        this.taochanContent = taochanContent;
    }
    /**
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Taochan{" +
            ", id=" + id +
            ", taochanName=" + taochanName +
            ", taochanPhoto=" + taochanPhoto +
            ", taochanTypes=" + taochanTypes +
            ", taochanNewMoney=" + taochanNewMoney +
            ", taochanClicknum=" + taochanClicknum +
            ", shangxiaTypes=" + shangxiaTypes +
            ", taochanDelete=" + taochanDelete +
            ", taochanContent=" + taochanContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
