package com.esri.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		try {
			String url = "jdbc:postgresql://118.89.184.196:5432/arcsde";// 换成自己PostgreSQL数据库实例所在的ip地址，并设置自己的端口
			String user = "postgres";
			String password = "3489148239"; // 在这里我的密码为空，读者可以自己选择是否设置密码
			Class.forName("org.postgresql.Driver"); // 一定要注意和上面的MySQL语法不同
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("是否成功连接pg数据库" + connection);
			String sql = "select * from Student";
			statement = connection.createStatement();


			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				// 取出列值
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				System.out.println(id + "," + name + ",");

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}

		}
	}

}
