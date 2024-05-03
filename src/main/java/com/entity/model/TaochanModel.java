package com.entity.model;

import com.entity.TaochanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 套餐
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TaochanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 套餐名称
     */
    private String taochanName;


    /**
     * 套餐照片
     */
    private String taochanPhoto;


    /**
     * 套餐类型
     */
    private Integer taochanTypes;


    /**
     * 价格
     */
    private Double taochanNewMoney;


    /**
     * 点击次数
     */
    private Integer taochanClicknum;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer taochanDelete;


    /**
     * 套餐简介
     */
    private String taochanContent;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
