package bean;

public class Camiseta extends Roupa {

	private char tamanho;

	public Camiseta(int codigo, double preco, char tamanho) {
		super(codigo, preco);
		this.tamanho = tamanho;
	}

	public Camiseta() {
	}

	@Override
	public String toString() {
		return "Camiseta [tamanho=" + tamanho + "]";
	}

	public char getTamanho() {
		return tamanho;
	}

	public void setTamanho(char tamanho) {
		this.tamanho = tamanho;
	}
}
