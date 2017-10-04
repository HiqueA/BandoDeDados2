

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class DepartamentoDAO implements Persistible<Departamento>{
	
	private Connection connection;
	private Conexao conexao;

	public DepartamentoDAO(Conexao conexao) {
		this.conexao = conexao;
		connection = conexao.abrir();
	}

	
	@Override
	public void save(Departamento departamento) {
		String sql = "Insert into Departamento(id,nome)" + "values(?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, departamento.getId());
			pstmt.setString(2, departamento.getNome());
			

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fechar();
		}
	}



	@Override
	public void delete(Departamento departamento) {
		String sql = "delete from departamento where id = ?";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, departamento.getId());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fechar();
		}

	}
	@Override
	public Departamento getOne(Long id) {
		Departamento p = null;
		try {
			Statement sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("select * from departamento where id = " + id);
			
			while(elements.next()) {
				p = new Departamento(elements.getLong("id"),
						elements.getString("nome"));
						
			}
		} catch (Exception ex) {
			ex.printStackTrace();		
		} finally {
			conexao.fechar();
		}
		return p;
	}
		
	@Override
	public void update(Departamento departamento) {
		// TODO Auto-generated method stub
		try {
			String sql = "update departamento set nome = ?, where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, departamento.getNome());

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fechar();
		}
	}

	
		
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Conexao getConexao() {
		return conexao;
	}

	public void setConexao(Conexao conexao) {
		this.conexao = conexao;
	}


	@Override
	public List<Departamento> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Departamento getOne(String nome) {
		// TODO Auto-generated method stub
		return null;
	}


	


}
