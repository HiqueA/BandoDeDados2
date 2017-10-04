import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class Conexao {

	private Connection connection;
	
	private final String URL = "jdbc:mysql://localhost:3306/bd2";
	private final String USER = "root";
	private final String PASSWORD = "root";
	private final String TPCONEXAO="com.mysql.jdbc.Driver";
	
	
	
	
	public Connection abrir(){
		try{
			Class.forName(TPCONEXAO);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("funcionou");
		}catch(ClassNotFoundException| SQLException ex){
			ex.printStackTrace();
		}
		return connection;
	}
	
	
	public void fechar(){
		if(connection != null){
			try{
				connection.close();
				System.out.println("conexao fechou");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
}
