package ar.edu.unlam.pb2.zoologico;

import java.util.Set;

public class CuidadorJaula {

	private Persona cuidador;
	private Jaula jaula;

	public CuidadorJaula(Persona cuidador, Jaula jaula) {
		this.cuidador = cuidador;
		this.jaula = jaula;
	}

	public Jaula getJaula() {
		return this.jaula;
	}

	public Boolean agregarAnimal(Animal animal) {
		return jaula.agregarAnimal(animal);
	}

	public void asignarCuidador(Cuidador cuidador) {
		this.cuidador = cuidador;
	}

	public Set<Animal> getAnimales() {
		return this.jaula.getAnimales();
	}

}
