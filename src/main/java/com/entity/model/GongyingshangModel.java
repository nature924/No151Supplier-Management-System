package com.entity.model;

import com.entity.GongyingshangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 供应商信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongyingshangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 供应商唯一编号
     */
    private String gongyingshangUuidNumber;


    /**
     * 供应商名称
     */
    private String gongyingshangName;


    /**
     * 联系人姓名
     */
    private String lianxirenName;


    /**
     * 联系人手机号
     */
    private String lianxirenPhone;


    /**
     * 地址
     */
    private String lianxirenAddress;


    /**
     * 供应商类型
     */
    private Integer gongyingshangTypes;


    /**
     * 信用等级
     */
    private Integer gongyingshangXinyongdengjiTypes;


    /**
     * 供应商详情
     */
    private String gongyingshangContent;


    /**
     * 创建时间
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
	 * 获取：供应商唯一编号
	 */
    public String getGongyingshangUuidNumber() {
        return gongyingshangUuidNumber;
    }


    /**
	 * 设置：供应商唯一编号
	 */
    public void setGongyingshangUuidNumber(String gongyingshangUuidNumber) {
        this.gongyingshangUuidNumber = gongyingshangUuidNumber;
    }
    /**
	 * 获取：供应商名称
	 */
    public String getGongyingshangName() {
        return gongyingshangName;
    }


    /**
	 * 设置：供应商名称
	 */
    public void setGongyingshangName(String gongyingshangName) {
        this.gongyingshangName = gongyingshangName;
    }
    /**
	 * 获取：联系人姓名
	 */
    public String getLianxirenName() {
        return lianxirenName;
    }


    /**
	 * 设置：联系人姓名
	 */
    public void setLianxirenName(String lianxirenName) {
        this.lianxirenName = lianxirenName;
    }
    /**
	 * 获取：联系人手机号
	 */
    public String getLianxirenPhone() {
        return lianxirenPhone;
    }


    /**
	 * 设置：联系人手机号
	 */
    public void setLianxirenPhone(String lianxirenPhone) {
        this.lianxirenPhone = lianxirenPhone;
    }
    /**
	 * 获取：地址
	 */
    public String getLianxirenAddress() {
        return lianxirenAddress;
    }


    /**
	 * 设置：地址
	 */
    public void setLianxirenAddress(String lianxirenAddress) {
        this.lianxirenAddress = lianxirenAddress;
    }
    /**
	 * 获取：供应商类型
	 */
    public Integer getGongyingshangTypes() {
        return gongyingshangTypes;
    }


    /**
	 * 设置：供应商类型
	 */
    public void setGongyingshangTypes(Integer gongyingshangTypes) {
        this.gongyingshangTypes = gongyingshangTypes;
    }
    /**
	 * 获取：信用等级
	 */
    public Integer getGongyingshangXinyongdengjiTypes() {
        return gongyingshangXinyongdengjiTypes;
    }


    /**
	 * 设置：信用等级
	 */
    public void setGongyingshangXinyongdengjiTypes(Integer gongyingshangXinyongdengjiTypes) {
        this.gongyingshangXinyongdengjiTypes = gongyingshangXinyongdengjiTypes;
    }
    /**
	 * 获取：供应商详情
	 */
    public String getGongyingshangContent() {
        return gongyingshangContent;
    }


    /**
	 * 设置：供应商详情
	 */
    public void setGongyingshangContent(String gongyingshangContent) {
        this.gongyingshangContent = gongyingshangContent;
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

    }
