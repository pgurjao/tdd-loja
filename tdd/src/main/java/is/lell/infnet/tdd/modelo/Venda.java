package is.lell.infnet.tdd.modelo;

import java.util.ArrayList;
import java.util.List;
import is.lell.infnet.tdd.modelo.ItemVenda;

public class Venda {

	private List<ItemVenda> itensVenda;// = new ArrayList<ItemVenda>();
	private Cliente cliente;
	
	public void adicionarProduto (Produto produto, int quantidade) {
		
		if (this.getItensVenda() == null) {
			this.setItensVenda(new ArrayList<ItemVenda>() );
		} else {
			itensVenda.add(ItemVenda(produto, quantidade)); // ENTENDER ERRO
		}
	}
	
	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}
	
	public Object getTotal() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
