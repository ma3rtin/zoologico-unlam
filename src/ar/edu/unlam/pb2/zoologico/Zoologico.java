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
	
	
	
	public Zoologico(String nombre, LocalTime horaInicioVisita, LocalTime horaFinVisita) {
		this.nombre = nombre;
		this.horaInicioVisita = horaInicioVisita;
		this.horaFinVisita = horaFinVisita;
		this.cuidadores = new ArrayList<>();
		this.animales = new HashSet<>();
		this.precioEntradaBase = 500.0;
		this.precioEntradaPremium = 1000.0;
		this.visitantes = new HashSet<>();
	}

	public Boolean agregarCuidador(Persona cuidador) {
		return this.cuidadores.add(cuidador);
	}

	public Boolean agregarAnimal(Animal animal) {
		return this.animales.add(animal);

	}

	public Animal buscarAnimal(Integer id) {
		for (Animal animal : animales) {
			if(animal.getId().equals(id)) {
				return animal;
			}
		}
		return null;
	}

	public Boolean comprarEntradaBase(Visitante visitante) {
		if(visitante.getDinero() >= this.precioEntradaBase) {
			visitante.setDinero(visitante.getDinero() - this.precioEntradaBase);
			return this.visitantes.add(visitante);
		}
		return false;
		
	}

	public Boolean comprarEntradaPremium(Visitante visitante) {
		if(visitante.getDinero() >= this.precioEntradaPremium) {
			visitante.setDinero(visitante.getDinero() - this.precioEntradaPremium);
			return this.visitantes.add(visitante);
		}
		return false;
		
	}

	public Boolean removerAnimal(Animal animal) {
		return this.animales.remove(animal);
	}

}
