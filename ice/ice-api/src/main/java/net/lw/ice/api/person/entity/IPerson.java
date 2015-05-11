package net.lw.ice.api.person.entity;

import java.util.Date;

public interface IPerson {
	/**
     * 内部唯一标识.
     *
     * @return 标识
     */
    public String getGuid();

    public void setGuid(String guid);

    /**
     * 外部唯一编号
     *
     * @return 编号
     */
    public String getCode();

    public void setCode(String code);

    /**
     * 返回人员姓名
     *
     * @return 姓名
     */
    public String getName();

    /**
     * 设置人员姓名
     */
    public void setName(String name);

    /**
     * 返回人员性别 Gender（枚举类型）
     *
     * @return
     */
    public Gender getGender();

    /**
     * 设置人员性别
     *
     * @param gender
     */
    public void setGender(Gender gender);

    /**
     * 返回人员出生日期
     *
     * @return
     */
    public Date getBirthday();

    /**
     * 设置人员出生日期
     *
     */
    public void setBirthday(Date birthday);

    /**
     * 返回人员手机号码
     *
     * @return
     */
    public String getMobile();

    /**
     * 设置人员手机号码
     */
    public void setMobile(String mobile);

    /**
     * 获得人员固定电话号码
     *
     * @return
     */
    public String getPhone();

    /**
     * 设置人员固定电话号码
     */
    public void setPhone(String phone);

    /**
     * 返回人员电子邮件
     *
     * @return
     */
    public String getEmail();

    /**
     * 设置人员电子邮件
     */
    public void setEmail(String email);

    /**
     * 返回人员类型
     */
    public PersonType getType();

    /**
     * 设置人员类型
     *
     * @param type
     */
    public void setType(PersonType type);

    /**
     * 返回人员所属组织机构
     *
     * @return
     */
    public IOrganization getOrganization();

    /**
     * 设置人员所属组织机构
     */
    public void setOrganization(IOrganization organization);

    /**
     * 返回人员状态
     *
     * @return
     */
    public PersonState getState();

    /**
     * 设置人员状态
     */
    public void setState(PersonState state);

    /**
     * 取到工号
     */
    public String getJobNum();

    /**
     * 设置工号
     *
     * @param jobNum
     */
    public void setJobNum(String jobNum);

    /**
     * 取到备注
     */
    public String getRemark();

    /**
     * 设置备注
     *
     * @param remark
     */
    public void setRemark(String remark);


}
