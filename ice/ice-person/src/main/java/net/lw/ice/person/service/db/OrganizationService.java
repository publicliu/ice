package net.lw.ice.person.service.db;

import java.util.List;

import net.lw.ice.api.person.entity.IOrganization;
import net.lw.ice.api.person.entity.IPerson;
import net.lw.ice.api.person.service.IOrganizationService;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;
import net.lw.ice.domain.dao.IGenericDao;
import net.lw.ice.person.entity.Organization;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrganizationService implements IOrganizationService{


	@Autowired
	private IGenericDao dao;

	@Override
	public IOrganization add(IOrganization organization) {
		return dao.save(organization);
	}

	@Override
	public IOrganization get(long id) {
		return dao.get(id, Organization.class);
	}


	 @Override
	    public IOrganization getByCode(String code) {
	        IOrganization organization = (Organization) dao
	                .getCriteria(Organization.class)
	                .add(Restrictions.eq("code", code)).uniqueResult();

	        // 注释代码，查询不到数据，直接返回null,不需要抛异常
	        // if (organization == null) {
	        // throw new NotFoundException(String.format("不存在组织[%s]", code));
	        // }

	        return organization;
	    }

	@Override
	public List<IOrganization> list() {
		return dao.loadAll(IOrganization.class);
	}

	@Override
	public List<IOrganization> list(IFilter filter) {
		return dao.findByFilter(filter, IOrganization.class);
	}



	@Override
	public List<IOrganization> listChildren(long orgId) {
		return this.get(orgId).listChildren();
	}

	@Override
	public List<IOrganization> listChildrenByCode(String code) {
		return this.getByCode(code).listChildren();
	}

	@Override
	public IOrganization make() {
		IOrganization organization = new Organization();
		return organization;
	}


	@Override
	public IPageResult<IOrganization> page(int offset, int limit, IFilter filter) {
		return dao.page(offset, limit,filter, Organization.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public IPageResult<IOrganization> pageChildren(int offset, int limit,
			IFilter filter, long orgId) {
		String hql = "select o from Organization o where o.parent.id = ? ";
		return (IPageResult<IOrganization>)this.dao.page(offset, limit,filter,hql, orgId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public IPageResult<IOrganization> pageChildrenByCode(int offset, int limit,
			IFilter filter, String orgCode) {
		String hql = "select o from Organization o where o.parent.code = ? ";
		return (IPageResult<IOrganization>)this.dao.page(offset, limit,filter,hql, orgCode);
	}

	@Override
	public void remove(IOrganization organization) {
		dao.delete(organization);
	}

	@Override
	public void update(IOrganization organization) {
		dao.update(organization);
	}


	@Override
	public List<IPerson> listByOrgId(String orgId) {
		return null;
	}

	@Override
	public IPageResult<IPerson> listByOrgCode(String orgCode,int offset, int limit, IFilter filter) {
		StringBuffer sql = new StringBuffer();
		sql.append("select p from Person p where p.organization.id = ?");
		IOrganization org = this.getByCode(orgCode);
		IPageResult<IPerson> persons =  (IPageResult<IPerson>) dao.page(offset, limit, sql.toString(), org.getId());
		return persons;
	}




}
