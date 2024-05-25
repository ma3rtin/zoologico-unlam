package ar.edu.unlam.pb2.zoologico;

public class Visitante extends Persona {
	
	private Double dinero;
	
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

	
	
}
