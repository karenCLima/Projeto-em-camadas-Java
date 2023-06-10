import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import Model.Cliente;
import Model.Item;
import Service.ClienteService;
import Service.ItemService;
import Service.PedidoService;

public class Principal {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		ClienteService clienteService = ClienteService.getInstance(entrada);
		ItemService itemService = ItemService.getInstance(entrada);
		PedidoService pedidoService = PedidoService.getInstance(entrada);
		
		do {
			System.out.println("BEM VINDO!");
			System.out.println("Digite seu cpf: ");
			String cpf = entrada.nextLine();
			
			Cliente cliente;
			try {
				cliente = clienteService.buscarPorCpf(cpf);
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
				continue;
			}
			System.out.println("Bem vindo, "+ cliente.getNome());
			System.out.println("-------------------------------");
			
			System.out.println("ESCOLHA UMA OPÇÃO:");
			System.out.println("1- REALIZAR UM PEDIDO");
			System.out.println("2- VER PEDIDOS REALIZADOS");
			int opcaoUsuario = entrada.nextInt();
			if(opcaoUsuario == 1 ) {
				System.out.println("Escolha um item: ");
				System.out.println("0 - PARA SAIR DA ESCOLHA DOS ITENS");
				itemService.mostrarTodosItens();
				System.out.println("-------------------------------");
				List<Item> itensEscolhidos = new ArrayList<>();
				do {
					int opcaoItem =entrada.nextInt();
					if(opcaoItem == 0) {
						break;
					}
					itensEscolhidos.add(itemService.escolheItem(opcaoItem));
				}while(true);
				
				System.out.println("Você deseja agendar este Pedido?");	
				System.out.println("1- Sim");
				System.out.println("2- Não");
				int agendar = entrada.nextInt();
				if(agendar == 1) {
					System.out.println("Digite a data de entrega: dd/MM/aaaa HH:mm");
					entrada.nextLine();
					String dataAgendada = entrada.nextLine();
					pedidoService.criarPedido(itensEscolhidos, cliente, dataAgendada);
				}else {
					pedidoService.criarPedido(itensEscolhidos, cliente);
				}
			}else if (opcaoUsuario == 2) {
				pedidoService.verPedidosPorCliente(cliente);
			}else {
				System.out.println("OPÇÃO INVÁLIDA!!");
			}
		
		}while (true);

	}

}
