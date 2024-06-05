package ar.edu.unlam.pb2.zoologico;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Jaula {

	private Integer numero;
	private String tamanio;
	private List<Animal> animales;

	public Jaula(Integer numero, String tamanio) {
		this.numero = numero;
		this.tamanio = tamanio;
		this.animales = new ArrayList<>();
	}

	public Boolean agregarAnimal(Animal animal) {
		return this.animales.add(animal);
	}

	public List<Animal> getAnimales() {
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

	//Representa una jaula en el zoológico.
}
