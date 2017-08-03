package com.lbcto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 数据库连接工具
 * @author lubiao
 *
 */
public class DBHelper {

	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;DataBaseName=mangerQQSys";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "123456";
	
	private static Connection connection;
	
	
	static{
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}


	public static Connection getConnection() {
		return connection;
	}


	//测试数据库的连接
	public static void main(String[] args) {
		
		if(DBHelper.getConnection()==null){
			System.out.println("连接失败");
		}else{
			System.out.println("连接成功");
		}
	}
	
	

}
