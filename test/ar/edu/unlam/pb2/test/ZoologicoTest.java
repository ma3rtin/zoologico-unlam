package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.zoologico.Animal;
import ar.edu.unlam.pb2.zoologico.Cuidador;
import ar.edu.unlam.pb2.zoologico.Leon;
import ar.edu.unlam.pb2.zoologico.Persona;
import ar.edu.unlam.pb2.zoologico.TipoDeEntrada;
import ar.edu.unlam.pb2.zoologico.Visitante;
import ar.edu.unlam.pb2.zoologico.Pez;
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
	public void queSePuedaVisitarElAcuarioSiElVisitanteTieneEntradaPremium() {
		Visitante visitante = this.crearVisitante("Marta", "Dulce", 40, 22415007, 1185447852, 1000.0);
		this.zoologico.comprarEntradaPremium(visitante);
		Boolean seVisito = this.zoologico.visitarAcuario(visitante);
		assertTrue(seVisito);
	}
	
	@Test
	public void queSePuedaAlimentarALosPesesSiVisitasteElAcuario() {
		Visitante visitante = this.crearVisitante("Marta", "Dulce", 40, 22415007, 1185447852, 1000.0);
		this.zoologico.comprarEntradaPremium(visitante);
		this.zoologico.visitarAcuario(visitante);
		Pez pez1 = this.crearPez(1, "roberto", 'M', 4, "glu glu");
		Pez pez2 = this.crearPez(2, "flavio", 'M', 4, "glu glu");
		Pez pez3 = this.crearPez(3, "Ernestito", 'M', 4, "glu glu");
		ArrayList<Pez> peces = new ArrayList<>();
		peces.add(pez1);
		peces.add(pez2);
		peces.add(pez3);
		Boolean seAlimento = this.zoologico.alimentarALosPeses(visitante,peces);
		
		assertTrue(seAlimento);
		
	}
	
	@Test
	public void queSePuedaVerEspectaculoDeDelfines() {
		Visitante visitante = this.crearVisitante("Marta", "Dulce", 40, 22415007, 1185447852, 1000.0);
		this.zoologico.comprarEntradaPremium(visitante);
		this.zoologico.visitarAcuario(visitante);
		Boolean seVio = this.zoologico.verEspectaculoDeDelfines(visitante);
		assertTrue(seVio);
	}
	
	
	
	
	private Animal crearLeon(Integer id, String nombre, Character sexo, Integer edad, String sonido, String melena) {
        return new Leon(id,nombre,sexo,edad,sonido,melena);
    }
	
	private Pez crearPez(Integer id, String nombre, Character sexo, Integer edad, String sonido) {
        return new Pez(id,nombre,sexo,edad,sonido); //no me dejo hacerlo con animal
    }
	
	private Cuidador crearCuidador(String nombre, String apellido, Integer edad, Integer dni, Integer telefono, Integer antiguedad) {
		return new Cuidador(nombre, apellido, edad, dni, telefono, antiguedad);
	}
	
	private Visitante crearVisitante(String nombre, String apellido, Integer edad, Integer dni, Integer telefono, Double dinero) {
		return new Visitante(nombre, apellido, edad, dni, telefono, dinero);
	}

}
