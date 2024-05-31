package ar.edu.unlam.pb2.zoologico;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Jaula {

	// enum habitat ?
	private Integer numero;
	private String tamanio;//
	private Set<Animal> animales;

	public Jaula(Integer numero, String tamanio) {
		this.numero = numero;
		this.tamanio = tamanio;
		this.animales = new HashSet<>();
	}

	public Boolean agregarAnimal(Animal animal) {
		return this.animales.add(animal);
	}

	public Set<Animal> getAnimales() {
		return this.animales;
	}

	public Integer getNumero() {
		return this.numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jaula other = (Jaula) obj;
		return Objects.equals(numero, other.numero);
	}

}
