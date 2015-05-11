package net.lw.ice.person.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import net.lw.ice.api.person.entity.IOrganization;
import net.lw.ice.api.person.entity.IUser;
import net.lw.ice.common.util.MsgDigestAlgorithm;

/**
 * 账户信息:（信息实体对应数据库表SM_USER）
 *
 * @author liuwei
 * @version
 * @since
 * @date 2010-7-31
 */
@Entity
@Table(name = "SM_USER")
public class User implements IUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SM_USER")
	@SequenceGenerator(name = "SEQ_SM_USER", sequenceName = "SEQ_SM_USER")
	@Column(name = "ID")
	private long id;

	/**
	 * 账号（使用人员信息的编号）
	 */
	@Column(name = "CODE", unique = true, nullable = false, length = 40)
	private String code;

	@Column(name = "NAME", length = 40)
	private String name;

	@Column(name = "MOBILE", length = 11)
	private String mobile;

	@Column(name = "PHONE", length = 20)
	private String phone;

	@Column(name = "EMAIL", length = 20)
	private String email;

	/**
	 * 密码
	 */
	@Column(name = "PWD", nullable = false, length = 40)
	private String password;

	/**
	 * 最后访问密码时间点
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ACCESS_TIME", nullable = true)
	private Date accessTime;

	@org.hibernate.annotations.Type(type = "com.netsoft.sample.domain.util.BooleanUserType")
	@Column(name = "IS_SYSTEM", nullable = false, columnDefinition = "CHAR", length = 1)
	private boolean system;

	@Column(name = "CREATE_USER_ID")
	private long createUserId;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity =net.lw.ice.person.entity.Organization.class)
	@JoinColumn(name = "ORGANIZATION_ID")
	private IOrganization organization;

	/*
	 * 密码的明文
	 */
	@Transient
	private String plainText;

	public User() {
		this.system = false;
		setPlainText("888888");
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public IOrganization getOrganization() {
		return this.organization;
	}

	@Override
	public void setOrganization(IOrganization organization) {
		this.organization = organization;
	}

	public Date getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}

	// 此处注意：
	public String getPlainText() {
		if (this.password != null) {
			this.plainText = this.password;
		}
		return this.plainText;
	}

	public void setPlainText(String plainText) {
		this.plainText = plainText;
		this.password = MsgDigestAlgorithm.getMD5Str(plainText);
	}

	public boolean isSystem() {
		return system;
	}

	public void setSystem(boolean system) {
		this.system = system;
	}

	public long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}

}