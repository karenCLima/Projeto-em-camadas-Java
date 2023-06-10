package Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;

import Model.Cliente;
import Model.Pedido;



public class PedidoRepository implements BancoDeDados<Pedido> {
	
	Map<Integer, Pedido> repository = new HashMap<>();

	@Override
	public Pedido salvar(Pedido t) {
		this.repository.put(t.getId(), t);
		return t;
	}

	@Override
	public Pedido buscarPorId(Integer id) {
		return this.buscarTodos().stream().filter(pedido -> pedido.getId() == id).findFirst().orElse(null);
	}

	@Override
	public List<Pedido> buscarTodos() {
		return new ArrayList<>(repository.values());
	}

	@Override
	public void deletarPorId(Integer id) {
		this.repository.remove(id);
		
	}

	public List<Pedido> buscarPorCliente(Cliente cliente) {
		return this.buscarTodos().stream().filter(pedido -> pedido.getCliente().equals(cliente)).collect(Collectors.toList());
		
	}

}
