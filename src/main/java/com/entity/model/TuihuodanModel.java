package com.entity.model;

import com.entity.TuihuodanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品退货
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TuihuodanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 供应商
     */
    private Integer gongyingshangId;


    /**
     * 退货单编号
     */
    private String tuihuodanUuidNumber;


    /**
     * 退货单名称
     */
    private String tuihuodanName;


    /**
     * 退货单
     */
    private String tuihuodanFile;


    /**
     * 退货类型
     */
    private Integer tuihuodanTypes;


    /**
     * 退货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date caozuoTime;


    /**
     * 退货单内容
     */
    private String tuihuodanContent;


    /**
     * 备注
     */
    private String tuihuodanBeizhuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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

    }
