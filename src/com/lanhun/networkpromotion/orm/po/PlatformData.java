package com.lanhun.networkpromotion.orm.po;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lanhun.framework.orm.po.BaseEntity;
import com.lanhun.networkpromotion.utils.em.RepayType;

@Entity
@Table(name = "t_platform_data")
public class PlatformData extends BaseEntity {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	// 详情URL
	@Column(name = "FDetailUrl")
	private String detailUrl;

	// 标号
	@Column(name = "FTagNumber")
	private String tagNumber;

	// 标名
	@Column(name = "FTagName")
	private String tagName;

	// 借款金额
	@Column(name = "FAmount")
	private BigDecimal amount;

	// 年化利率
	@Column(name = "FApr")
	private BigDecimal apr;

	// 借款期限
	@Column(name = "FLimit")
	private BigDecimal limit;

	// 借款期限类型
	@Column(name = "FLimitType")
	private String limitType;

	// 还款方式
	@Column(name = "FRepayType")
	private RepayType repayType;

	// 已投金额
	@Column(name = "FAccountYes")
	private BigDecimal accountYes;

	// 起投金额
	@Column(name = "FAcountMin")
	private BigDecimal accountMin;

	// 发标人用户名
	@Column(name = "FUserName")
	private String username;

	// 添加时间
	@Column(name = "FAddTime")
	private Date addTime;

	// 初审时间
	@Column(name = "FVerifyTime")
	private Date verifyTime;

	// 复审通过时间
	@Column(name = "FPassedTime")
	private Date passedTime;

	// 标类型
	@Column(name = "FBidType")
	private String bidType;

	// 标状态
	@Column(name = "FStatus")
	private String status;

	// 奖励
	@Column(name = "FReward")
	private BigDecimal reward;

	// 是否抵押
	@Column(name = "FIsMortgage")
	private Boolean isMortgage;

	// 是否担保
	@Column(name = "FIsGuarantee")
	private Boolean isGuarantee;

	// 是否秒标
	@Column(name = "FIsSecBid")
	private Boolean isSecBid;

	// 是否债权转让
	@Column(name = "FIsAssignOfDebt")
	private Boolean isAssignOfDebt;

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getTagNumber() {
		return tagNumber;
	}

	public void setTagNumber(String tagNumber) {
		this.tagNumber = tagNumber;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getApr() {
		return apr;
	}

	public void setApr(BigDecimal apr) {
		this.apr = apr;
	}

	public BigDecimal getLimit() {
		return limit;
	}

	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}

	public String getLimitType() {
		return limitType;
	}

	public void setLimitType(String limitType) {
		this.limitType = limitType;
	}

	public RepayType getRepayType() {
		return repayType;
	}

	public void setRepayType(RepayType repayType) {
		this.repayType = repayType;
	}

	public BigDecimal getAccountYes() {
		return accountYes;
	}

	public void setAccountYes(BigDecimal accountYes) {
		this.accountYes = accountYes;
	}

	public BigDecimal getAccountMin() {
		return accountMin;
	}

	public void setAccountMin(BigDecimal accountMin) {
		this.accountMin = accountMin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	public Date getPassedTime() {
		return passedTime;
	}

	public void setPassedTime(Date passedTime) {
		this.passedTime = passedTime;
	}

	
	public String getBidType() {
		return bidType;
	}

	public void setBidType(String bidType) {
		this.bidType = bidType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getReward() {
		return reward;
	}

	public void setReward(BigDecimal reward) {
		this.reward = reward;
	}

	public Boolean getIsMortgage() {
		return isMortgage;
	}

	public void setIsMortgage(Boolean isMortgage) {
		this.isMortgage = isMortgage;
	}

	public Boolean getIsGuarantee() {
		return isGuarantee;
	}

	public void setIsGuarantee(Boolean isGuarantee) {
		this.isGuarantee = isGuarantee;
	}

	
	public Boolean getIsSecBid() {
		return isSecBid;
	}

	public void setIsSecBid(Boolean isSecBid) {
		this.isSecBid = isSecBid;
	}

	public Boolean getIsAssignOfDebt() {
		return isAssignOfDebt;
	}

	public void setIsAssignOfDebt(Boolean isAssignOfDebt) {
		this.isAssignOfDebt = isAssignOfDebt;
	}
	
}
