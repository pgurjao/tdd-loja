package is.lell.infnet.tdd.modelo;

import org.junit.Assert;
import org.junit.Test;

public class ProdutoTest {
	
	@Test
	public void produtoTest() {
		
		//Monta cenário
		String nomeProduto1 = "TV Samsung 50\"";
		double preco1 = 3200.00;
		int quantidadeEstoque1 = 500;
		
		String nomeProduto2 = "Ar Condicionado Split";
		double preco2 = 2500.00;
		int quantidadeEstoque2 = 30;

		
		//Execução da lógica
		Produto produto1 = new Produto (nomeProduto1, preco1);
		Produto produto2 = new Produto (nomeProduto2, preco2, quantidadeEstoque2);
		
		
		//Validação do teste
		Assert.assertEquals(nomeProduto1, produto1.getNome() );
		Assert.assertEquals(preco1, produto1.getPreco(), 0.001 );
		Assert.assertEquals(0, produto1.getQuantidadeEstoque() );
		
		Assert.assertEquals(nomeProduto2, produto2.getNome() );
		Assert.assertEquals(preco2, produto2.getPreco(), 0.001 );
		Assert.assertEquals(quantidadeEstoque2, produto2.getQuantidadeEstoque() );
	}
	
}
