package com.entity.vo;

import com.entity.TuihuodanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品退货
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tuihuodan")
public class TuihuodanVO implements Serializable {
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
     * 退货单编号
     */

    @TableField(value = "tuihuodan_uuid_number")
    private String tuihuodanUuidNumber;


    /**
     * 退货单名称
     */

    @TableField(value = "tuihuodan_name")
    private String tuihuodanName;


    /**
     * 退货单
     */

    @TableField(value = "tuihuodan_file")
    private String tuihuodanFile;


    /**
     * 退货类型
     */

    @TableField(value = "tuihuodan_types")
    private Integer tuihuodanTypes;


    /**
     * 退货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "caozuo_time")
    private Date caozuoTime;


    /**
     * 退货单内容
     */

    @TableField(value = "tuihuodan_content")
    private String tuihuodanContent;


    /**
     * 备注
     */

    @TableField(value = "tuihuodan_beizhu_content")
    private String tuihuodanBeizhuContent;


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
	 * 设置：退货单编号
	 */
    public String getTuihuodanUuidNumber() {
        return tuihuodanUuidNumber;
    }


    /**
	 * 获取：退货单编号
	 */

    public void setTuihuodanUuidNumber(String tuihuodanUuidNumber) {
        this.tuihuodanUuidNumber = tuihuodanUuidNumber;
    }
    /**
	 * 设置：退货单名称
	 */
    public String getTuihuodanName() {
        return tuihuodanName;
    }


    /**
	 * 获取：退货单名称
	 */

    public void setTuihuodanName(String tuihuodanName) {
        this.tuihuodanName = tuihuodanName;
    }
    /**
	 * 设置：退货单
	 */
    public String getTuihuodanFile() {
        return tuihuodanFile;
    }


    /**
	 * 获取：退货单
	 */

    public void setTuihuodanFile(String tuihuodanFile) {
        this.tuihuodanFile = tuihuodanFile;
    }
    /**
	 * 设置：退货类型
	 */
    public Integer getTuihuodanTypes() {
        return tuihuodanTypes;
    }


    /**
	 * 获取：退货类型
	 */

    public void setTuihuodanTypes(Integer tuihuodanTypes) {
        this.tuihuodanTypes = tuihuodanTypes;
    }
    /**
	 * 设置：退货时间
	 */
    public Date getCaozuoTime() {
        return caozuoTime;
    }


    /**
	 * 获取：退货时间
	 */

    public void setCaozuoTime(Date caozuoTime) {
        this.caozuoTime = caozuoTime;
    }
    /**
	 * 设置：退货单内容
	 */
    public String getTuihuodanContent() {
        return tuihuodanContent;
    }


    /**
	 * 获取：退货单内容
	 */

    public void setTuihuodanContent(String tuihuodanContent) {
        this.tuihuodanContent = tuihuodanContent;
    }
    /**
	 * 设置：备注
	 */
    public String getTuihuodanBeizhuContent() {
        return tuihuodanBeizhuContent;
    }


    /**
	 * 获取：备注
	 */

    public void setTuihuodanBeizhuContent(String tuihuodanBeizhuContent) {
        this.tuihuodanBeizhuContent = tuihuodanBeizhuContent;
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
