package is.lell.infnet.tdd.modelo;

public class Cliente {
	
	private String nome;
	private int numeroFidelidade;
	private int cpf;
	private String rua;
	private int numeroRua;
	private String cep;
	
	public Cliente(String nome, int cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public Cliente(String nome, int cpf, String rua, int numeroRua, String cep) {
		this.nome = nome;
		this.cpf = cpf;
		this.rua = rua;
		this.numeroRua = numeroRua;
		this.cep = cep;
	}

	public Cliente() {
		this.nome = null;
		this.cpf = 0;
		this.rua = null;
		this.numeroRua = 0;
		this.cep = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
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
}
