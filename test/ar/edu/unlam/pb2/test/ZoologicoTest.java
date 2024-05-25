package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.zoologico.Animal;
import ar.edu.unlam.pb2.zoologico.Cuidador;
import ar.edu.unlam.pb2.zoologico.Leon;
import ar.edu.unlam.pb2.zoologico.Persona;
import ar.edu.unlam.pb2.zoologico.Zoologico;

public class ZoologicoTest {

	private static final String nombre = "Zoo 1";
	private LocalTime horaInicioVisita = LocalTime.of(8, 00);
	private LocalTime horaFinVisita = LocalTime.of(22, 0);
	private Zoologico zoologico;

	@Before
	public void init() {
		this.zoologico = new Zoologico(nombre, horaInicioVisita, horaFinVisita);
	}

	@Test
	public void queSePuedaAsignarPersonalAUnZoologico() {
		String nombre = "Juan";
		String apellido = "Perez";
		Integer edad = 34;
		Integer dni = 1233413;
		Integer telefono = 111222233;

		Persona cuidador1 = new Cuidador(nombre, apellido, edad, dni, telefono);

		Boolean agregado = zoologico.agregarCuidador(cuidador1);

		assertTrue(agregado);
	}
	
	@Test
	public void queSePuedaAgregarUnAnimalAlZoologico() {
		String nombre = "Leon";
		Character sexo = 'M';
		Integer edad = 19;
		String sonido = "ruar";
		String melena = "rubia";
		Integer id = 1;
		Animal leon = new Leon(id,nombre,sexo,edad,sonido,melena);
		Boolean animalAgregado = this.zoologico.agregarAnimal(leon);
		assertTrue(animalAgregado);
		
	}

}
