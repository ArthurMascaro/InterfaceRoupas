package bean;

public class Calca extends Roupa {
	
	private int numero;

	public Calca(int codigo, double preco, int numero) {
		super(codigo, preco);
		this.numero = numero;
	}

	public Calca() {
	}

	@Override
	public String toString() {
		return "Calca [numero=" + numero + "]";
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
