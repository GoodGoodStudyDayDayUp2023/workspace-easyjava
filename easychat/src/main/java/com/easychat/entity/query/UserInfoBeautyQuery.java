package com.easychat.entity.query;



/**
 * @Description:靓号表
查询对象
 * @author:lhc
 * @date:2025/11/29
*/
public class UserInfoBeautyQuery extends BaseQuery {
	/**
	 * 自增ID
	*/
	private Integer id;

	/**
	 * 用户ID
	*/
	private String userId;

	private String userIdFuzzy;

	/**
	 * 邮箱
	*/
	private String email;

	private String emailFuzzy;

	/**
	 * 0:未使用  1:已使用
	*/
	private Integer status;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setUserIdFuzzy(String userIdFuzzy) {
		this.userIdFuzzy = userIdFuzzy;
	}

	public String getUserIdFuzzy() {
		return this.userIdFuzzy;
	}

	public void setEmailFuzzy(String emailFuzzy) {
		this.emailFuzzy = emailFuzzy;
	}

	public String getEmailFuzzy() {
		return this.emailFuzzy;
	}

}