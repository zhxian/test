package cn.itcast.dao;

import cn.itcast.domain.User;

public interface IUserDao {
	public User qUser(User user);
	public boolean insertUser(User user);
}
