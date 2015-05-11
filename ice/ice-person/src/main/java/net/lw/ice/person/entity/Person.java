package net.lw.ice.person.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import net.lw.ice.api.person.entity.Gender;
import net.lw.ice.api.person.entity.IOrganization;
import net.lw.ice.api.person.entity.IPerson;
import net.lw.ice.api.person.entity.PersonState;
import net.lw.ice.api.person.entity.PersonType;


@Entity
@Table(name = "SM_PERSON")
public class Person implements IPerson {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SM_PERSON")
	@SequenceGenerator(name = "SEQ_SM_PERSON", sequenceName = "SEQ_SM_PERSON")
	@Column(name = "ID")
	private long id;

	/**
	 * 编号
	 */
	@Column(name = "CODE", nullable = true, length = 40)
	private String code;

	/**
	 * 工号
	 */
	@Column(name = "JOB_NUM", nullable = true, length = 40)
	private String jobNum;

	/**
	 * 名称
	 */
	@Column(name = "NAME", nullable = false, length = 40)
	private String name;

	/**
	 * 生日
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", nullable = true)
	private Date birthday;

	/**
	 * 电子邮件
	 */
	@Column(name = "EMAIL", nullable = true, length = 50)
	private String email;

	/**
	 * 性别
	 */
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "GENDER", nullable = true, length = 10)
	private Gender gender;

	/**
	 * 手机号
	 */
	@Column(name = "MOBILE", nullable = true, length = 20)
	private String mobile;

	/**
	 * 固定电话
	 */
	@Column(name = "PHONE", nullable = true, length = 20)
	private String phone;

	/**
	 * 人员类型
	 */
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "PERSON_TYPE", nullable = true, length = 10)
	private PersonType type;

	/**
	 * 所属机构
	 */
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = net.lw.ice.person.entity.Organization.class)
	@JoinColumn(name = "ORGANIZATION_ID")
	private IOrganization organization;

	/**
	 * 状态
	 */
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "STATE", nullable = true, length = 10)
	private PersonState state;

	@Column(name = "REMARK", nullable = true, length = 400)
	private String remark;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getJobNum() {
		return jobNum;
	}

	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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

	public PersonType getType() {
		return type;
	}

	public void setType(PersonType type) {
		this.type = type;
	}

	public IOrganization getOrganization() {
		return organization;
	}

	public void setOrganization(IOrganization organization) {
		this.organization = organization;
	}

	public PersonState getState() {
		return state;
	}

	public void setState(PersonState state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String getGuid() {
		return String.valueOf(id);
	}

	@Override
	public void setGuid(String guid) {
		id = Long.valueOf(guid);
	}

}
