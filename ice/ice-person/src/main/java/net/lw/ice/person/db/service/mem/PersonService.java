/**
 * liuwei
 * 2015-5-4 上午01:02:49
 */
package net.lw.ice.person.db.service.mem;

import java.util.List;

import net.lw.ice.api.person.entity.IPerson;
import net.lw.ice.api.person.service.IPersonService;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;

/**
 * @author liuwei
 *
 */
public class PersonService implements IPersonService {

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IPersonService#add(net.lw.ice.api.person.entity.IPerson)
	 */
	@Override
	public IPerson add(IPerson person) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IPersonService#get(java.lang.String)
	 */
	@Override
	public IPerson get(String guid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IPersonService#getByOrg(java.lang.String)
	 */
	@Override
	public List<IPerson> getByOrg(String orgId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IPersonService#getByOrg(int, int, net.lw.ice.common.IFilter)
	 */
	@Override
	public IPageResult<IPerson> getByOrg(int offset, int limit, IFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IPersonService#list()
	 */
	@Override
	public List<IPerson> list() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IPersonService#list(net.lw.ice.common.IFilter)
	 */
	@Override
	public List<IPerson> list(IFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IPersonService#make()
	 */
	@Override
	public IPerson make() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IPersonService#page(int, int)
	 */
	@Override
	public IPageResult<IPerson> page(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IPersonService#page(int, int, net.lw.ice.common.IFilter)
	 */
	@Override
	public IPageResult<IPerson> page(int offset, int limit, IFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IPersonService#remove(java.lang.String)
	 */
	@Override
	public void remove(String guid) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IPersonService#update(net.lw.ice.api.person.entity.IPerson)
	 */
	@Override
	public void update(IPerson person) {
		// TODO Auto-generated method stub

	}

}
