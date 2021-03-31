package is.lell.infnet.tdd.modelo;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.IllegalFormatException;

import utils.HashUtil;

public class Cliente {
	
	private String nome;
	private String numeroFidelidade;
	private String cpf;
	private String rua;
	private int numeroRua;
	private String cep;
	private Exception IllegalFormatException;
	
	public Cliente() {
		this.nome = null;
		this.cpf = null;
		this.rua = null;
		this.numeroRua = -1;
		this.cep = null;
	}
	
	public Cliente(String nome) {
		this.nome = nome;
		this.cpf = null;
		this.rua = null;
		this.numeroRua = -1;
		this.cep = null;
	}

	public Cliente(String nome, String cpf) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.nome = nome;
		this.cpf = cpf;
		numeroFidelidade = generateNumeroFidelidade(cpf);
	}

	public Cliente(String nome, String cpf, String rua, int numeroRua, String cep) {
		this.nome = nome;
		this.cpf = cpf;
		this.rua = rua;
		this.numeroRua = numeroRua;
		this.cep = cep;
	}

	private String generateNumeroFidelidade(String cpf) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		return HashUtil.saltedSha256(cpf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public boolean validaCpf(String cpf) {
		
		String caracteresValidos = "0123456789.-";
		
		System.out.println("\n---------- Testando CPF: " + cpf);
		
		if (cpf.length() > 14) {
			System.out.println("CPF INVALIDO! (L>14)");
			return false;
		}
		
		for (char c : cpf.toCharArray() ) {
			if (caracteresValidos.indexOf(c) == -1 ) {
				System.out.println("CPF INVALIDO! (invalid char) ");
				return false;
			}
		}
		
		if (cpf.indexOf(".") == 0 || cpf.indexOf("-") == 0
				|| cpf.indexOf(".") == cpf.length() - 1
				|| cpf.indexOf("-") == cpf.length() - 1 ) {
			System.out.println("CPF INVALIDO! (invalid format) ");
			return false;
		}
		
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
	
		if (cpf.length() < 11) {
			while (cpf.length() < 11) {
				cpf = "0" + cpf;
			}
		} else {
			if (cpf.length() > 11) {
				System.out.println("CPF INVALIDO! (L>11)");
				return false;
			}
		}
		
		
		boolean todosDigitosRepetidos = false;
		int contador = 0; 
		
		char algarismoCpf = '0';
		
		do {
			contador = 0;
			for (char c : cpf.toCharArray() ) {
				if (c == algarismoCpf ) {
					todosDigitosRepetidos = true;
					contador++;
				} else {
					todosDigitosRepetidos = false;
				}
			}
			if (todosDigitosRepetidos == true && contador == 11) {
				System.out.println("CPF INVALIDO! (todosDigitosRepetidos)");
				return false;
			}
			algarismoCpf = (char) (algarismoCpf + 1);
		} while (algarismoCpf != ':');
		
		// String cpf sanitizada
		
//		char ctest0 = '9';
//		int itest0 = Character.getNumericValue(ctest0);
//		System.out.println("ctest0 = " + ctest0);
//		System.out.println("itest0 = " + itest0);
		
		int multiplicador = 2;
		int[] produtosMultiplicacao = new int[11];
		int[] resultado = new int[11];
		contador = 0;
		
		for (char c : cpf.toCharArray() ) {
			resultado[contador] = Character.getNumericValue(c);
			contador++;
		}
		
		contador = 0;
		
		for (int i = 8; i >= 0 ; i--) {
			produtosMultiplicacao[i] = resultado[i] * multiplicador;
			multiplicador++;
		}
		
		int soma = 0;
		for (int i = 0; i < 9 ; i++ ) {
			soma = produtosMultiplicacao[i] + soma; 
		}
//		System.out.println("soma1 = " + soma);
		
		//Digito verificador 1
		if ( soma % 11 < 2 ) {
			resultado[9] = 0;
		} else {
			resultado[9] = 11 - (soma % 11);
		}
//		System.out.println("Digito 1 = " + resultado[9]);
		
		multiplicador = 2;
		for (int i = 9; i >= 0 ; i--) {
			produtosMultiplicacao[i] = resultado[i] * multiplicador;
			multiplicador++;
		}
		
		soma = 0;
		for (int i = 0; i < 10 ; i++ ) {
			soma = produtosMultiplicacao[i] + soma; 
		}
		
//		System.out.println("\nsoma2 = " + soma);
		
		//Digito verificador 2
		if ( soma % 11 < 2 ) {
			resultado[10] = 0;
		} else {
			resultado[10] = 11 - (soma % 11);
		}
//		System.out.println("Digito 2 = " + resultado[10] + "\n");
		
		
		System.out.println("CPF              = " + cpf.substring(0, 9) + "-" + cpf.substring(9, 11) );
		System.out.print("CPF calculado    = " + Arrays.toString(resultado).replaceAll("\\[|\\]|,|\\s", "").substring(0, 9) + "-" + Arrays.toString(resultado).replaceAll("\\[|\\]|,|\\s", "").substring(9, 11) );
		
		System.out.println("");

		if (cpf.equalsIgnoreCase(Arrays.toString(resultado).replaceAll("\\[|\\]|,|\\s", "") ) ) {
			System.out.println("CPF VALIDADO COM SUCESSO!");
			return true;
		} else {
			System.out.println("CPF INVALIDO! (digito verificador) ");
			return false;
		}
	}

	public void setCpf(String cpf) {
		
//		String caracteresValidos = "0123456789.-";

		cpf = cpf.strip();
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		
		if (cpf.length() < 11) {
			while (cpf.length() < 11) {
				cpf = "0" + cpf;
			}
		}
		if (validaCpf(cpf) == false) {
			cpf = null;
		}
		
		if (cpf == null) {
			System.out.println("CPF setado = null");
		} else {
			System.out.println("CPF setado = " + cpf);
		}

		this.cpf = cpf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumeroRua() {
		return numeroRua;
	}

	public void setNumeroRua(int numeroRua) {
		this.numeroRua = numeroRua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", numeroFidelidade=" + numeroFidelidade + ", cpf=" + cpf + ", rua=" + rua
				+ ", numeroRua=" + numeroRua + ", cep=" + cep + "]";
	}
	
	
}
