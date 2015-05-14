package net.lw.ice.person.service.db;

import java.util.List;

import net.lw.ice.api.person.entity.IOrganization;
import net.lw.ice.api.person.entity.IPerson;
import net.lw.ice.api.person.service.IPersonService;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;
import net.lw.ice.domain.dao.IGenericDao;
import net.lw.ice.person.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService implements IPersonService {

	@Autowired
	private IGenericDao dao;



	@Override
	public IPerson add(IPerson person) {
		return dao.save(person);
	}

	public IPerson getByCode(String code){
		return dao.findUniqueByHql("from Person p where p.code = ?", code);
	}

	@Override
	public IPerson get(String guid) {
		return dao.load(guid, Person.class);
	}


	@Override
	public List<IPerson> list() {
		return dao.loadAll(IPerson.class);
	}

	@Override
	public List<IPerson> list(IFilter filter) {
		return dao.findByFilter(filter, IPerson.class);
	}

	@Override
	public IPerson make() {
		return new Person();
	}

	@Override
	public IPageResult<IPerson> page(int offset, int limit, IFilter filter) {
		return dao.page(offset, limit, filter, Person.class);
	}

	@Override
	public void remove(String guid) {
		dao.delete(guid, Person.class);
	}

	@Override
	public void update(IPerson person) {
		dao.update(person);
	}

	@Override
	public IOrganization getOrg(String guid){
		return this.get(guid).getOrganization();
	}

}
