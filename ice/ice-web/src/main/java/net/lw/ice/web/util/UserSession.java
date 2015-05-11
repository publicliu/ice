package net.lw.ice.web.util;

public class UserSession {

	/**
	 * 用户ID
	 */
	private long userId;

	/**
	 * 用户名
	 */
	private String userCode;

	/**
	 * 用户名字
	 */
	private String userName;


	/**
	 * 机构ID
	 */
	private long orgId;

	/**
	 * 机构名称
	 */
	private String orgName;

	/**
	 * 机构编码
	 */
	private String orgCode;

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
