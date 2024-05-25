package ar.edu.unlam.pb2.zoologico;

public class Cuidador extends Persona {
	
	private Integer antiguedad;

	public Cuidador(String nombre, String apellido, Integer edad, Integer dni, Integer telefono, Integer antiguedad) {
		super(nombre, apellido, edad, dni, telefono);
		this.antiguedad = antiguedad;
	}
	
	public Boolean alimentarAnimal(Animal animalBuscado, String alimento) {
		return animalBuscado.alimentar(alimento);
	}

}
