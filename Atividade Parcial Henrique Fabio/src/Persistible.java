import java.util.List;

public interface Persistible <T>{
	
	void save(T entity);
	
	T getOne(Long id);
	
	List<T> getAll();
	
	void delete (T entity);
	
	void update(T entity);
	
	T getOne(String nome);


	
	
	
	
	
}
