package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import ar.edu.unlam.pb2.zoologico.Cuidador;
import ar.edu.unlam.pb2.zoologico.Persona;
import ar.edu.unlam.pb2.zoologico.Zoologico;

public class ZoologicoTest {

	@Test
	public void queSePuedaCrearUnZoologico() {
		String nombre = "Zoo 1";
		LocalTime horaInicioVisita = LocalTime.of(8, 00);
		LocalTime horaFinVisita = LocalTime.of(22, 0);
		
		Zoologico zoologico = new Zoologico(nombre, horaInicioVisita, horaFinVisita);
		
		assertNotNull(zoologico);
	}
	
	@Test
	public void queSePuedaAsignarPersonalAUnZoologico() {
		String nombre = "Juan";
		String apellido = "Perez";
		Integer edad = 34;
		Integer dni = 1233413;
		Integer telefono = 111222233;
		
		Persona cuidador1 = new Cuidador(nombre, apellido, edad, dni, telefono);
		
		String nombreZoo = "Zoo 1";
		LocalTime horaInicioVisita = LocalTime.of(8, 00);
		LocalTime horaFinVisita = LocalTime.of(22, 0);
		
		Zoologico zoologico = new Zoologico(nombre, horaInicioVisita, horaFinVisita);	
		
		Boolean agregado = zoologico.agregarCuidador(cuidador1);
		
		assertTrue(agregado);
	}

}
