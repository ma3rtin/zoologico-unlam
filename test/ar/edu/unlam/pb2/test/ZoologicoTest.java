package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.zoologico.Animal;
import ar.edu.unlam.pb2.zoologico.Cuidador;
import ar.edu.unlam.pb2.zoologico.Habitat;
import ar.edu.unlam.pb2.zoologico.Jirafa;
import ar.edu.unlam.pb2.zoologico.Leon;
import ar.edu.unlam.pb2.zoologico.Persona;
import ar.edu.unlam.pb2.zoologico.Pinguino;
import ar.edu.unlam.pb2.zoologico.Tigre;
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
	public void queSePuedaRemoverUnAnimalDelZoologico() {
	    Animal tigre = this.crearTigre(2, "Tiger", 'M', 4, "grrr", 20);
	    this.zoologico.agregarAnimal(tigre);
	    Boolean animalRemovido = this.zoologico.removerAnimal(tigre);
	    assertTrue(animalRemovido);
	    assertNull(this.zoologico.buscarAnimal(2));
	}
	
	@Test
	public void queSePuedaAgregarAnimalesAUnHabitat() {
		Habitat habitatPinguinos = new Habitat("Antártida",3);
		Animal pinguino = this.crearPinguino(1, "Felipe", 'M', 2, "honk", "corto");
		
		Boolean seAgrego = habitatPinguinos.agregarAnimal(pinguino);
		assertTrue(seAgrego);
	}
	
	@Test
	public void queNoSePuedanAgregarMasAnimalesAUnHabitatLleno() {
		Habitat habitatPinguinos = new Habitat("Antártida",3);
		Animal pinguino1 = this.crearPinguino(1, "Felipe", 'M', 2, "honk", "corto");
		Animal pinguino2 = this.crearPinguino(2, "Fiona", 'F', 3, "honk", "corto");
		Animal pinguino3 = this.crearPinguino(3, "Jose", 'M', 5, "honk", "corto");
		Animal pinguino4 = this.crearPinguino(4, "Skipper", 'M', 6, "honk", "corto");
		
		habitatPinguinos.agregarAnimal(pinguino1);
		habitatPinguinos.agregarAnimal(pinguino2);
		habitatPinguinos.agregarAnimal(pinguino3);
		
		Boolean seAgrego = habitatPinguinos.agregarAnimal(pinguino4);
		
		assertFalse(seAgrego);
	}
	
	private Animal crearPinguino(Integer id, String nombre, Character sexo, Integer edad, String sonido, String plumaje) {
		return new Pinguino(id,nombre,sexo,edad,sonido,plumaje);
	}
	
	private Animal crearJirafa(Integer id, String nombre, Character sexo, Integer edad, String sonido, Double longitudCuello) {
        return new Jirafa(id,nombre,sexo,edad,sonido,longitudCuello);
	}
	
	private Animal crearTigre(Integer id, String nombre, Character sexo, Integer edad, String sonido, Integer rayas) {
        return new Tigre(id,nombre,sexo,edad,sonido,rayas);
	}
	
	private Animal crearLeon(Integer id, String nombre, Character sexo, Integer edad, String sonido, String melena) {
        return new Leon(id,nombre,sexo,edad,sonido,melena);
    }
	
	private Cuidador crearCuidador(String nombre, String apellido, Integer edad, Integer dni, Integer telefono, Integer antiguedad) {
		return new Cuidador(nombre, apellido, edad, dni, telefono, antiguedad);
	}
	
	private Visitante crearVisitante(String nombre, String apellido, Integer edad, Integer dni, Integer telefono, Double dinero) {
		return new Visitante(nombre, apellido, edad, dni, telefono, dinero);
	}

}
