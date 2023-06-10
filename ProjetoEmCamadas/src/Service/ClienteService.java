package Service;

import Model.Cliente;
import Repository.ClienteRepository;
import java.util.*;


public class ClienteService {
	
	private static ClienteService service;
	private ClienteRepository repository;
	private static Scanner entrada;
	
	private ClienteService() {
		this.repository = new ClienteRepository();
		
	}
	
	public static ClienteService getInstance(Scanner entrada) {
		if (service == null) {
			service = new ClienteService();
			ClienteService.entrada = entrada;
		}
		return service;
	}
	
	public Cliente buscarPorCpf(String cpf) throws Exception {
		if (!validaCpf(cpf)) {
			throw new Exception("Cpf Invalido!");
		}
		Cliente cliente = this.repository.buscarPorCpf(cpf);
		
		if(cliente == null) {
			entrada.nextLine();
			System.out.println("Digite seu nome: ");
			String nome = ClienteService.entrada.nextLine();
			System.out.println("Digite seu endereco: ");
			String endereco = ClienteService.entrada.nextLine();
			System.out.println("Digite seu telefone: ");
			String telefone = ClienteService.entrada.nextLine();
			
			cliente = new Cliente(nome, cpf, telefone, endereco);
			repository.salvar(cliente);
		}
		return cliente;
	}
	
	private boolean validaCpf(String cpf) {
		cpf = cpf.replace("-", "").replace(".", "");
		if(cpf.length()!= 11) {
			return false;
		}
		boolean todosDigitosIguais = true;
		for (int i =1; i< cpf.length(); i++) {
			if(cpf.charAt(i) != cpf.charAt(0)) {
				todosDigitosIguais = false;
				break;
			}
		}
		if(todosDigitosIguais) {
			return false;
		}
		//Validação digito verificador do CPF
		int soma1 = 0;
		int soma2 = 0;
		
		for(int i = 0; i<9; i++) {
			int digito = Character.getNumericValue(cpf.charAt(i));
			soma1 += digito*(10-i);
			soma2 += digito*(11-i);
		}
		int digitoVerificador1 = (soma1 % 11< 2) ? 0: 11 - (soma1 % 11);
		soma2 += digitoVerificador1 * 2;
		int digitoVerificador2 = (soma2 % 11< 2) ? 0: 11 - (soma2 % 11);
		
		return digitoVerificador1 == Character.getNumericValue(cpf.charAt(9)) && digitoVerificador2 == Character.getNumericValue(cpf.charAt(10));
		
	}

}
