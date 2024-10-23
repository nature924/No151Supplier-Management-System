package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JinhuodanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 商品进货
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jinhuodan")
public class JinhuodanView extends JinhuodanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 进货类型的值
	*/
	@ColumnInfo(comment="进货类型的字典表值",type="varchar(200)")
	private String jinhuodanValue;

	//级联表 供应商信息
		/**
		* 供应商唯一编号
		*/

		@ColumnInfo(comment="供应商唯一编号",type="varchar(200)")
		private String gongyingshangUuidNumber;
		/**
		* 供应商名称
		*/

		@ColumnInfo(comment="供应商名称",type="varchar(200)")
		private String gongyingshangName;
		/**
		* 联系人姓名
		*/

		@ColumnInfo(comment="联系人姓名",type="varchar(200)")
		private String lianxirenName;
		/**
		* 联系人手机号
		*/

		@ColumnInfo(comment="联系人手机号",type="varchar(200)")
		private String lianxirenPhone;
		/**
		* 地址
		*/

		@ColumnInfo(comment="地址",type="varchar(200)")
		private String lianxirenAddress;
		/**
		* 供应商类型
		*/
		@ColumnInfo(comment="供应商类型",type="int(11)")
		private Integer gongyingshangTypes;
			/**
			* 供应商类型的值
			*/
			@ColumnInfo(comment="供应商类型的字典表值",type="varchar(200)")
			private String gongyingshangValue;
		/**
		* 信用等级
		*/
		@ColumnInfo(comment="信用等级",type="int(11)")
		private Integer gongyingshangXinyongdengjiTypes;
			/**
			* 信用等级的值
			*/
			@ColumnInfo(comment="信用等级的字典表值",type="varchar(200)")
			private String gongyingshangXinyongdengjiValue;
		/**
		* 供应商详情
		*/

		@ColumnInfo(comment="供应商详情",type="longtext")
		private String gongyingshangContent;
	//级联表 员工
		/**
		* 员工姓名
		*/

		@ColumnInfo(comment="员工姓名",type="varchar(200)")
		private String yuangongName;
		/**
		* 员工手机号
		*/

		@ColumnInfo(comment="员工手机号",type="varchar(200)")
		private String yuangongPhone;
		/**
		* 员工身份证号
		*/

		@ColumnInfo(comment="员工身份证号",type="varchar(200)")
		private String yuangongIdNumber;
		/**
		* 员工头像
		*/

		@ColumnInfo(comment="员工头像",type="varchar(200)")
		private String yuangongPhoto;
		/**
		* 员工邮箱
		*/

		@ColumnInfo(comment="员工邮箱",type="varchar(200)")
		private String yuangongEmail;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public JinhuodanView() {

	}

	public JinhuodanView(JinhuodanEntity jinhuodanEntity) {
		try {
			BeanUtils.copyProperties(this, jinhuodanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 进货类型的值
	*/
	public String getJinhuodanValue() {
		return jinhuodanValue;
	}
	/**
	* 设置： 进货类型的值
	*/
	public void setJinhuodanValue(String jinhuodanValue) {
		this.jinhuodanValue = jinhuodanValue;
	}


	//级联表的get和set 供应商信息

		/**
		* 获取： 供应商唯一编号
		*/
		public String getGongyingshangUuidNumber() {
			return gongyingshangUuidNumber;
		}
		/**
		* 设置： 供应商唯一编号
		*/
		public void setGongyingshangUuidNumber(String gongyingshangUuidNumber) {
			this.gongyingshangUuidNumber = gongyingshangUuidNumber;
		}

		/**
		* 获取： 供应商名称
		*/
		public String getGongyingshangName() {
			return gongyingshangName;
		}
		/**
		* 设置： 供应商名称
		*/
		public void setGongyingshangName(String gongyingshangName) {
			this.gongyingshangName = gongyingshangName;
		}

		/**
		* 获取： 联系人姓名
		*/
		public String getLianxirenName() {
			return lianxirenName;
		}
		/**
		* 设置： 联系人姓名
		*/
		public void setLianxirenName(String lianxirenName) {
			this.lianxirenName = lianxirenName;
		}

		/**
		* 获取： 联系人手机号
		*/
		public String getLianxirenPhone() {
			return lianxirenPhone;
		}
		/**
		* 设置： 联系人手机号
		*/
		public void setLianxirenPhone(String lianxirenPhone) {
			this.lianxirenPhone = lianxirenPhone;
		}

		/**
		* 获取： 地址
		*/
		public String getLianxirenAddress() {
			return lianxirenAddress;
		}
		/**
		* 设置： 地址
		*/
		public void setLianxirenAddress(String lianxirenAddress) {
			this.lianxirenAddress = lianxirenAddress;
		}
		/**
		* 获取： 供应商类型
		*/
		public Integer getGongyingshangTypes() {
			return gongyingshangTypes;
		}
		/**
		* 设置： 供应商类型
		*/
		public void setGongyingshangTypes(Integer gongyingshangTypes) {
			this.gongyingshangTypes = gongyingshangTypes;
		}


			/**
			* 获取： 供应商类型的值
			*/
			public String getGongyingshangValue() {
				return gongyingshangValue;
			}
			/**
			* 设置： 供应商类型的值
			*/
			public void setGongyingshangValue(String gongyingshangValue) {
				this.gongyingshangValue = gongyingshangValue;
			}
		/**
		* 获取： 信用等级
		*/
		public Integer getGongyingshangXinyongdengjiTypes() {
			return gongyingshangXinyongdengjiTypes;
		}
		/**
		* 设置： 信用等级
		*/
		public void setGongyingshangXinyongdengjiTypes(Integer gongyingshangXinyongdengjiTypes) {
			this.gongyingshangXinyongdengjiTypes = gongyingshangXinyongdengjiTypes;
		}


			/**
			* 获取： 信用等级的值
			*/
			public String getGongyingshangXinyongdengjiValue() {
				return gongyingshangXinyongdengjiValue;
			}
			/**
			* 设置： 信用等级的值
			*/
			public void setGongyingshangXinyongdengjiValue(String gongyingshangXinyongdengjiValue) {
				this.gongyingshangXinyongdengjiValue = gongyingshangXinyongdengjiValue;
			}

		/**
		* 获取： 供应商详情
		*/
		public String getGongyingshangContent() {
			return gongyingshangContent;
		}
		/**
		* 设置： 供应商详情
		*/
		public void setGongyingshangContent(String gongyingshangContent) {
			this.gongyingshangContent = gongyingshangContent;
		}
	//级联表的get和set 员工

		/**
		* 获取： 员工姓名
		*/
		public String getYuangongName() {
			return yuangongName;
		}
		/**
		* 设置： 员工姓名
		*/
		public void setYuangongName(String yuangongName) {
			this.yuangongName = yuangongName;
		}

		/**
		* 获取： 员工手机号
		*/
		public String getYuangongPhone() {
			return yuangongPhone;
		}
		/**
		* 设置： 员工手机号
		*/
		public void setYuangongPhone(String yuangongPhone) {
			this.yuangongPhone = yuangongPhone;
		}

		/**
		* 获取： 员工身份证号
		*/
		public String getYuangongIdNumber() {
			return yuangongIdNumber;
		}
		/**
		* 设置： 员工身份证号
		*/
		public void setYuangongIdNumber(String yuangongIdNumber) {
			this.yuangongIdNumber = yuangongIdNumber;
		}

		/**
		* 获取： 员工头像
		*/
		public String getYuangongPhoto() {
			return yuangongPhoto;
		}
		/**
		* 设置： 员工头像
		*/
		public void setYuangongPhoto(String yuangongPhoto) {
			this.yuangongPhoto = yuangongPhoto;
		}

		/**
		* 获取： 员工邮箱
		*/
		public String getYuangongEmail() {
			return yuangongEmail;
		}
		/**
		* 设置： 员工邮箱
		*/
		public void setYuangongEmail(String yuangongEmail) {
			this.yuangongEmail = yuangongEmail;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "JinhuodanView{" +
			", jinhuodanValue=" + jinhuodanValue +
			", yuangongName=" + yuangongName +
			", yuangongPhone=" + yuangongPhone +
			", yuangongIdNumber=" + yuangongIdNumber +
			", yuangongPhoto=" + yuangongPhoto +
			", yuangongEmail=" + yuangongEmail +
			", gongyingshangUuidNumber=" + gongyingshangUuidNumber +
			", gongyingshangName=" + gongyingshangName +
			", lianxirenName=" + lianxirenName +
			", lianxirenPhone=" + lianxirenPhone +
			", lianxirenAddress=" + lianxirenAddress +
			", gongyingshangContent=" + gongyingshangContent +
			"} " + super.toString();
	}
}
