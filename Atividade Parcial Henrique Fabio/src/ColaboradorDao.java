import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





public class ColaboradorDao implements Persistible<Colaborador>{

	private Connection connection;
	private Conexao conexao;
	
	public ColaboradorDao(Conexao conexao) {
		this.conexao = conexao;
		connection = conexao.abrir();
	}

	@Override
	public void save(Colaborador cola) {
		// TODO Auto-generated method stub
		String sql = "Insert into colaborador(cpf,nome,endereco, telefone, email, quantidadeFilhos)" + "values(?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try{
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, cola.getCpf());
			pstmt.setString(2, cola.getNome());
			pstmt.setString(3, cola.getEndereco());
			pstmt.setString(4, cola.getTelefone());
			pstmt.setString(5, cola.getEmail());
			pstmt.setInt(6, cola.getQuantidadeFilhos());
			
			pstmt.execute();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			conexao.fechar();
		}
	}

	@Override
	public Colaborador getOne(Long id) {
		// TODO Auto-generated method stub
		Colaborador p = null;
		try{
			Statement sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("select * from colaborador where id =" + id);
			while (elements.next()){
				p = new Colaborador(elements.getLong("id"),
						elements.getString("cpf"),
						elements.getString("nome"),
						elements.getString("endereco"),
						elements.getString("telefone"),
						elements.getString("email"),
						elements.getInt("quantidadeFilhos"));
				
			}
		}catch (SQLException e){
			e.printStackTrace();
		} finally{
			conexao.fechar();
		}
		
		
		
		return p;
		
	}

	@Override
	public List<Colaborador> getAll() {
		List<Colaborador> result = new ArrayList<Colaborador>();
		try{
			Statement sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("select * from colaborador ");
			while (elements.next()){
				Colaborador c = new Colaborador();
					c.setId(elements.getLong("id"));
					c.setCpf(elements.getString("cpf"));
					c.setNome(elements.getString("nome"));
					c.setEndereco(elements.getString("endereco"));
					c.setTelefone(elements.getString("telefone"));
					c.setEmail(elements.getString("email"));
					c.setQuantidadeFilhos(elements.getInt("quantidadeFilhos"));
				
			}
		}catch (SQLException e){
			e.printStackTrace();
		} finally{
			conexao.fechar();
		}
		
		
		return result;
	}

	@Override
	public void delete(Colaborador cola) {
		String sql = "delete from colaborador where id=?";
		PreparedStatement pstmt;
		try{
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1,cola.getId());
			pstmt.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			conexao.fechar();
		}
		
	}

	@Override
	public void update(Colaborador cola) {
		// TODO Auto-generated method stub
		try{
			String sql = "update colaborador set cpf=?,nome=?,endereco=?, telefone=?, email=?, quantidadeFilhos=?, where id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, cola.getCpf());
			pstmt.setString(2, cola.getNome());
			pstmt.setString(3, cola.getEndereco());
			pstmt.setString(4, cola.getTelefone());
			pstmt.setString(5, cola.getEmail());
			pstmt.setInt(6, cola.getQuantidadeFilhos());
			pstmt.setLong(7, cola.getId());
			pstmt.execute();
					
		}	catch(SQLException e){
			e.printStackTrace();
		}	finally {
			conexao.fechar();
		}
		
	}

	@Override
	public Colaborador getOne(String nome) {
		Colaborador p = null;
		try{
			Statement sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("select * from colaborador where nome =" + nome);
			while (elements.next()){
				p = new Colaborador(elements.getLong("id"),
						elements.getString("cpf"),
						elements.getString("nome"),
						elements.getString("endereco"),
						elements.getString("telefone"),
						elements.getString("email"),
						elements.getInt("quantidadeFilhos"));
				
			}
		}catch (SQLException e){
			e.printStackTrace();
		} finally{
			conexao.fechar();
		}
		
		
		
		return p;
	}
	
}
