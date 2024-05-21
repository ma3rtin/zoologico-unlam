package ar.edu.unlam.pb2.zoologico;

public abstract class Persona {

	private Integer telefono;
	private Integer dni;
	private Integer edad;
	private String apellido;
	private String nombre;

	public Persona(String nombre, String apellido, Integer edad, Integer dni, Integer telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
		this.telefono = telefono;
	}


}
