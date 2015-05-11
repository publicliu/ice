package net.lw.ice.api.person.entity;

import java.util.Date;

public interface IUser {

	public void setId(long id);

	public long getId();

	public String getCode();

	public void setCode(String code);

	public IOrganization getOrganization();
	/**
     * 设置人员所属组织机构
     */
    public void setOrganization(IOrganization organization);

	public String getName();
	public void setName(String name);

	public String getMobile();
	public void setMobile(String mobile);

	public String getPhone();
	public void setPhone(String phone);

	public String getEmail();
	public void setEmail(String email);

	public String getPassword();

	public Date getAccessTime();

	public void setAccessTime(Date accessTime);

	/**
	 * 用户创建人ID
	 */
	public long getCreateUserId();

	public void setCreateUserId(long createUserId);

	/**
	 * 获得密码的明文.
	 *
	 * @return 明文
	 */
	public String getPlainText();

	/**
	 * 设置密码的明文.
	 *
	 * @param plaintext
	 *            明文
	 */
	public void setPlainText(String plainText);


	/**
	 * 是否为系统内置用户
	 *
	 * @return
	 *
	 */
	public boolean isSystem();

	/**
	 * 设置系统内置用户
	 *
	 * @param system
	 *
	 */
	public void setSystem(boolean system);

}
