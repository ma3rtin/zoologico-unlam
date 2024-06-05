package ar.edu.unlam.pb2.zoologico;

public class Cuidador extends Persona {
	
	private Integer antiguedad;
	private Double sueldo;
	
	public Cuidador(String nombre, String apellido, Integer edad, Integer dni, Integer telefono, Integer antiguedad, Double sueldo) {
		super(nombre, apellido, edad, dni, telefono);
		this.antiguedad = antiguedad;
		this.sueldo = sueldo;
	}
	
	public Boolean alimentarAnimal(Animal animalBuscado, String alimento) {
		return animalBuscado.alimentar(alimento);
	}

	//Representa a los cuidadores del zoológico.
}
