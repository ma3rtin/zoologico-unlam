package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import ar.edu.unlam.pb2.zoologico.Animal;
import ar.edu.unlam.pb2.zoologico.Loro;
import ar.edu.unlam.pb2.zoologico.Cuidador;
import ar.edu.unlam.pb2.zoologico.Elefante;
import ar.edu.unlam.pb2.zoologico.Leon;
import ar.edu.unlam.pb2.zoologico.Persona;
import ar.edu.unlam.pb2.zoologico.Tigre;
import ar.edu.unlam.pb2.zoologico.VisitaGuiada;
import ar.edu.unlam.pb2.zoologico.Visitante;
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
		Persona cuidador = this.crearCuidador("Juan", "Perez", 34, 1233413, 111222233, 10, 60000.0);
		Boolean cuidadorAgregado = zoologico.agregarCuidador(cuidador);
		assertTrue(cuidadorAgregado);
	}
	
	@Test
	public void queSePuedaAgregarUnAnimalLeonAlZoologico() {
		Animal leon = this.crearLeon(1, "Juan", 'F', 5, "ruar", "rubia");
		Boolean animalAgregado = this.zoologico.agregarAnimal(leon);
		assertTrue(animalAgregado);
	}
	
	@Test
	public void queSePuedaAlimentarUnAnimalLeon() {
		Animal leon = this.crearLeon(1, "Juan", 'F', 5, "ruar", "rubia");
		Cuidador cuidador = this.crearCuidador("Juan", "Perez", 34, 1233413, 111222233, 10, 60000.0);
		
		this.zoologico.agregarAnimal(leon);
		this.zoologico.agregarCuidador(cuidador);
		
		Animal animalBuscado = this.zoologico.buscarAnimal(1);
		
		Boolean seAlimento = cuidador.alimentarAnimal(animalBuscado,"Carne");
		assertTrue(seAlimento);
	}
	
	@Test
	public void queSePuedaComprarUnaEntradaBaseYUnaEntradaPremium() {
		
		Visitante visitante = this.crearVisitante("Marta", "Dulce", 40, 22415007, 1185447852, 1000.0);
		Visitante visitante2 = this.crearVisitante("Pedro", "Gonzalez", 25, 45295114, 1163238456, 2000.0);

		Boolean seComproEntradaBase = this.zoologico.comprarEntradaBase(visitante);
		
		Boolean seComproEntradaPremium = this.zoologico.comprarEntradaPremium(visitante2);
		
		Double valorEsperado = visitante.getDinero();
		
		Double valorObtenido = 500.0;
		
		Double valorEsperado2 = visitante2.getDinero();
		
		Double valorObtenido2 = 1000.0;
		
		assertEquals(valorEsperado,valorObtenido);
		
		assertEquals(valorEsperado2,valorObtenido2);
		
		//assertTrue(seComproEntradaBase);
		
		//assertTrue(seComproEntradaPremium);
	}
	
	@Test
	public void queSePuedaAgregarUnAnimalLoroAlZoologico() {
		Animal loro = this.crearLoro(2, "Lara", 'F', 10, "¡Squawk!", "rojo", true);
		Boolean animalAgregado = this.zoologico.agregarAnimal(loro);
		assertTrue(animalAgregado);
	}
	
	@Test
	public void queSePuedaAlimentarUnAnimalLoro() {
		Animal loro = this.crearLoro(2, "Lara", 'F', 10, "¡Squawk!", "rojo", true);
		Cuidador cuidador = this.crearCuidador("Roberta", "Funes", 25, 44689331, 1154268739, 5, 60000.0);
		
		this.zoologico.agregarAnimal(loro);
		this.zoologico.agregarCuidador(cuidador);
		
		Animal animalBuscado = this.zoologico.buscarAnimal(2);
		
		Boolean seAlimento = cuidador.alimentarAnimal(animalBuscado,"Semillas");
		assertTrue(seAlimento);
	}
	
	@Test
	public void queSePuedaAgregarVisitaGuiada() {
		VisitaGuiada visita = new VisitaGuiada(1, "Visita a los Leones", LocalTime.of(10, 0), 60, "Juan");
		
		 this.zoologico.agregarVisitaGuiada(visita);
		 
	     VisitaGuiada visitaObtenida = zoologico.buscarVisitaGuiada(1);
	     
	     assertNotNull(visitaObtenida);
	}

	@Test
	public void queSePuedaAgregarUnAnimalElefanteAlZoologico() {
		Animal elefante = this.crearElefante(8, "Dumbo", 'M', 50, "Trumpet!", 2.1);
		Boolean animalAgregado = this.zoologico.agregarAnimal(elefante);
		assertTrue(animalAgregado);
	}
	
	@Test
	public void queSePuedaAlimentarUnAnimalElefante() {
		Animal elefante = this.crearElefante(8, "Dumbo", 'M', 50, "Trumpet!", 2.1);
		Cuidador cuidador2 = this.crearCuidador("Roberta", "Funes", 25, 44689331, 1154268739, 5, 60000.0);
		
		this.zoologico.agregarAnimal(elefante);
		this.zoologico.agregarCuidador(cuidador2);
		
		Animal animalBuscado = this.zoologico.buscarAnimal(2);
		
		Boolean seAlimento = cuidador2.alimentarAnimal(animalBuscado,"Semillas");
		assertTrue(seAlimento);
	}
	
	@Test
	public void queSePuedaAgregarUnAnimalTigreAlZoologico() {
		Animal tigre = this.crearTigre(4, "Amur", 'M', 8, "Grrr", "Rayas Anchas");
		Boolean animalAgregado = this.zoologico.agregarAnimal(tigre);
		assertTrue(animalAgregado);
	}
	
	private Animal crearLeon(Integer id, String nombre, Character sexo, Integer edad, String sonido, String melena) {
        return new Leon(id,nombre,sexo,edad,sonido,melena);
    }
	
	private Cuidador crearCuidador(String nombre, String apellido, Integer edad, Integer dni, Integer telefono, Integer antiguedad, Double sueldo) {
		return new Cuidador(nombre, apellido, edad, dni, telefono, antiguedad, sueldo);
	}
	
	private Visitante crearVisitante(String nombre, String apellido, Integer edad, Integer dni, Integer telefono, Double dinero) {
		return new Visitante(nombre, apellido, edad, dni, telefono, dinero);
	}
	
	private Animal crearLoro(Integer id, String nombre, Character sexo, Integer edad, String sonido, String colorPlumas, Boolean puedeHablar) {
        return new Loro(id,nombre,sexo,edad,sonido, colorPlumas, puedeHablar);
    }
	
	private Animal crearElefante(Integer id, String nombre, Character sexo, Integer edad, String sonido, Double tamanioColmillos) {
        return new Elefante(id,nombre,sexo,edad,sonido,tamanioColmillos);
    }
	
	private Animal crearTigre(Integer id, String nombre, Character sexo, Integer edad, String sonido, String patronRayas) {
        return new Tigre(id,nombre,sexo,edad,sonido,patronRayas);
    }
}
