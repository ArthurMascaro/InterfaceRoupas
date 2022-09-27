package bean;

public class Compra {
	
	private String nomeCliente;
	private int codigoRoupa;
	private String data;
	private String horario;

	public Compra(String nomeCliente, int codigoRoupa) {
		super();
		this.nomeCliente = nomeCliente;
		this.codigoRoupa = codigoRoupa;
	}

	public Compra() {
	}

	@Override
	public String toString() {
		return "Compra [nomeCliente=" + nomeCliente + ", codigoRoupa=" + codigoRoupa + ", data=" + data + "]";
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getCodigoRoupa() {
		return codigoRoupa;
	}

	public void setCodigoRoupa(int codigoRoupa) {
		this.codigoRoupa = codigoRoupa;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
}
