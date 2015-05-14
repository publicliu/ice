package net.lw.ice.api.person.entity;

import java.util.Date;

public interface IUser {

	public void setId(long id);

	public long getId();

	public String getCode();

	public IOrganization getOrganization();

    public IPerson getPerson();
	public void setPerson(IPerson person);

	public String getName();

	public String getMobile();

	public String getPhone();

	public String getEmail();

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
