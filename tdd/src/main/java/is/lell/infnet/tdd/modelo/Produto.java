package is.lell.infnet.tdd.modelo;

public class Produto {
	
	private String nome;
	private double preco;
	private int quantidadeEstoque;
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produto(String nome, double preco, int quantidadeEstoque) {
		this.nome = nome;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidadeEstoque;
	}

	public void setQuantidade(int quantidade) {
		this.quantidadeEstoque = quantidade;
	}
}
