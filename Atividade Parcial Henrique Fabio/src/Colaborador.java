
public class Colaborador {
	
	private long id;
	private String cpf;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private int quantidadeFilhos;
	Departamento d = new Departamento();
	
	
	
	
	
	
	public Colaborador(long id, String cpf, String nome, String endereco, String telefone, String email,
			int quantidadeFilhos) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.quantidadeFilhos = quantidadeFilhos;
	}
	public Colaborador(String cpf, String nome, String endereco, String telefone, String email, int quantidadeFilhos) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.quantidadeFilhos = quantidadeFilhos;
	}
	public Colaborador(String cpf, String nome, String endereco, String telefone, String email, int quantidadeFilhos,
			Departamento d) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.quantidadeFilhos = quantidadeFilhos;
		this.d = d;
	}
	public Colaborador() {
		super();
	}
	public Colaborador(long id, String cpf, String nome, String endereco, String telefone, String email,
			int quantidadeFilhos, Departamento d) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.quantidadeFilhos = quantidadeFilhos;
		this.d = d;
	}
	public long getId() {
		return id;
	}
	public Colaborador(long id) {
		super();
		this.id = id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getQuantidadeFilhos() {
		return quantidadeFilhos;
	}
	public void setQuantidadeFilhos(int quantidadeFilhos) {
		this.quantidadeFilhos = quantidadeFilhos;
	}
	public Departamento getD() {
		return d;
	}
	public void setD(Departamento d) {
		this.d = d;
	}
	@Override
	public String toString() {
		return "Colaborador [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", telefone="
				+ telefone + ", email=" + email + ", quantidadeFilhos=" + quantidadeFilhos + ", d=" + d + "]";
	}
	
	
	
	
	
	
	
}
