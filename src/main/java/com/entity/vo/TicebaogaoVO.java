package com.entity.vo;

import com.entity.TicebaogaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 体测报告
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("ticebaogao")
public class TicebaogaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 报告标题
     */

    @TableField(value = "ticebaogao_name")
    private String ticebaogaoName;


    /**
     * 报告类型
     */

    @TableField(value = "ticebaogao_types")
    private Integer ticebaogaoTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报告详情
     */

    @TableField(value = "ticebaogao_content")
    private String ticebaogaoContent;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：报告标题
	 */
    public String getTicebaogaoName() {
        return ticebaogaoName;
    }


    /**
	 * 获取：报告标题
	 */

    public void setTicebaogaoName(String ticebaogaoName) {
        this.ticebaogaoName = ticebaogaoName;
    }
    /**
	 * 设置：报告类型
	 */
    public Integer getTicebaogaoTypes() {
        return ticebaogaoTypes;
    }


    /**
	 * 获取：报告类型
	 */

    public void setTicebaogaoTypes(Integer ticebaogaoTypes) {
        this.ticebaogaoTypes = ticebaogaoTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报告详情
	 */
    public String getTicebaogaoContent() {
        return ticebaogaoContent;
    }


    /**
	 * 获取：报告详情
	 */

    public void setTicebaogaoContent(String ticebaogaoContent) {
        this.ticebaogaoContent = ticebaogaoContent;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
