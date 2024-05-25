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
		Persona cuidador = this.crearCuidador("Juan", "Perez", 34, 1233413, 111222233, 10);
		Boolean cuidadorAgregado = zoologico.agregarCuidador(cuidador);
		assertTrue(cuidadorAgregado);
	}
	
	@Test
	public void queSePuedaAgregarUnAnimalAlZoologico() {
		Animal leon = this.crearLeon(1, "Juan", 'F', 5, "ruar", "rubia");
		Boolean animalAgregado = this.zoologico.agregarAnimal(leon);
		assertTrue(animalAgregado);
	}
	
	@Test
	public void queSePuedaAlimentarUnAnimal() {
		Animal leon = this.crearLeon(1, "Juan", 'F', 5, "ruar", "rubia");
		Cuidador cuidador = this.crearCuidador("Juan", "Perez", 34, 1233413, 111222233, 10);
		
		this.zoologico.agregarAnimal(leon);
		this.zoologico.agregarCuidador(cuidador);
		
		Animal animalBuscado = this.zoologico.buscarAnimal(1);
		
		Boolean seAlimento = cuidador.alimentarAnimal(animalBuscado,"Carne");
		assertTrue(seAlimento);
		
	}
	
	private Animal crearLeon(Integer id, String nombre, Character sexo, Integer edad, String sonido, String melena) {
        return new Leon(id,nombre,sexo,edad,sonido,melena);
    }
	
	private Cuidador crearCuidador(String nombre, String apellido, Integer edad, Integer dni, Integer telefono, Integer antiguedad) {
		return new Cuidador(nombre, apellido, edad, dni, telefono, antiguedad);
	}
	

}
