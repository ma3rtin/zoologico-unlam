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

	public Zoologico(String nombre, LocalTime horaInicioVisita, LocalTime horaFinVisita) {
		this.nombre = nombre;
		this.horaInicioVisita = horaInicioVisita;
		this.horaFinVisita = horaFinVisita;
		this.cuidadores = new ArrayList<>();
		this.animales = new HashSet<>();
	}

	public Boolean agregarCuidador(Persona cuidador) {
		return this.cuidadores.add(cuidador);
	}

	public Boolean agregarAnimal(Animal animal) {
		return this.animales.add(animal);

	}

}
