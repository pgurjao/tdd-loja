package is.lell.infnet.tdd.modelo;

import static org.junit.Assert.assertFalse;
import org.junit.Assert;
import org.junit.Test;

public class VendaTest {
	
	@Test
	public void criaVendatest() {
		
		//Monta cenário
		double preco1 = 3000.0;
		int quantidade1 = 2;
		
		double preco2 = 8000.0; 
		int quantidade2 = 15;
		
		double preco3 = 50.00;
		int quantidade3 = 7;
		
		double preco4 = 0.50;
		int quantidade4 = 99;
		
		String nomeCliente = "Jose";
		
		String nomeProduto1 = "Xbox One";
		String nomeProduto2 = "iPhone 11";
		String nomeProduto3 = "Noka N95";
		String nomeProduto4 = "Mariola";
		
		
		Venda venda = new Venda();
		Cliente cliente = new Cliente(nomeCliente);
		venda.setCliente(cliente);
		Produto produto1 = new Produto(nomeProduto1, preco1);
		Produto produto2 = new Produto(nomeProduto2, preco2);
		Produto produto3 = new Produto(nomeProduto3, preco3);
		Produto produto4 = new Produto(nomeProduto4, preco4);
		
		
		
		//Execução da lógica
		venda.adicionarProduto(produto1, quantidade1);
		venda.adicionarProduto(produto2, quantidade2);
		venda.adicionarProduto(produto3, quantidade3);
		venda.adicionarProduto(produto4, quantidade4);
		
		
		
		//Validação do teste
		Assert.assertEquals(nomeCliente, venda.getCliente().getNome() );
		Assert.assertEquals(nomeProduto1, venda.getProduto().getNome() );
		Assert.assertEquals(nomeProduto2, venda.getProduto().getNome() );
		Assert.assertEquals(nomeProduto3, venda.getProduto().getNome() );
		Assert.assertEquals(nomeProduto4, venda.getProduto().getNome() );
		Assert.assertEquals(preco1*quantidade1 + preco2*quantidade2 + preco3*quantidade3 + preco4*quantidade4, venda.getTotal(), 0.001 );
		System.out.println(venda.toString());
	}

}
