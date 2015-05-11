package net.lw.ice.api.person.entity;

import java.util.List;

/**
 * 机构信息：
 *
 * @author liuwei
 *
 */
public interface IOrganization {

    public long getId();

    /**
     * 主键
     *
     * @return
     */
    public String getGuid();

   // public void setGuid(String guid);

    /**
     * 机构编号,不区分大小写
     *
     * @return
     */
    public String getCode();

    public void setCode(String code);

    /**
     * 返回机构名称
     *
     * @return
     */
    public String getName();

    /**
     * 设置机构名称
     */
    public void setName(String name);

    /**
     * 返回机构所在地
     */
    public String getAddress();

    /**
     * 设置机构所在地
     *
     * @param address
     */
    public void setAddress(String address);

    /**
     * 返回邮政编号
     *
     * @param zip
     */
    public String getZip();

    /**
     * 返回邮政编号
     */
    public void setZip(String zip);

    /**
     * 返回机构备注
     *
     * @return
     */
    public String getDescription();

    /**
     * 设置机构备注
     */
    public void setDescription(String description);



    /**
     * 返回父机构（上级机构） 找不到返回null
     *
     * @return
     */
    public IOrganization getParent();
    public void setParent(IOrganization parent);

    public List<IOrganization> listChildren();


}
