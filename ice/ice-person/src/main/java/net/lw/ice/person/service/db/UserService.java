package net.lw.ice.person.service.db;

import java.util.List;

import net.lw.ice.api.person.entity.IUser;
import net.lw.ice.api.person.service.IUserService;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;
import net.lw.ice.common.exception.AppException;
import net.lw.ice.common.exception.NotFoundException;
import net.lw.ice.common.exception.PasswordErrorException;
import net.lw.ice.common.util.MsgDigestAlgorithm;
import net.lw.ice.domain.dao.IGenericDao;
import net.lw.ice.person.entity.User;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IGenericDao dao;

	@Override
	public IUser add(IUser user) {
		return dao.save(user);
	}

	@Override
	public IUser get(long id) {
		return dao.load(id, User.class);
	}

	@Override
	public IUser get(String code) {
		IUser user = (IUser)dao
			.getCriteria(User.class)
			.add(Restrictions.eq("code", code)).uniqueResult();
		return user;
	}

	@Override
	public List<IUser> list() {
		return dao.loadAll(IUser.class);
	}

	@Override
	public Iterable<IUser> list(IFilter filter) {
		return dao.findByFilter(filter, IUser.class);
	}


    @Transactional(noRollbackFor = {AppException.class,PasswordErrorException.class})
    public IUser login(String userCode,String plainText){
        User user = null;
        try{
            //验证用户名是否存在
            user = dao.findUniqueByHql("from User user where user.code = ?", userCode);
            if(user == null){
                throw new NotFoundException(String.format("输入的用户名[%s]不存在,请重新输入！",userCode));
            }
            isValidUser(user,plainText);
            return user;
        }catch(AppException e){
            throw e;
        }
    }

    public void isValidUser(User user,String plainText){

        //验证密码
        String pwd = MsgDigestAlgorithm.getMD5Str(plainText);
        if(!user.getPassword().equals(pwd)){
                throw new PasswordErrorException("密码错误");
        }
    }

	@Override
	public IUser make() {
		return new User();
	}

	@Override
	public IPageResult<IUser> page(int offset, int limit, IFilter filter) {
		return dao.page(offset, limit, filter, User.class);
	}


	@Override
	public void remove(long id) {
		dao.delete(id, User.class);
	}

	@Override
	public void update(IUser user) {
		dao.update(user);
	}

}
