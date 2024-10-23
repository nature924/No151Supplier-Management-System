package com.entity.vo;

import com.entity.JinhuodanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品进货
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jinhuodan")
public class JinhuodanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 供应商
     */

    @TableField(value = "gongyingshang_id")
    private Integer gongyingshangId;


    /**
     * 进货单编号
     */

    @TableField(value = "jinhuodan_uuid_number")
    private String jinhuodanUuidNumber;


    /**
     * 进货单名称
     */

    @TableField(value = "jinhuodan_name")
    private String jinhuodanName;


    /**
     * 进货单
     */

    @TableField(value = "jinhuodan_file")
    private String jinhuodanFile;


    /**
     * 进货类型
     */

    @TableField(value = "jinhuodan_types")
    private Integer jinhuodanTypes;


    /**
     * 进货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "caozuo_time")
    private Date caozuoTime;


    /**
     * 进货单内容
     */

    @TableField(value = "jinhuodan_content")
    private String jinhuodanContent;


    /**
     * 备注
     */

    @TableField(value = "jinhuodan_beizhu_content")
    private String jinhuodanBeizhuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：供应商
	 */
    public Integer getGongyingshangId() {
        return gongyingshangId;
    }


    /**
	 * 获取：供应商
	 */

    public void setGongyingshangId(Integer gongyingshangId) {
        this.gongyingshangId = gongyingshangId;
    }
    /**
	 * 设置：进货单编号
	 */
    public String getJinhuodanUuidNumber() {
        return jinhuodanUuidNumber;
    }


    /**
	 * 获取：进货单编号
	 */

    public void setJinhuodanUuidNumber(String jinhuodanUuidNumber) {
        this.jinhuodanUuidNumber = jinhuodanUuidNumber;
    }
    /**
	 * 设置：进货单名称
	 */
    public String getJinhuodanName() {
        return jinhuodanName;
    }


    /**
	 * 获取：进货单名称
	 */

    public void setJinhuodanName(String jinhuodanName) {
        this.jinhuodanName = jinhuodanName;
    }
    /**
	 * 设置：进货单
	 */
    public String getJinhuodanFile() {
        return jinhuodanFile;
    }


    /**
	 * 获取：进货单
	 */

    public void setJinhuodanFile(String jinhuodanFile) {
        this.jinhuodanFile = jinhuodanFile;
    }
    /**
	 * 设置：进货类型
	 */
    public Integer getJinhuodanTypes() {
        return jinhuodanTypes;
    }


    /**
	 * 获取：进货类型
	 */

    public void setJinhuodanTypes(Integer jinhuodanTypes) {
        this.jinhuodanTypes = jinhuodanTypes;
    }
    /**
	 * 设置：进货时间
	 */
    public Date getCaozuoTime() {
        return caozuoTime;
    }


    /**
	 * 获取：进货时间
	 */

    public void setCaozuoTime(Date caozuoTime) {
        this.caozuoTime = caozuoTime;
    }
    /**
	 * 设置：进货单内容
	 */
    public String getJinhuodanContent() {
        return jinhuodanContent;
    }


    /**
	 * 获取：进货单内容
	 */

    public void setJinhuodanContent(String jinhuodanContent) {
        this.jinhuodanContent = jinhuodanContent;
    }
    /**
	 * 设置：备注
	 */
    public String getJinhuodanBeizhuContent() {
        return jinhuodanBeizhuContent;
    }


    /**
	 * 获取：备注
	 */

    public void setJinhuodanBeizhuContent(String jinhuodanBeizhuContent) {
        this.jinhuodanBeizhuContent = jinhuodanBeizhuContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
