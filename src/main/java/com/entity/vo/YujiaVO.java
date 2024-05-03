package com.entity.vo;

import com.entity.YujiaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 瑜伽
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yujia")
public class YujiaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 瑜伽名称
     */

    @TableField(value = "yujia_name")
    private String yujiaName;


    /**
     * 瑜伽照片
     */

    @TableField(value = "yujia_photo")
    private String yujiaPhoto;


    /**
     * 瑜伽类型
     */

    @TableField(value = "yujia_types")
    private Integer yujiaTypes;


    /**
     * 场地信息
     */

    @TableField(value = "yujia_address")
    private String yujiaAddress;


    /**
     * 教练
     */

    @TableField(value = "jiaolian_id")
    private Integer jiaolianId;


    /**
     * 点击次数
     */

    @TableField(value = "yujia_clicknum")
    private Integer yujiaClicknum;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "yujia_delete")
    private Integer yujiaDelete;


    /**
     * 简介详情
     */

    @TableField(value = "yujia_content")
    private String yujiaContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：瑜伽名称
	 */
    public String getYujiaName() {
        return yujiaName;
    }


    /**
	 * 获取：瑜伽名称
	 */

    public void setYujiaName(String yujiaName) {
        this.yujiaName = yujiaName;
    }
    /**
	 * 设置：瑜伽照片
	 */
    public String getYujiaPhoto() {
        return yujiaPhoto;
    }


    /**
	 * 获取：瑜伽照片
	 */

    public void setYujiaPhoto(String yujiaPhoto) {
        this.yujiaPhoto = yujiaPhoto;
    }
    /**
	 * 设置：瑜伽类型
	 */
    public Integer getYujiaTypes() {
        return yujiaTypes;
    }


    /**
	 * 获取：瑜伽类型
	 */

    public void setYujiaTypes(Integer yujiaTypes) {
        this.yujiaTypes = yujiaTypes;
    }
    /**
	 * 设置：场地信息
	 */
    public String getYujiaAddress() {
        return yujiaAddress;
    }


    /**
	 * 获取：场地信息
	 */

    public void setYujiaAddress(String yujiaAddress) {
        this.yujiaAddress = yujiaAddress;
    }
    /**
	 * 设置：教练
	 */
    public Integer getJiaolianId() {
        return jiaolianId;
    }


    /**
	 * 获取：教练
	 */

    public void setJiaolianId(Integer jiaolianId) {
        this.jiaolianId = jiaolianId;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getYujiaClicknum() {
        return yujiaClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setYujiaClicknum(Integer yujiaClicknum) {
        this.yujiaClicknum = yujiaClicknum;
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
    public Integer getYujiaDelete() {
        return yujiaDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYujiaDelete(Integer yujiaDelete) {
        this.yujiaDelete = yujiaDelete;
    }
    /**
	 * 设置：简介详情
	 */
    public String getYujiaContent() {
        return yujiaContent;
    }


    /**
	 * 获取：简介详情
	 */

    public void setYujiaContent(String yujiaContent) {
        this.yujiaContent = yujiaContent;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
