package is.lell.infnet.tdd.modelo;

public class ItemVenda {

	private Produto produto;
	
	private int quantidade;

	public ItemVenda(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return produto.getNome();
	}
	
	public double getSubTotal() {
		return getProduto().getPreco() * quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "ItemVenda = [" + produto + ", quantidadeVenda=" + quantidade + "]\n";
	}
	
	
	
}
