package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.itcast.dao.IUserDao;
import cn.itcast.domain.User;
import cn.itcast.jutil.Conn;

public class UserDaoImpl implements IUserDao{

	/**
	 * 根据用户名和密码查询用户,如果查询到用户,则返回用户信息,如果没有查询到用户信息则返回null
	 */
	public User q(User user) {
		// TODO Auto-generated method stub
		//1.加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.获取连接
		String url = "jdbc:mysql://localhost:3306/userdb";
		String username = "root";
		String password = "root";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String sql = "select * from user where username='"+user.getName()+"' and password='"+user.getPassword()+"'";
			rs = stmt.executeQuery(sql);
			//处理结果集
			if(rs.next()){
				//如果查询到数据,把数据封装成java对象,进行返回
				User rsUser = new User();
				rsUser.setName(rs.getString("username"));
				rsUser.setPassword(rs.getString("password"));
				return rsUser;
			}else{
				return null;
			}
			
			//关闭连接
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if (rs != null){
					rs.close();
					rs = null;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try{
				if (stmt != null){
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try{
				if (conn != null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public User qUser(User user) {
		return null;
	}

	
	@Override
	public boolean insertUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Conn co = new Conn();
		try {
			//conn = co.getConn();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");
			//String sql = "insert into pep(name,PASSWORD)values(?,?)";
			String sql  = "select * from pep where name = '"+user.getName()+"'";
			System.out.println(sql);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				return false;
			} else{
				String sql1 = "insert into pep(name,PASSWORD)values(?,?)";
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getPassword());
				conn.prepareStatement(sql1);
				int num = pstmt.executeUpdate();
				if(num > 0){
					return true;
				}
			}
			
			
			
			//
//			pstmt.setString(1, user.getName());
//			pstmt.setString(2, user.getPassword());
			//conn.prepareStatement(sql);
			//int num = pstmt.executeUpdate();
			
//			stmt = conn.createStatement();
//			int num = stmt.executeUpdate(sql);
//			if(num > 0){
//				return true; 
//			} return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
