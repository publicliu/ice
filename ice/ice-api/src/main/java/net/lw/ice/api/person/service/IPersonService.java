package net.lw.ice.api.person.service;

import java.util.List;

import net.lw.ice.api.person.entity.IOrganization;
import net.lw.ice.api.person.entity.IPerson;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;

public interface IPersonService {

	 /**
     * 创建一条人员信息
     *
     * @return
     */
    public IPerson make();

    /**
     * 根据主键找到人员信息
     *
     * @param guid
     * @return
     */
    public IPerson get(String guid);
    public IPerson getByCode(String code);


    /**
     * 增加人员信息
     *
     * @param person
     * @return
     */
    public IPerson add(IPerson person);

    /**
     * 根据主键删除人员信息
     *
     * @param guid
     */
    public void remove(String guid);

    /**
     * 更新人员信息
     *
     * @param person
     */
    public void update(IPerson person);

    /**
     * 返回人员列表
     *
     * @return
     */
    public List<IPerson> list();

    /**
     * 根据条件查找人员信息，返回用户列表
     *
     * @param filter
     * @return
     */
    public List<IPerson> list(IFilter filter);

    public IPageResult<IPerson> page(int offset, int limit, IFilter filter);

    public IOrganization getOrg(String guid);


}
