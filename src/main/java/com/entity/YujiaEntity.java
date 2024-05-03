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
 * 瑜伽
 *
 * @author 
 * @email
 */
@TableName("yujia")
public class YujiaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YujiaEntity() {

	}

	public YujiaEntity(T t) {
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
     * 瑜伽名称
     */
    @ColumnInfo(comment="瑜伽名称",type="varchar(200)")
    @TableField(value = "yujia_name")

    private String yujiaName;


    /**
     * 瑜伽照片
     */
    @ColumnInfo(comment="瑜伽照片",type="varchar(200)")
    @TableField(value = "yujia_photo")

    private String yujiaPhoto;


    /**
     * 瑜伽类型
     */
    @ColumnInfo(comment="瑜伽类型",type="int(11)")
    @TableField(value = "yujia_types")

    private Integer yujiaTypes;


    /**
     * 场地信息
     */
    @ColumnInfo(comment="场地信息",type="varchar(200)")
    @TableField(value = "yujia_address")

    private String yujiaAddress;


    /**
     * 教练
     */
    @ColumnInfo(comment="教练",type="int(11)")
    @TableField(value = "jiaolian_id")

    private Integer jiaolianId;


    /**
     * 点击次数
     */
    @ColumnInfo(comment="点击次数",type="int(11)")
    @TableField(value = "yujia_clicknum")

    private Integer yujiaClicknum;


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
    @TableField(value = "yujia_delete")

    private Integer yujiaDelete;


    /**
     * 简介详情
     */
    @ColumnInfo(comment="简介详情",type="text")
    @TableField(value = "yujia_content")

    private String yujiaContent;


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
	 * 获取：瑜伽名称
	 */
    public String getYujiaName() {
        return yujiaName;
    }
    /**
	 * 设置：瑜伽名称
	 */

    public void setYujiaName(String yujiaName) {
        this.yujiaName = yujiaName;
    }
    /**
	 * 获取：瑜伽照片
	 */
    public String getYujiaPhoto() {
        return yujiaPhoto;
    }
    /**
	 * 设置：瑜伽照片
	 */

    public void setYujiaPhoto(String yujiaPhoto) {
        this.yujiaPhoto = yujiaPhoto;
    }
    /**
	 * 获取：瑜伽类型
	 */
    public Integer getYujiaTypes() {
        return yujiaTypes;
    }
    /**
	 * 设置：瑜伽类型
	 */

    public void setYujiaTypes(Integer yujiaTypes) {
        this.yujiaTypes = yujiaTypes;
    }
    /**
	 * 获取：场地信息
	 */
    public String getYujiaAddress() {
        return yujiaAddress;
    }
    /**
	 * 设置：场地信息
	 */

    public void setYujiaAddress(String yujiaAddress) {
        this.yujiaAddress = yujiaAddress;
    }
    /**
	 * 获取：教练
	 */
    public Integer getJiaolianId() {
        return jiaolianId;
    }
    /**
	 * 设置：教练
	 */

    public void setJiaolianId(Integer jiaolianId) {
        this.jiaolianId = jiaolianId;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getYujiaClicknum() {
        return yujiaClicknum;
    }
    /**
	 * 设置：点击次数
	 */

    public void setYujiaClicknum(Integer yujiaClicknum) {
        this.yujiaClicknum = yujiaClicknum;
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
    public Integer getYujiaDelete() {
        return yujiaDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setYujiaDelete(Integer yujiaDelete) {
        this.yujiaDelete = yujiaDelete;
    }
    /**
	 * 获取：简介详情
	 */
    public String getYujiaContent() {
        return yujiaContent;
    }
    /**
	 * 设置：简介详情
	 */

    public void setYujiaContent(String yujiaContent) {
        this.yujiaContent = yujiaContent;
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
        return "Yujia{" +
            ", id=" + id +
            ", yujiaName=" + yujiaName +
            ", yujiaPhoto=" + yujiaPhoto +
            ", yujiaTypes=" + yujiaTypes +
            ", yujiaAddress=" + yujiaAddress +
            ", jiaolianId=" + jiaolianId +
            ", yujiaClicknum=" + yujiaClicknum +
            ", shangxiaTypes=" + shangxiaTypes +
            ", yujiaDelete=" + yujiaDelete +
            ", yujiaContent=" + yujiaContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
