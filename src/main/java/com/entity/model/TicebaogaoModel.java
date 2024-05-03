package com.entity.model;

import com.entity.TicebaogaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 体测报告
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TicebaogaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 报告标题
     */
    private String ticebaogaoName;


    /**
     * 报告类型
     */
    private Integer ticebaogaoTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报告详情
     */
    private String ticebaogaoContent;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
