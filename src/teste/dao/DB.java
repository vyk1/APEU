package teste.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

		
	public static Connection getConn() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/apeu", "root", "");
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new RuntimeException(e);
		}
	}

	public static void DC(Connection c) {
		try {
			c.close();
			System.out.println("fechou");
		} catch (Exception e) {
			System.out.println("erro ao fechar conn" + e.toString());
			// TODO: handle exception
		} finally {
			c = null;
		}
	}
}
