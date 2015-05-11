/**
 * liuwei
 * 2015-5-4 上午01:02:19
 */
package net.lw.ice.person.db.service.mem;

import java.util.List;

import net.lw.ice.api.person.entity.IOrganization;
import net.lw.ice.api.person.entity.IUser;
import net.lw.ice.api.person.service.IOrganizationService;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;

/**
 * @author liuwei
 *
 */
public class OrganizationService implements IOrganizationService {

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#add(net.lw.ice.api.person.entity.IOrganization)
	 */
	@Override
	public IOrganization add(IOrganization organization) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#get(long)
	 */
	@Override
	public IOrganization get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#getByCode(java.lang.String)
	 */
	@Override
	public IOrganization getByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#list()
	 */
	@Override
	public List<IOrganization> list() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#list(net.lw.ice.common.IFilter)
	 */
	@Override
	public List<IOrganization> list(IFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#listChildren(long)
	 */
	@Override
	public List<IOrganization> listChildren(long orgId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#listChildrenByCode(java.lang.String)
	 */
	@Override
	public List<IOrganization> listChildrenByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#listUser(java.lang.String)
	 */
	@Override
	public List<IUser> listUser(String orgCode) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#make()
	 */
	@Override
	public IOrganization make() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#page(int, int, net.lw.ice.common.IFilter)
	 */
	@Override
	public IPageResult<IOrganization> page(int offset, int limit, IFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#page(java.lang.String, int, int, net.lw.ice.common.IFilter)
	 */
	@Override
	public IPageResult<IUser> page(String orgCode, int offset, int limit,
			IFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#pageChildren(int, int, net.lw.ice.common.IFilter, long)
	 */
	@Override
	public IPageResult<IOrganization> pageChildren(int offset, int limit,
			IFilter filter, long orgId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#pageChildrenByCode(int, int, net.lw.ice.common.IFilter, java.lang.String)
	 */
	@Override
	public IPageResult<IOrganization> pageChildrenByCode(int offset, int limit,
			IFilter filter, String orgCode) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#remove(net.lw.ice.api.person.entity.IOrganization)
	 */
	@Override
	public void remove(IOrganization organization) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IOrganizationService#update(net.lw.ice.api.person.entity.IOrganization)
	 */
	@Override
	public void update(IOrganization organization) {
		// TODO Auto-generated method stub

	}

}
