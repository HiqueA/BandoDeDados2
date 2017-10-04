

public class Tester {
 public static void main(String[]args){
	 
 
	Conexao conexao = new Conexao();
	ColaboradorDao cDao = new ColaboradorDao(conexao);
	DepartamentoDAO dDao = new DepartamentoDAO(conexao);
	
	
	
	
	Departamento d1 = new Departamento("deppd");
	Colaborador c1 = new Colaborador("111111", "jao", "rua 8", "01983712409", "gmail", 1,	d1);
	
	
	
	
	
	dDao.save(d1);
	cDao.save(c1);
	cDao.getAll();
	cDao.delete(new Colaborador(1L));
	cDao.getOne(1L);
	cDao.update(c1);
	cDao.getOne("Jao");
 }
}
