package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import java.time.LocalTime;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;


import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.zoologico.Animal;
import ar.edu.unlam.pb2.zoologico.Cuidador;
import ar.edu.unlam.pb2.zoologico.Habitat;
import ar.edu.unlam.pb2.zoologico.Jirafa;
import ar.edu.unlam.pb2.zoologico.Jaula;
import ar.edu.unlam.pb2.zoologico.Leon;
import ar.edu.unlam.pb2.zoologico.Pato;
import ar.edu.unlam.pb2.zoologico.Persona;
import ar.edu.unlam.pb2.zoologico.Pinguino;
import ar.edu.unlam.pb2.zoologico.Tigre;
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
	public void dadoQueExisteUnZoologicoSePuedenAgregarJaulas() {
		Integer numero = 1;
		Character area = 'A';
		String tamanio = "Grande"; // Podría ser enum(GRANDE, MEDIANA, CHICA) y limitar cantidad de animales que
									// entran

		Jaula jaula = this.crearJaula(numero, area, tamanio);

		Boolean jaulaAgregada = this.zoologico.agregarJaula(jaula);

		assertTrue(jaulaAgregada);
	}

	@Test
	public void queSePuedaAgregarUnAnimalAlZoologico() {
		Animal leon = this.crearLeon(1, "Juan", 'F', 5, "rubia");
		Boolean animalAgregado = this.zoologico.agregarAnimal(leon);
	public void dadoQueExisteUnaJualaEnElZooSeLePuedeAgregarUnAnimal() {
		Animal leon = this.crearLeon(1, "Juan", 'F', 5, "ruar", "rubia");
		Jaula jaula = this.crearJaula(1, 'A', "Chico");
		int numeroJaula = 1;

		this.zoologico.agregarJaula(jaula);

		Boolean animalAgregado = this.zoologico.agregarAnimalAJaula(leon, numeroJaula);
		assertTrue(animalAgregado);
	}

	@Test
	public void queSePuedaAlimentarUnAnimal() {
		Animal leon = this.crearLeon(1, "Juan", 'F', 5, "rubia");
	public void dadoQueExisteUnaJaulaEnElZooSeLePuedeAsignarUnCuidador() {
		Cuidador cuidador = this.crearCuidador("Juan", "Perez", 34, 1233413, 111222233, 10);
		Jaula jaula = this.crearJaula(1, 'A', "Chico");
		int numeroJaula = 1;

		this.zoologico.agregarJaula(jaula);

		Boolean animalAgregado = this.zoologico.asignarCuidadorAJaula(cuidador, numeroJaula);
		assertTrue(animalAgregado);
	}

	@Test
	public void dadoQueExisteUnaJaulaEnElZooSeLePuedeAgregarVariosAnimales() {
		Jaula jaula = this.crearJaula(1, 'A', "Chico");

		this.zoologico.agregarJaula(jaula);

		Animal leon1 = this.crearLeon(1000, "Giuli", 'F', 5, "ruar", "rubia");
		Animal leon2 = this.crearLeon(1001, "Pedro", 'F', 5, "ruar", "marron");
		Animal leon3 = this.crearLeon(1002, "Gonza", 'F', 5, "ruar", "negra");

		Boolean animalAgregado1 = this.zoologico.agregarAnimalAJaula(leon1, 1);
		Boolean animalAgregado2 = this.zoologico.agregarAnimalAJaula(leon2, 1);
		Boolean animalAgregado3 = this.zoologico.agregarAnimalAJaula(leon3, 1);

		assertTrue(animalAgregado1);
		assertTrue(animalAgregado2);
		assertTrue(animalAgregado3);
	}


	@Test
	public void dadoQueExistenVariasJaulasSePuedenObtenerLosAnimalesQueContieneUnaDeEllas() {
		Jaula jaula1 = this.crearJaula(1, 'A', "Chico");
		Jaula jaula2 = this.crearJaula(2, 'A', "Mediano");
		Jaula jaula3 = this.crearJaula(3, 'A', "Grande");

		this.zoologico.agregarJaula(jaula1);
		this.zoologico.agregarJaula(jaula2);
		this.zoologico.agregarJaula(jaula3);

		Animal leon1 = this.crearLeon(1000, "Giuli", 'F', 5, "ruar", "rubia");
		Animal leon2 = this.crearLeon(1001, "Pedro", 'F', 5, "ruar", "marron");
		Animal leon3 = this.crearLeon(1002, "Gonza", 'F', 5, "ruar", "negra");


		this.zoologico.agregarAnimalAJaula(leon1, 2);
		this.zoologico.agregarAnimalAJaula(leon2, 2);
		this.zoologico.agregarAnimalAJaula(leon3, 2);
		
		Set<Animal> animalesDeLaJaula = this.zoologico.buscarAnimalesDeUnaJaula(2);
		
		assertEquals(3, animalesDeLaJaula.size());
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

		assertEquals(valorEsperado, valorObtenido);

		assertEquals(valorEsperado2, valorObtenido2);

		// assertTrue(seComproEntradaBase);

		// assertTrue(seComproEntradaPremium);
	}
	
	@Test
	public void queSePuedaRemoverUnAnimalDelZoologico() {
	    Animal tigre = this.crearTigre(2, "Tiger", 'M', 4, 20);
	    this.zoologico.agregarAnimal(tigre);
	    Boolean animalRemovido = this.zoologico.removerAnimal(tigre);
	    assertTrue(animalRemovido);
	    assertNull(this.zoologico.buscarAnimal(2));
	}
	
	@Test
	public void queSePuedaAgregarAnimalesAUnHabitat() {
		Habitat habitatPinguinos = new Habitat("Antártida",3);
		Animal pinguino = this.crearPinguino(1, "Felipe", 'M', 2, "corto");
		
		Boolean seAgrego = habitatPinguinos.agregarAnimal(pinguino);
		assertTrue(seAgrego);
	}
	
	@Test
	public void queNoSePuedanAgregarMasAnimalesAUnHabitatLleno() {
		Habitat habitatPinguinos = new Habitat("Antártida",3);
		Animal pinguino1 = this.crearPinguino(1, "Felipe", 'M', 2,"corto");
		Animal pinguino2 = this.crearPinguino(2, "Fiona", 'F', 3, "corto");
		Animal pinguino3 = this.crearPinguino(3, "Jose", 'M', 5,"corto");
		Animal pinguino4 = this.crearPinguino(4, "Skipper", 'M', 6,"corto");
		
		habitatPinguinos.agregarAnimal(pinguino1);
		habitatPinguinos.agregarAnimal(pinguino2);
		habitatPinguinos.agregarAnimal(pinguino3);
		
		Boolean seAgrego = habitatPinguinos.agregarAnimal(pinguino4);
		
		assertFalse(seAgrego);
	}
	
	@Test
	public void queUnAnimalPuedaEmitirSuSonido() {
		Animal leon = this.crearLeon(1, "Juana", 'F', 5, "rubia");
		String sonidoEmitido = leon.emitirSonido();
		String sonidoEsperado = "ruar";
		
		assertEquals(sonidoEmitido, sonidoEsperado);
		
		Animal pato = this.crearPato(5, "Lucas", 'M', 2, 35.5);
		sonidoEmitido = pato.emitirSonido();
		sonidoEsperado = "cuac";
		
		assertEquals(sonidoEmitido, sonidoEsperado);
	}
	
	private Animal crearPato(Integer id, String nombre, Character sexo, Integer edad, Double longitudPico) {
		return new Pato(id,nombre,sexo,edad,longitudPico);
	}
	
	private Animal crearPinguino(Integer id, String nombre, Character sexo, Integer edad, String plumaje) {
		return new Pinguino(id,nombre,sexo,edad,plumaje);
	}
	
	private Animal crearJirafa(Integer id, String nombre, Character sexo, Integer edad, Double longitudCuello) {
        return new Jirafa(id,nombre,sexo,edad,longitudCuello);
	}
	
	private Animal crearTigre(Integer id, String nombre, Character sexo, Integer edad, Integer rayas) {
        return new Tigre(id,nombre,sexo,edad,rayas);
	}
	
	private Animal crearLeon(Integer id, String nombre, Character sexo, Integer edad, String melena) {
        return new Leon(id,nombre,sexo,edad,melena);
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
		Boolean seAlimento = this.zoologico.alimentarALosPeces(visitante,peces);
		
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
	
	
	
	
	
	
	private Pez crearPez(Integer id, String nombre, Character sexo, Integer edad, String sonido) {
        return new Pez(id,nombre,sexo,edad,sonido); //no me dejo hacerlo con animal
    }
	
	


	private Cuidador crearCuidador(String nombre, String apellido, Integer edad, Integer dni, Integer telefono,
			Integer antiguedad) {

		return new Cuidador(nombre, apellido, edad, dni, telefono, antiguedad);
	}

	private Visitante crearVisitante(String nombre, String apellido, Integer edad, Integer dni, Integer telefono,
			Double dinero) {
		return new Visitante(nombre, apellido, edad, dni, telefono, dinero);
	}

	private Jaula crearJaula(Integer numero, Character area, String tamanio) {
		return new Jaula(numero, tamanio);
	}

	private Animal crearLeon(Integer id, String nombre, Character sexo, Integer edad, String sonido, String melena) {
		return new Leon(id, nombre, sexo, edad, sonido, melena);
	}

}
