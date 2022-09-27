package bean;

public class Roupa {
	
	protected int codigo;
	protected double preco;
	
	public Roupa(int codigo, double preco) {
		this.codigo = codigo;
		this.preco = preco;
	}
	
	public Roupa() {
	}

	@Override
	public String toString() {
		return "Roupa [codigo=" + codigo + ", preco=" + preco + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
