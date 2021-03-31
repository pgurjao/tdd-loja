package is.lell.infnet.tdd.modelo;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {
	
	public String[] cpfVerdadeiros = {
			"111.444.777.35",
			"123.456.789.09",
			"008.689.160-05",
			"000.000.001-91",
			"000.001.001-45",
			"00000200107",
			"00020100116",
			"00003200132",
			"191",
			"1.001-45",
			"353",
			"434"};
	
	public String[] cpfFalsos =  {
			"11111111100",
			"1234567890d",
			"a1234567890",
			"-1234567890",
			".1345678908",
			"1234567890.",
			"1234567890-",
			"12345678900",
			"192",
			"1234567890-",
			"12345678909-",
			".12345678909-",
			"-.12345678909",
			"0",
			"00",
			"000",
			"0000",
			"00000",
			"000000",
			"0000000",
			"00000000",
			"000000000",
			"0000000000",
			"00000000000",
			"22222222222",
			"33333333333",
			"44444444444",
			"55555555555",
			"66666666666",
			"77777777777",
			"88888888888",
			"99999999999",
			"11111111111",};
	
	@Test
	public void validaCpfTest() {
		
		//Monta cenário
		
		//UTILIZANDO ARRAY DE STRINGS ACIMA COM OS DADOS VALIDOS E INVALIDOS
		Cliente cliente1 = new Cliente();
		
		//Execução da lógica
		
		
		//Validação do teste
		
		//Teste AssertTrue com dados validos
		for (String s : cpfVerdadeiros) {
			Assert.assertTrue(cliente1.validaCpf(s) );
		}
		
		//Teste AssertFalse com dados invalidos
		for (String s : cpfFalsos) {
			Assert.assertFalse(cliente1.validaCpf(s) );
		}
	}

	@Test
	public void criarClienteTest() {
	
		//Monta cenário
		String nome1 = "Ayrton";
		String numeroFidelidade1;
		String cpf1 = "47504701041";
		String rua1 = "Avenida Brasil";
		int numeroRua1 = 1000;
		String cep1 = "20011050";
		
		String nome2 = "Brenda";
		String numeroFidelidade2;
		String cpf2 = "00868916005";
		String rua2 = "Avenida Passos";
		int numeroRua2 = 40;
		String cep2 = "22242000";
		
		
		//Execução da lógica
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente(nome2, cpf2, rua2, numeroRua2, cep2);
		
		
		//Validação do teste
		
		//Cliente 1
		Assert.assertEquals(null, cliente1.getNome() );
		Assert.assertEquals(null, cliente1.getCpf() );
		Assert.assertEquals(null, cliente1.getRua() );
		Assert.assertEquals(-1, cliente1.getNumeroRua() );
		Assert.assertEquals(null, cliente1.getCep() );
		
		//Cliente 2
		Assert.assertEquals(nome2, cliente2.getNome() );
		Assert.assertEquals(cpf2, cliente2.getCpf() );
		Assert.assertEquals(rua2, cliente2.getRua() );
		Assert.assertEquals(numeroRua2, cliente2.getNumeroRua() );
		Assert.assertEquals(cep2, cliente2.getCep() );
		
}
	
}
