package Service;

import java.util.List;
import java.util.Scanner;

import Model.Item;
import Repository.ItemRepository;

public class ItemService {
	
	private ItemRepository repository;
	private static ItemService service;
	private static Scanner entrada;
	
	private ItemService() {
		this.repository = new ItemRepository();
		this.criarItens();
		
	}
	
	public static ItemService getInstance(Scanner entrada) {
		if (service == null) {
			service = new ItemService();
			ItemService.entrada = entrada;
		}
		return service;
	}
	
	public void mostrarTodosItens() {
		List<Item> itens = this.repository.buscarTodos();
		
		itens.forEach(item -> System.out.println(item));
	}
	
	private void criarItens() {
		this.repository.salvar(new Item("Hamburguer" , 25.0));
		this.repository.salvar(new Item("Pizza" , 50.0));
		this.repository.salvar(new Item("Refrigerante" , 10.0));
		this.repository.salvar(new Item("Cachorro Quente" , 15.0));
		this.repository.salvar(new Item("Suco Natural" , 20.0));
		this.repository.salvar(new Item("Empada" , 10.0));
		
		
		
	}
	
	public Item escolheItem(Integer id) {
		return this.repository.buscarPorId(id);
		
	}

}
