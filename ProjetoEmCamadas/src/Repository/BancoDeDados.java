package Repository;

import java.util.List;

public interface BancoDeDados<T> {
	
	public T salvar(T t);
	public T buscarPorId(Integer id);
	public List<T> buscarTodos();
	public void deletarPorId(Integer id);
	
	

}
