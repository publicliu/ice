package net.lw.ice.person.service.db;

import java.util.List;

import net.lw.ice.api.person.entity.IPerson;
import net.lw.ice.api.person.service.IPersonService;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;

public class PersonService implements IPersonService {

	@Override
	public IPerson add(IPerson person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPerson get(String guid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IPerson> getByOrg(String orgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPageResult<IPerson> getByOrg(int offset, int limit, IFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IPerson> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IPerson> list(IFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPerson make() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPageResult<IPerson> page(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPageResult<IPerson> page(int offset, int limit, IFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String guid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(IPerson person) {
		// TODO Auto-generated method stub

	}

}
