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
 * 体测报告
 *
 * @author 
 * @email
 */
@TableName("ticebaogao")
public class TicebaogaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TicebaogaoEntity() {

	}

	public TicebaogaoEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 报告标题
     */
    @ColumnInfo(comment="报告标题",type="varchar(200)")
    @TableField(value = "ticebaogao_name")

    private String ticebaogaoName;


    /**
     * 报告类型
     */
    @ColumnInfo(comment="报告类型",type="int(11)")
    @TableField(value = "ticebaogao_types")

    private Integer ticebaogaoTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报告详情
     */
    @ColumnInfo(comment="报告详情",type="text")
    @TableField(value = "ticebaogao_content")

    private String ticebaogaoContent;


    /**
     * 创建时间  listShow
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
	 * 获取：报告标题
	 */
    public String getTicebaogaoName() {
        return ticebaogaoName;
    }
    /**
	 * 设置：报告标题
	 */

    public void setTicebaogaoName(String ticebaogaoName) {
        this.ticebaogaoName = ticebaogaoName;
    }
    /**
	 * 获取：报告类型
	 */
    public Integer getTicebaogaoTypes() {
        return ticebaogaoTypes;
    }
    /**
	 * 设置：报告类型
	 */

    public void setTicebaogaoTypes(Integer ticebaogaoTypes) {
        this.ticebaogaoTypes = ticebaogaoTypes;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报告详情
	 */
    public String getTicebaogaoContent() {
        return ticebaogaoContent;
    }
    /**
	 * 设置：报告详情
	 */

    public void setTicebaogaoContent(String ticebaogaoContent) {
        this.ticebaogaoContent = ticebaogaoContent;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Ticebaogao{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", ticebaogaoName=" + ticebaogaoName +
            ", ticebaogaoTypes=" + ticebaogaoTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", ticebaogaoContent=" + ticebaogaoContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
