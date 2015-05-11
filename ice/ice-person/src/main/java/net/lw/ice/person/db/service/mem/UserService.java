/**
 * liuwei
 * 2015-5-4 上午12:59:43
 */
package net.lw.ice.person.db.service.mem;

import java.util.List;

import net.lw.ice.api.person.entity.IUser;
import net.lw.ice.api.person.service.IUserService;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;

/**
 * @author liuwei
 *
 */
public class UserService implements IUserService{

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IUserService#add(net.lw.ice.api.person.entity.IUser)
	 */
	@Override
	public IUser add(IUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IUserService#get(long)
	 */
	@Override
	public IUser get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IUserService#get(java.lang.String)
	 */
	@Override
	public IUser get(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IUserService#list()
	 */
	@Override
	public List<IUser> list() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IUserService#list(net.lw.ice.common.IFilter)
	 */
	@Override
	public Iterable<IUser> list(IFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IUserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public IUser login(String userCode, String plainText) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IUserService#make()
	 */
	@Override
	public IUser make() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IUserService#page(int, int, net.lw.ice.common.IFilter)
	 */
	@Override
	public IPageResult<IUser> page(int offset, int limit, IFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IUserService#remove(long)
	 */
	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see net.lw.ice.api.person.service.IUserService#update(net.lw.ice.api.person.entity.IUser)
	 */
	@Override
	public void update(IUser user) {
		// TODO Auto-generated method stub

	}



}
