package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShangpinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 商品
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shangpin")
public class ShangpinView extends ShangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 商品类型的值
	*/
	@ColumnInfo(comment="商品类型的字典表值",type="varchar(200)")
	private String shangpinValue;
	/**
	* 二级类型的值
	*/
	@ColumnInfo(comment="二级类型的字典表值",type="varchar(200)")
	private String shangpinErjiValue;

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



	public ShangpinView() {

	}

	public ShangpinView(ShangpinEntity shangpinEntity) {
		try {
			BeanUtils.copyProperties(this, shangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 商品类型的值
	*/
	public String getShangpinValue() {
		return shangpinValue;
	}
	/**
	* 设置： 商品类型的值
	*/
	public void setShangpinValue(String shangpinValue) {
		this.shangpinValue = shangpinValue;
	}
	//当前表的
	/**
	* 获取： 二级类型的值
	*/
	public String getShangpinErjiValue() {
		return shangpinErjiValue;
	}
	/**
	* 设置： 二级类型的值
	*/
	public void setShangpinErjiValue(String shangpinErjiValue) {
		this.shangpinErjiValue = shangpinErjiValue;
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


	@Override
	public String toString() {
		return "ShangpinView{" +
			", shangpinValue=" + shangpinValue +
			", shangpinErjiValue=" + shangpinErjiValue +
			", gongyingshangUuidNumber=" + gongyingshangUuidNumber +
			", gongyingshangName=" + gongyingshangName +
			", lianxirenName=" + lianxirenName +
			", lianxirenPhone=" + lianxirenPhone +
			", lianxirenAddress=" + lianxirenAddress +
			", gongyingshangContent=" + gongyingshangContent +
			"} " + super.toString();
	}
}
