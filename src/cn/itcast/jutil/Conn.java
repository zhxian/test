package cn.itcast.jutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 连接数据库
 * 
 * @author Administrator
 * 
 */
public class Conn {

	private static String url;
	private static String user;
	private static String password;
	private static String driverClass;
	private static ComboPooledDataSource ds = new ComboPooledDataSource();

	static {
//
//		Properties prop = new Properties();
//		InputStream is;
//		try {
//			//获取输入流
//			is = new FileInputStream("src/jdbc.properties");
//			prop.load(is);
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		url = prop.getProperty("url");
//		user = prop.getProperty("user");
//		password = prop.getProperty("password");
//		driverClass = prop.getProperty("driverClass");
//		ds = new ComboPooledDataSource();
//		
//		try {
//			Class.forName(driverClass);
//		} catch (ClassNotFoundException e) {
//		}
	}

	/**
	 * 获得连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConn() throws SQLException {
		Connection conn = ds.getConnection();
		return conn;
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
