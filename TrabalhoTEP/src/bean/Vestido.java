package bean;

public class Vestido extends Roupa{
	
	private String estampa;

	public Vestido(int codigo, double preco, String estampa) {
		super(codigo, preco);
		this.estampa = estampa;
	}

	public Vestido() {
	}

	@Override
	public String toString() {
		return "Vestido [estampa=" + estampa + "]";
	}

	public String getEstampa() {
		return estampa;
	}

	public void setEstampa(String estampa) {
		this.estampa = estampa;
	}

}
