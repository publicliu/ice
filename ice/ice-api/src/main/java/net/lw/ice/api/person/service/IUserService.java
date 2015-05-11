package net.lw.ice.api.person.service;

import java.util.List;

import net.lw.ice.api.person.entity.IUser;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;

/**
 * 账户信息
 *
 * @author liuwei
 *
 */
public interface IUserService {

    /**
     * 创建账户
     *
     * @return
     */
    public IUser make();

    /**
     * 根据ID获得账户信息
     */
    public IUser get(long id);

    /**
     * 根据编号获得账户信息
     */
    public IUser get(String code);



    /**
     * 增加一条账户信息
     *
     * @param user
     * @return
     */
    public IUser add(IUser user);

    /**
     * 根据ID删除一条账户信息
     *
     * @param id
     */
    public void remove(long id);


    /**
     * 更新账户信息
     *
     * @param user
     */
    public void update(IUser user);

    /**
     * 返回账户列表
     *
     * @return
     */
    public List<IUser> list();

    /**
     * 根据条件分页返回账户列表
     */
    public IPageResult<IUser> page(int offset, int limit, IFilter filter);

    /**
     * 根据条件返回账户列表
     *
     * @param filter
     * @return
     */
    public Iterable<IUser> list(IFilter filter);

    /**
     * 登陆用户验证，不符合规则时抛出异常，正常时返回登陆用户
     * @param userCode -用户名
     * @param plainText -密码
     * @return
     */
    public IUser login(String userCode,String plainText);

}
