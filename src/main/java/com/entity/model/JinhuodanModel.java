package com.entity.model;

import com.entity.JinhuodanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品进货
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JinhuodanModel implements Serializable {
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
     * 进货单编号
     */
    private String jinhuodanUuidNumber;


    /**
     * 进货单名称
     */
    private String jinhuodanName;


    /**
     * 进货单
     */
    private String jinhuodanFile;


    /**
     * 进货类型
     */
    private Integer jinhuodanTypes;


    /**
     * 进货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date caozuoTime;


    /**
     * 进货单内容
     */
    private String jinhuodanContent;


    /**
     * 备注
     */
    private String jinhuodanBeizhuContent;


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

    }
