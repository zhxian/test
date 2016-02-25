package cn.itcast.service.impl;

import cn.itcast.dao.IUserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.service.IUserService;

public class UserServiceImpl implements IUserService{

	public boolean login(User user) {
		
		//校验用户名和密码是否匹配
		
		IUserDao userDao = new UserDaoImpl();
//		  调用dao层方法--根据返回值来判断
		User resUser = userDao.qUser(user);
//		如果返回的不是null ，证明用户名和密码正确，
//		如果返回null，表示用户名和密码错误
		if(resUser != null){
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(User user) {
		boolean flag = false;
		IUserDao iUserDao = new UserDaoImpl();
		boolean bool = iUserDao.insertUser(user);
		if(bool){
			flag = true;
		}
		return flag;
	}

}
