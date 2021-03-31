package is.lell.infnet.tdd.modelo;

import java.util.ArrayList;
import java.util.List;
import is.lell.infnet.tdd.modelo.ItemVenda;

public class Venda {

	private List<ItemVenda> itensVenda;// = new ArrayList<ItemVenda>();
	private Cliente cliente;
	private int indiceItensVenda= 0;
	private double total = 0.0;
	
	public void adicionarProduto (Produto produto, int quantidade) {
		
		if (this.getItensVenda() == null) {
			this.setItensVenda(new ArrayList<ItemVenda>() );
		}
			itensVenda.add(new ItemVenda(produto, quantidade) ); // ENTENDER ERRO
	}
	
	public ItemVenda getProduto() {
		
		if (itensVenda == null || itensVenda.size() == 0 || indiceItensVenda >= itensVenda.size() ) {
			return null;
		}
		ItemVenda itemParaRetornar = itensVenda.get(indiceItensVenda);
		
		indiceItensVenda++;
		
		return itemParaRetornar;
	}
	
	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}
	
	private void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	public double getTotal() {
		
		if (itensVenda == null) {
			return 0.0;
		}
//		double total = 0.0;
		
//		itensVenda.stream().forEach(i -> System.out.println(i.getSubTotal() ) );  //TESTAR
		itensVenda.stream().forEach(i -> this.setTotal(i.getSubTotal() ) );
		
//		for (ItemVenda i : itensVenda) {
//			
//			total += i.getSubTotal();
//		}
		return total;
	}

	private double setTotal(double subTotal) {
		total += subTotal;
		return total;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Venda [itensVenda= " + itensVenda + ", cliente=" + cliente + "]";
	}
}
