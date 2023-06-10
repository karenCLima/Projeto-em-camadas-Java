package Model;

import Utils.Contador;

public class Item {
	
	private String nome;
	private Double valor;
	private Integer id;
	
	public Item(String nome, Double valor) {
		this.id = Contador.pegarId();
		this.nome = nome;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + " - " + nome + " - R$"+ valor;
	}
	
	
	

}
