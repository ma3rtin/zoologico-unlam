package ar.edu.unlam.pb2.zoologico;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Zoologico {

	private LocalTime horaFinVisita;
	private LocalTime horaInicioVisita;
	private String nombre;
	private List<Persona> cuidadores;
	private Set<Animal> animales;
	private Double precioEntradaBase;
	private Double precioEntradaPremium;
	private Set<Visitante> visitantes;
	private List<Jaula> jaulas;

	public Zoologico(String nombre, LocalTime horaInicioVisita, LocalTime horaFinVisita) {
		this.nombre = nombre;
		this.horaInicioVisita = horaInicioVisita;
		this.horaFinVisita = horaFinVisita;
		this.cuidadores = new ArrayList<>();
		this.animales = new HashSet<>();
		this.precioEntradaBase = 500.0;
		this.precioEntradaPremium = 1000.0;
		this.visitantes = new HashSet<>();
		this.jaulas = new ArrayList<>();
	}

	public Boolean agregarCuidador(Persona cuidador) {
		return this.cuidadores.add(cuidador);
	}

	public Boolean agregarAnimal(Animal animal) {
		return this.animales.add(animal);

	}

	public Animal buscarAnimal(Integer id) {
		for (Animal animal : animales) {
			if (animal.getId().equals(id)) {
				return animal;
			}
		}
		return null;
	}

	public Boolean comprarEntradaBase(Visitante visitante) {
		if (visitante.getDinero() >= this.precioEntradaBase) {
			visitante.setDinero(visitante.getDinero() - this.precioEntradaBase);
			return this.visitantes.add(visitante);
		}
		return false;

	}

	public Boolean comprarEntradaPremium(Visitante visitante) {
		if (visitante.getDinero() >= this.precioEntradaPremium) {
			visitante.setDinero(visitante.getDinero() - this.precioEntradaPremium);
			return this.visitantes.add(visitante);
		}
		return false;

	}

	public Boolean agregarJaula(Jaula jaula) {

		return this.jaulas.add(jaula);
	}

	public Boolean agregarCuidadorAJaula(Jaula jaula, Cuidador cuidador) {
		for (Jaula j : jaulas) {
			if (j.equals(jaula)) {
				CuidadorAnimal cuidadorAnimal = new CuidadorAnimal(cuidador, null);
				return j.agregarCuidador(cuidadorAnimal);
			}
		}
		return false;
	}

	public Boolean agregarCuidadorAnimalAJaula(Jaula jaula, Cuidador cuidador, Animal animal) {
		for (Jaula j : jaulas) {
			if(j.equals(jaula)) {
				return j.agregarCuidadorAnimal(cuidador, animal);
			}
		}
		return null;
	}
}
