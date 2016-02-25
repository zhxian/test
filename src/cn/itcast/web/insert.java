package cn.itcast.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.IUserService;
import cn.itcast.service.impl.UserServiceImpl;

public class insert extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		
		IUserService iUserService = new UserServiceImpl();
		boolean flag = iUserService.insert(user);
		if(flag){
			System.out.println("success");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}


	public void init() throws ServletException {
		
	}

}
