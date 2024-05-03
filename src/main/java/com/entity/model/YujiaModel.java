package com.entity.model;

import com.entity.YujiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 瑜伽
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YujiaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 瑜伽名称
     */
    private String yujiaName;


    /**
     * 瑜伽照片
     */
    private String yujiaPhoto;


    /**
     * 瑜伽类型
     */
    private Integer yujiaTypes;


    /**
     * 场地信息
     */
    private String yujiaAddress;


    /**
     * 教练
     */
    private Integer jiaolianId;


    /**
     * 点击次数
     */
    private Integer yujiaClicknum;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer yujiaDelete;


    /**
     * 简介详情
     */
    private String yujiaContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
