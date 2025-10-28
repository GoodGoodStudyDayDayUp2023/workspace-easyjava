package com.easyjava.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import com.easyjava.enums.DateTimePatternEnum;
import com.easyjava.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @Description:商品信息
 * @author:lhc
 * @date:2025/10/28
*/
public class ProductInfo implements Serializable {
	/**
	 * 自增ID
	*/
	private Integer id;

	/**
	 * 公司ID
	*/
	@JsonIgnore
	private String companyId;

	/**
	 * 商品编号
	*/
	private String code;

	/**
	 * 商品名称
	*/
	private String productName;

	/**
	 * 价格
	*/
	private BigDecimal price;

	/**
	 * sku类型
	*/
	private Integer skuType;

	/**
	 * 颜色类型
	*/
	private Integer colorType;

	/**
	 * 创建时间
	*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 创建日期
	*/
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

	/**
	 * 库存
	*/
	private Long stock;

	/**
	 * 状态
	*/
	@JsonIgnore
	private Integer status;

	/**
	 * 0:删除 1:正常
	*/
	private Integer isdel;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setSkuType(Integer skuType) {
		this.skuType = skuType;
	}

	public Integer getSkuType() {
		return this.skuType;
	}

	public void setColorType(Integer colorType) {
		this.colorType = colorType;
	}

	public Integer getColorType() {
		return this.colorType;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Long getStock() {
		return this.stock;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

	public Integer getIsdel() {
		return this.isdel;
	}

	@Override
	public String toString() {
		return "自增ID:" + (id == null ? "空" : id) + ",公司ID:" + (companyId == null ? "空" : companyId) + ",商品编号:" + (code == null ? "空" : code) + ",商品名称:" + (productName == null ? "空" : productName) + ",价格:" + (price == null ? "空" : price) + ",sku类型:" + (skuType == null ? "空" : skuType) + ",颜色类型:" + (colorType == null ? "空" : colorType) + ",创建时间:" + (DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()) == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + ",创建日期:" + (DateUtils.format(createDate, DateTimePatternEnum.YYYY_MM_DD.getPattern()) == null ? "空" : DateUtils.format(createDate, DateTimePatternEnum.YYYY_MM_DD.getPattern())) + ",库存:" + (stock == null ? "空" : stock) + ",状态:" + (status == null ? "空" : status) + ",0:删除 1:正常:" + (isdel == null ? "空" : isdel);
	}

}