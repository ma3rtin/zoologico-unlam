package ar.edu.unlam.pb2.zoologico;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Zoologico {

	private LocalTime horaFinVisita;
	private LocalTime horaInicioVisita;
	private String nombre;
	private List<Persona> cuidadores;
	

	public Zoologico(String nombre, LocalTime horaInicioVisita, LocalTime horaFinVisita) {
		this.nombre = nombre;
		this.horaInicioVisita = horaInicioVisita;
		this.horaFinVisita = horaFinVisita;
		this.cuidadores = new ArrayList<>();
	}


	public Boolean agregarCuidador(Persona cuidador) {
		return this.cuidadores.add(cuidador);
	}

}
