package ar.edu.unlam.pb2.zoologico;

import java.util.Collections;
import java.util.List;

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

	public List<Animal> getAnimales() {
		return this.jaula.getAnimales();
	}

	public List<Animal> obtenerAnimalesOrdenadosPorNombre() {
		List<Animal> animalesOrdenados = this.getAnimales();
		Collections.sort(animalesOrdenados, new AnimalesOrdenadosPorNombreDescendente());
		return animalesOrdenados;
	}

}
