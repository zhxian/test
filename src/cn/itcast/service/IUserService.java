package cn.itcast.service;

import cn.itcast.domain.User;

public interface IUserService {

	/**
	 * 登录业务
	 * @param user
	 * @return
	 */
	public boolean login(User user);
	
	public boolean insert(User user);
}
