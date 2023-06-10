package Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Model.Cliente;
import Model.Item;
import Model.Pedido;
import Repository.PedidoRepository;

public class PedidoService {
	
	private static PedidoService service;
	private PedidoRepository repository;
	private static Scanner entrada;
	
	
	private PedidoService() {
		this.repository = new PedidoRepository();
	}
	
	public static PedidoService getInstance(Scanner entrada) {
		if(service == null) {
			service = new PedidoService();
			PedidoService.entrada = entrada;
		}
		return service;
	}
	
	public Pedido criarPedido(List<Item> itens, Cliente cliente) {
		Pedido pedido = new Pedido(itens, LocalDateTime.now(), cliente);
		repository.salvar(pedido);
		return pedido;
		
	}
	
	public Pedido criarPedido(List<Item> itens, Cliente cliente, String dataString) {
		LocalDateTime data = LocalDateTime.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		Pedido pedido = new Pedido(itens, data, cliente);
		repository.salvar(pedido);
		return pedido;
	}
	
	public void verPedidosPorCliente(Cliente cliente) {
		List<Pedido> pedidoDoCliente = this.repository.buscarPorCliente(cliente);
		pedidoDoCliente.forEach(pedido ->System.out.println(pedido));
	}

}
