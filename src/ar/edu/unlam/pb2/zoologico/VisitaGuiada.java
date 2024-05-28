package ar.edu.unlam.pb2.zoologico;

import java.time.LocalTime;

public class VisitaGuiada {
	
	private Integer id;
	private String nombre; 
	private LocalTime horaInicio;
	private Integer duracion;
	private String guia;
	
	public VisitaGuiada(Integer id, String nombre, LocalTime horaInicio, Integer duracion, String guia) {
		this.id = id;
		this.nombre = nombre;
		this.horaInicio = horaInicio;
		this.duracion = duracion;
		this.guia = guia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

}
