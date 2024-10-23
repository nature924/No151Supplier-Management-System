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
 * 商品退货
 *
 * @author 
 * @email
 */
@TableName("tuihuodan")
public class TuihuodanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TuihuodanEntity() {

	}

	public TuihuodanEntity(T t) {
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
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 供应商
     */
    @ColumnInfo(comment="供应商",type="int(11)")
    @TableField(value = "gongyingshang_id")

    private Integer gongyingshangId;


    /**
     * 退货单编号
     */
    @ColumnInfo(comment="退货单编号",type="varchar(200)")
    @TableField(value = "tuihuodan_uuid_number")

    private String tuihuodanUuidNumber;


    /**
     * 退货单名称
     */
    @ColumnInfo(comment="退货单名称",type="varchar(200)")
    @TableField(value = "tuihuodan_name")

    private String tuihuodanName;


    /**
     * 退货单
     */
    @ColumnInfo(comment="退货单",type="varchar(200)")
    @TableField(value = "tuihuodan_file")

    private String tuihuodanFile;


    /**
     * 退货类型
     */
    @ColumnInfo(comment="退货类型",type="int(11)")
    @TableField(value = "tuihuodan_types")

    private Integer tuihuodanTypes;


    /**
     * 退货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="退货时间",type="timestamp")
    @TableField(value = "caozuo_time")

    private Date caozuoTime;


    /**
     * 退货单内容
     */
    @ColumnInfo(comment="退货单内容",type="longtext")
    @TableField(value = "tuihuodan_content")

    private String tuihuodanContent;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "tuihuodan_beizhu_content")

    private String tuihuodanBeizhuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }
    /**
	 * 设置：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：供应商
	 */
    public Integer getGongyingshangId() {
        return gongyingshangId;
    }
    /**
	 * 设置：供应商
	 */

    public void setGongyingshangId(Integer gongyingshangId) {
        this.gongyingshangId = gongyingshangId;
    }
    /**
	 * 获取：退货单编号
	 */
    public String getTuihuodanUuidNumber() {
        return tuihuodanUuidNumber;
    }
    /**
	 * 设置：退货单编号
	 */

    public void setTuihuodanUuidNumber(String tuihuodanUuidNumber) {
        this.tuihuodanUuidNumber = tuihuodanUuidNumber;
    }
    /**
	 * 获取：退货单名称
	 */
    public String getTuihuodanName() {
        return tuihuodanName;
    }
    /**
	 * 设置：退货单名称
	 */

    public void setTuihuodanName(String tuihuodanName) {
        this.tuihuodanName = tuihuodanName;
    }
    /**
	 * 获取：退货单
	 */
    public String getTuihuodanFile() {
        return tuihuodanFile;
    }
    /**
	 * 设置：退货单
	 */

    public void setTuihuodanFile(String tuihuodanFile) {
        this.tuihuodanFile = tuihuodanFile;
    }
    /**
	 * 获取：退货类型
	 */
    public Integer getTuihuodanTypes() {
        return tuihuodanTypes;
    }
    /**
	 * 设置：退货类型
	 */

    public void setTuihuodanTypes(Integer tuihuodanTypes) {
        this.tuihuodanTypes = tuihuodanTypes;
    }
    /**
	 * 获取：退货时间
	 */
    public Date getCaozuoTime() {
        return caozuoTime;
    }
    /**
	 * 设置：退货时间
	 */

    public void setCaozuoTime(Date caozuoTime) {
        this.caozuoTime = caozuoTime;
    }
    /**
	 * 获取：退货单内容
	 */
    public String getTuihuodanContent() {
        return tuihuodanContent;
    }
    /**
	 * 设置：退货单内容
	 */

    public void setTuihuodanContent(String tuihuodanContent) {
        this.tuihuodanContent = tuihuodanContent;
    }
    /**
	 * 获取：备注
	 */
    public String getTuihuodanBeizhuContent() {
        return tuihuodanBeizhuContent;
    }
    /**
	 * 设置：备注
	 */

    public void setTuihuodanBeizhuContent(String tuihuodanBeizhuContent) {
        this.tuihuodanBeizhuContent = tuihuodanBeizhuContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Tuihuodan{" +
            ", id=" + id +
            ", yuangongId=" + yuangongId +
            ", gongyingshangId=" + gongyingshangId +
            ", tuihuodanUuidNumber=" + tuihuodanUuidNumber +
            ", tuihuodanName=" + tuihuodanName +
            ", tuihuodanFile=" + tuihuodanFile +
            ", tuihuodanTypes=" + tuihuodanTypes +
            ", caozuoTime=" + DateUtil.convertString(caozuoTime,"yyyy-MM-dd") +
            ", tuihuodanContent=" + tuihuodanContent +
            ", tuihuodanBeizhuContent=" + tuihuodanBeizhuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
