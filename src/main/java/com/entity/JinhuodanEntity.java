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
 * 商品进货
 *
 * @author 
 * @email
 */
@TableName("jinhuodan")
public class JinhuodanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JinhuodanEntity() {

	}

	public JinhuodanEntity(T t) {
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
     * 进货单编号
     */
    @ColumnInfo(comment="进货单编号",type="varchar(200)")
    @TableField(value = "jinhuodan_uuid_number")

    private String jinhuodanUuidNumber;


    /**
     * 进货单名称
     */
    @ColumnInfo(comment="进货单名称",type="varchar(200)")
    @TableField(value = "jinhuodan_name")

    private String jinhuodanName;


    /**
     * 进货单
     */
    @ColumnInfo(comment="进货单",type="varchar(200)")
    @TableField(value = "jinhuodan_file")

    private String jinhuodanFile;


    /**
     * 进货类型
     */
    @ColumnInfo(comment="进货类型",type="int(11)")
    @TableField(value = "jinhuodan_types")

    private Integer jinhuodanTypes;


    /**
     * 进货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="进货时间",type="timestamp")
    @TableField(value = "caozuo_time")

    private Date caozuoTime;


    /**
     * 进货单内容
     */
    @ColumnInfo(comment="进货单内容",type="longtext")
    @TableField(value = "jinhuodan_content")

    private String jinhuodanContent;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "jinhuodan_beizhu_content")

    private String jinhuodanBeizhuContent;


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
	 * 获取：进货单编号
	 */
    public String getJinhuodanUuidNumber() {
        return jinhuodanUuidNumber;
    }
    /**
	 * 设置：进货单编号
	 */

    public void setJinhuodanUuidNumber(String jinhuodanUuidNumber) {
        this.jinhuodanUuidNumber = jinhuodanUuidNumber;
    }
    /**
	 * 获取：进货单名称
	 */
    public String getJinhuodanName() {
        return jinhuodanName;
    }
    /**
	 * 设置：进货单名称
	 */

    public void setJinhuodanName(String jinhuodanName) {
        this.jinhuodanName = jinhuodanName;
    }
    /**
	 * 获取：进货单
	 */
    public String getJinhuodanFile() {
        return jinhuodanFile;
    }
    /**
	 * 设置：进货单
	 */

    public void setJinhuodanFile(String jinhuodanFile) {
        this.jinhuodanFile = jinhuodanFile;
    }
    /**
	 * 获取：进货类型
	 */
    public Integer getJinhuodanTypes() {
        return jinhuodanTypes;
    }
    /**
	 * 设置：进货类型
	 */

    public void setJinhuodanTypes(Integer jinhuodanTypes) {
        this.jinhuodanTypes = jinhuodanTypes;
    }
    /**
	 * 获取：进货时间
	 */
    public Date getCaozuoTime() {
        return caozuoTime;
    }
    /**
	 * 设置：进货时间
	 */

    public void setCaozuoTime(Date caozuoTime) {
        this.caozuoTime = caozuoTime;
    }
    /**
	 * 获取：进货单内容
	 */
    public String getJinhuodanContent() {
        return jinhuodanContent;
    }
    /**
	 * 设置：进货单内容
	 */

    public void setJinhuodanContent(String jinhuodanContent) {
        this.jinhuodanContent = jinhuodanContent;
    }
    /**
	 * 获取：备注
	 */
    public String getJinhuodanBeizhuContent() {
        return jinhuodanBeizhuContent;
    }
    /**
	 * 设置：备注
	 */

    public void setJinhuodanBeizhuContent(String jinhuodanBeizhuContent) {
        this.jinhuodanBeizhuContent = jinhuodanBeizhuContent;
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
        return "Jinhuodan{" +
            ", id=" + id +
            ", yuangongId=" + yuangongId +
            ", gongyingshangId=" + gongyingshangId +
            ", jinhuodanUuidNumber=" + jinhuodanUuidNumber +
            ", jinhuodanName=" + jinhuodanName +
            ", jinhuodanFile=" + jinhuodanFile +
            ", jinhuodanTypes=" + jinhuodanTypes +
            ", caozuoTime=" + DateUtil.convertString(caozuoTime,"yyyy-MM-dd") +
            ", jinhuodanContent=" + jinhuodanContent +
            ", jinhuodanBeizhuContent=" + jinhuodanBeizhuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
