package ar.edu.unlam.pb2.zoologico;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Zoologico {// Implementar interface de zooligico - sacar cuidadores y animales

	private LocalTime horaFinVisita;
	private LocalTime horaInicioVisita;
	private String nombre;
	private List<Persona> cuidadores;
	private Set<Animal> animales;
	private Double precioEntradaBase;
	private Double precioEntradaPremium;
	private Set<Visitante> visitantes;

	private Set<VisitaGuiada> visitasGuiadas;
	
	

	private Set<CuidadorJaula> cuidadoresJaulas;


	public Zoologico(String nombre, LocalTime horaInicioVisita, LocalTime horaFinVisita) {
		this.nombre = nombre;
		this.horaInicioVisita = horaInicioVisita;
		this.horaFinVisita = horaFinVisita;
		this.cuidadores = new ArrayList<>();
		this.animales = new HashSet<>();
		this.precioEntradaBase = 500.0;
		this.precioEntradaPremium = 1000.0;

		this.visitantes = new TreeSet<>();
		this.visitasGuiadas = new HashSet<>();
	}

	 public Boolean agregarCuidador(Persona cuidador) {
		return this.cuidadores.add(cuidador);
	} 

 public Boolean agregarAnimal(Animal animal) {
		return this.animales.add(animal);

	} 

	public Animal buscarAnimal(Integer id) {
		for (Animal animal : animales) {
			if(animal.getId().equals(id)) {
				return animal;
			}
		}
		return null;

	//	this.visitantes = new TreeSet<>();
	//	this.cuidadoresJaulas = new HashSet<>();

	} 

	public Boolean comprarEntradaBase(Visitante visitante) {
		if (visitante.getDinero() >= this.precioEntradaBase) {
			visitante.setDinero(visitante.getDinero() - this.precioEntradaBase);
			return this.visitantes.add(visitante);
		}
		return false;

	}

	public Boolean comprarEntradaPremium(Visitante visitante) {
		if (visitante.getDinero() >= this.precioEntradaPremium) {
			visitante.setDinero(visitante.getDinero() - this.precioEntradaPremium);
			return this.visitantes.add(visitante);
		}
		return false;

	}


	public Boolean agregarVisitaGuiada(VisitaGuiada visita) {
		return this.visitasGuiadas.add(visita);
		
	}

	public VisitaGuiada buscarVisitaGuiada(Integer id) {
		for (VisitaGuiada visita : visitasGuiadas) {
			if(visita.getId().equals(id)) {
				return visita;
			}
		}
		return null;
	}

	public Boolean agregarJaula(Jaula jaula) {
		CuidadorJaula cuidadorJaula = new CuidadorJaula(null, jaula);
		return this.cuidadoresJaulas.add(cuidadorJaula);
	}

	public Boolean agregarCuidadorJaula(Cuidador cuidador, Jaula jaula) {
		return this.cuidadoresJaulas.add(new CuidadorJaula(cuidador, jaula));
	}

	public Boolean agregarAnimalAJaula(Animal animal, int numeroJaula) {
		for (CuidadorJaula cuidadorJaula : cuidadoresJaulas) {
			if(cuidadorJaula.getJaula().getNumero() == numeroJaula) {
				return cuidadorJaula.agregarAnimal(animal);
			}
		}
		return false;
	}

	public Boolean asignarCuidadorAJaula(Cuidador cuidador, int numeroJaula) {
		for (CuidadorJaula cuidadorJaula : cuidadoresJaulas) {
			if(cuidadorJaula.getJaula().getNumero() == numeroJaula) {
				cuidadorJaula.asignarCuidador(cuidador);
				return true;
			}
		}
		return false;
	}

	public Set<Animal> buscarAnimalesDeUnaJaula(int numeroJaula) {
		for (CuidadorJaula cuidadorJaula : cuidadoresJaulas) {
			if(cuidadorJaula.getJaula().getNumero() == numeroJaula) {
				return cuidadorJaula.getAnimales();
			}
		};
		return null;
	}

//	public Boolean agregarAnimal(Animal animal) {
//	return this.animales.add(animal);
//
//}

//public Animal buscarAnimal(Integer id) {
//	for (Animal animal : animales) {
//		if (animal.getId().equals(id)) {
//			return animal;
//		}
//	}
//	return null;
//}	
//	public Boolean agregarCuidadorAJaula(Jaula jaula, Cuidador cuidador) {
//		for (Jaula j : jaulas) {
//			if (j.equals(jaula)) {
//				CuidadorAnimal cuidadorAnimal = new CuidadorAnimal(cuidador, null);
//				return j.agregarCuidador(cuidadorAnimal);
//			}
//		}
//		return false;
//	}
//
//	public Boolean agregarCuidadorAnimalAJaula(Jaula jaula, Cuidador cuidador, Animal animal) {
//		for (Jaula j : jaulas) {
//			if(j.equals(jaula)) {
//				return j.agregarCuidadorAnimal(cuidador, animal);
//			}
//		}
//		return null;
//	}

}
