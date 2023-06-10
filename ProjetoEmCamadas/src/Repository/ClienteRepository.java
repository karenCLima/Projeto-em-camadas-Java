package Repository;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import Model.Cliente;


public class ClienteRepository implements BancoDeDados<Cliente> {
	
	Map <Integer, Cliente> repository = new HashMap<>();

	@Override
	public Cliente salvar(Cliente cliente) {
		this.repository.put(cliente.getId(), cliente);
		return cliente;
	}

	@Override
	public Cliente buscarPorId(Integer id) {
		
		return null;
	}

	@Override
	public List<Cliente> buscarTodos() {
		return new ArrayList<>(this.repository.values());
	}

	@Override
	public void deletarPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	public Cliente buscarPorCpf(String cpf) {
		return this.buscarTodos().stream().filter(cliente -> cliente.getCpf().equals(cpf)).findFirst().orElse(null);
	}
	
	

}
