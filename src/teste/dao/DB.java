package teste.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_TIMEZONE = "useTimezone=true&serverTimezone=UTC";
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/apeu?";
	static final String JDBC_USUARIO = "root";
	static final String JDBC_SENHA = "";

	public static Connection getConn() {
		 try{
	            Connection conexao;
	            Class.forName(JDBC_DRIVER);
	            conexao=DriverManager.getConnection(
	            JDBC_URL+JDBC_TIMEZONE,
	            JDBC_USUARIO,
	            JDBC_SENHA);
	            System.out.println("Conexão estabelecida");
	            return conexao;
	        } catch(Exception e){
	            System.out.println(e.toString());
	            return null;
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
