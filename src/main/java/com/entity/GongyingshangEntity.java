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
 * 供应商信息
 *
 * @author 
 * @email
 */
@TableName("gongyingshang")
public class GongyingshangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongyingshangEntity() {

	}

	public GongyingshangEntity(T t) {
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
     * 供应商唯一编号
     */
    @ColumnInfo(comment="供应商唯一编号",type="varchar(200)")
    @TableField(value = "gongyingshang_uuid_number")

    private String gongyingshangUuidNumber;


    /**
     * 供应商名称
     */
    @ColumnInfo(comment="供应商名称",type="varchar(200)")
    @TableField(value = "gongyingshang_name")

    private String gongyingshangName;


    /**
     * 联系人姓名
     */
    @ColumnInfo(comment="联系人姓名",type="varchar(200)")
    @TableField(value = "lianxiren_name")

    private String lianxirenName;


    /**
     * 联系人手机号
     */
    @ColumnInfo(comment="联系人手机号",type="varchar(200)")
    @TableField(value = "lianxiren_phone")

    private String lianxirenPhone;


    /**
     * 地址
     */
    @ColumnInfo(comment="地址",type="varchar(200)")
    @TableField(value = "lianxiren_address")

    private String lianxirenAddress;


    /**
     * 供应商类型
     */
    @ColumnInfo(comment="供应商类型",type="int(11)")
    @TableField(value = "gongyingshang_types")

    private Integer gongyingshangTypes;


    /**
     * 信用等级
     */
    @ColumnInfo(comment="信用等级",type="int(11)")
    @TableField(value = "gongyingshang_xinyongdengji_types")

    private Integer gongyingshangXinyongdengjiTypes;


    /**
     * 供应商详情
     */
    @ColumnInfo(comment="供应商详情",type="longtext")
    @TableField(value = "gongyingshang_content")

    private String gongyingshangContent;


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

    @Override
    public String toString() {
        return "Gongyingshang{" +
            ", id=" + id +
            ", gongyingshangUuidNumber=" + gongyingshangUuidNumber +
            ", gongyingshangName=" + gongyingshangName +
            ", lianxirenName=" + lianxirenName +
            ", lianxirenPhone=" + lianxirenPhone +
            ", lianxirenAddress=" + lianxirenAddress +
            ", gongyingshangTypes=" + gongyingshangTypes +
            ", gongyingshangXinyongdengjiTypes=" + gongyingshangXinyongdengjiTypes +
            ", gongyingshangContent=" + gongyingshangContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
