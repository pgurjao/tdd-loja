package is.lell.infnet.tdd.modelo;

import org.junit.Assert;
import org.junit.Test;



public class VendaTest {

	@Test
	public void criaVendatest() {
		
		//Monta cenário
		Venda venda = new Venda();
		Cliente cliente = new Cliente();
		venda.setCliente(cliente);
		Produto produto = new Produto("Xbox One", 3000.00);
		
		
		//Execução da lógica
		venda.adicionarProduto(produto, 1);
		
		
		//Validação do teste
		Assert.assertEquals("Jose", venda.getCliente().getNome() );
		Assert.assertEquals("Xbox One", venda.getProduto.getNome() ); // CONSERTAR LÓGICA
		Assert.assertEquals(3000.0, venda.getTotal() );
		
		
	}

}
