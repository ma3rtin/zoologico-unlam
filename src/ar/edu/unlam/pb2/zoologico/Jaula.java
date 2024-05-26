package ar.edu.unlam.pb2.zoologico;

import java.util.HashSet;
import java.util.Set;

public class Jaula {

	
	//ordenarJaulasPorNumero() y ordenarJualasPorArea();
	private Integer numero;
	private Character area;
	private String tamanio;
	private Set<CuidadorAnimal> cuidadoresAnimales;

	public Jaula(Integer numero, Character area, String tamanio) {
		this.numero = numero;
		this.area = area;
		this.tamanio = tamanio;
		this.cuidadoresAnimales = new HashSet<>();
	}

	public Integer getNumero() {
		return this.numero;
	}

	public boolean agregarCuidador(CuidadorAnimal cuidadorAnimal) {
		return this.cuidadoresAnimales.add(cuidadorAnimal);
	}

	public Boolean agregarCuidadorAnimal(Cuidador cuidador, Animal animal) {
		return this.cuidadoresAnimales.add(new CuidadorAnimal(cuidador, animal));
	}

}
