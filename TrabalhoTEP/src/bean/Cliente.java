package bean;

public class Cliente {
	
	private String nome;
	
	public Cliente(String nome) {
		super();
		this.nome = nome;
	}
	
	public Cliente() {
		
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
