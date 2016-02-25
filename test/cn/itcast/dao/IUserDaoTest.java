package cn.itcast.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;

public class IUserDaoTest {

	@Test
	public void testIUserDao() {
		IUserDao iUserDao = new UserDaoImpl();
		
		User user = new User();
		user.setName("123");
		user.setPassword("123");
		
		boolean bool = iUserDao.insertUser(user);
		System.out.println(bool);
		
	}

}
