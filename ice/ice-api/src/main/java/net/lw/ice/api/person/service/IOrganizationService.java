package net.lw.ice.api.person.service;

import java.util.List;

import net.lw.ice.api.person.entity.IOrganization;
import net.lw.ice.api.person.entity.IPerson;
import net.lw.ice.api.person.entity.IUser;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;

public interface IOrganizationService {

	/**
     * 创建组织机构实例
     *
     * @return
     */
    public IOrganization make();


    /**
     * 根据主键guid返回组织机构
     *
     * @param guid
     * @return
     */
    public IOrganization get(long id);
    public IOrganization getByCode(String code);


    public List<IOrganization> list();

    /**
     * 增加一条组织机构信息
     *
     * @param entity
     * @return
     */
    public IOrganization add(IOrganization organization);


    /**
     * 删除组织机构
     *
     * @param organization
     */
    public void remove(IOrganization organization);

    /**
     * 更新组织机构信息
     *
     * @param organization
     */
    public void update(IOrganization organization);

    /**
     * 根据条件返回组织机构列表
     *
     * @param filter
     *            条件
     * @return 机构列表
     */
    public List<IOrganization> list(IFilter filter);


    /**
     * 根据机构Id，返回机构下属列表
     *
     * @param org
     * @return
     */
    public List<IOrganization> listChildren(long orgId);

    public List<IOrganization> listChildrenByCode(String code);



    /**
     * 根据条件分页查询
     *
     * @param offset
     * @param limit
     * @param filter
     * @return
     */
    public IPageResult<IOrganization> page(int offset, int limit, IFilter filter);

    /**
     * 根据条件和机构号查询该机构下所有满足条件的机构
     *
     * @param offset
     * @param limit
     * @param filter
     * @param orgId
     * @return
     */
    public IPageResult<IOrganization> pageChildren(int offset, int limit, IFilter filter, long orgId);

    /**
     *
     * @param offset
     * @param limit
     * @param filter
     * @param orgCode
     * @return
     */
    public IPageResult<IOrganization> pageChildrenByCode(int offset, int limit, IFilter filter, String orgCode);


    /**
   	 * 根据所属机构取人员
   	 * @return
   	 */
   	public List<IPerson> listByOrgId(String orgId);

   	public IPageResult<IPerson> listByOrgCode(String orgCode,int offset,int limit,IFilter filter);

}
