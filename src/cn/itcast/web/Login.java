package cn.itcast.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.IUserService;
import cn.itcast.service.impl.UserServiceImpl;

public class Login extends HttpServlet {

	//处理get请求的
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);

	}
	//处理post请求的
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		1、获取用户提交的数据 ---- username=zs&password=123
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		2、把数据进行封装
		
		User user = new User();
		user.setName(username);
		user.setPassword(password);
//		3、调用servcie的方法
		
		
		IUserService userService = new UserServiceImpl();
		boolean res = userService.login(user);
		
//		4、根据servcie的返回值，确定输出给浏览器的内容
		if(res == true){
//			表示用户名密码匹配，输出给用户登录成功
			//response.getWriter().print("success");
			request.getRequestDispatcher("/success2.html").forward(request, response);
		}else{
//			输出给用户失败
			response.getWriter().print("fail");
		}
	}

}
