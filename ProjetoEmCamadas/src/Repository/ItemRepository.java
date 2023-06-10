package Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import Model.Item;

public class ItemRepository implements BancoDeDados<Item> {
	
	Map <Integer, Item> repository = new HashMap<>();

	@Override
	public Item salvar(Item t) {
		this.repository.put(t.getId(),t);
		return t;
	}

	@Override
	public Item buscarPorId(Integer id) {
		return this.buscarTodos().stream().filter(item -> item.getId() == id).findFirst().orElse(null);
		
	}

	@Override
	public List<Item> buscarTodos() {
		return new ArrayList<>(repository.values());
	}

	@Override
	public void deletarPorId(Integer id) {
		this.repository.remove(id);
		
	}
	
	

}
