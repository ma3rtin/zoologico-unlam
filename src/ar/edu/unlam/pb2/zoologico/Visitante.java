package ar.edu.unlam.pb2.zoologico;

public class Visitante extends Persona {
	
	private Double dinero;
	private TipoDeEntrada tipoEntrada;
	public Visitante(String nombre, String apellido, Integer edad, Integer dni, Integer telefono, Double dinero) {
		super(nombre, apellido, edad, dni, telefono);
		this.dinero = dinero;
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}

	public TipoDeEntrada getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(TipoDeEntrada tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	
	
	
}
