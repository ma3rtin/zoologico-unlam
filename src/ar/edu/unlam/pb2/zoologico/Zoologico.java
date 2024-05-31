package ar.edu.unlam.pb2.zoologico;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Zoologico implements Acuario {

	private LocalTime horaFinVisita;
	private LocalTime horaInicioVisita;
	private String nombre;
//	private List<Persona> cuidadores;
//	private Set<Animal> animales;
	private Double precioEntradaBase;
	private Double precioEntradaPremium;
	private Set<Visitante> visitantes;

	private List<Delfin> delfines;

	private Set<CuidadorJaula> cuidadoresJaulas;

	public Zoologico(String nombre, LocalTime horaInicioVisita, LocalTime horaFinVisita) {
		this.nombre = nombre;
		this.horaInicioVisita = horaInicioVisita;
		this.horaFinVisita = horaFinVisita;
//		this.cuidadores = new ArrayList<>();
//		this.animales = new HashSet<>();
		this.precioEntradaBase = 500.0;
		this.precioEntradaPremium = 1000.0;

		this.visitantes = new HashSet<>();
		this.delfines = new ArrayList<>();
	}

	public Boolean agregarCuidador(Persona cuidador) {
		return this.cuidadores.add(cuidador);
	}

	public Boolean agregarAnimal(Animal animal) {
		return this.animales.add(animal);

	}

	public Animal buscarAnimal(Integer id) {
		for (Animal animal : animales) {
			if (animal.getId().equals(id)) {
				return animal;
			}
		}
		return null;

		this.visitantes = new TreeSet<>();
		this.cuidadoresJaulas = new HashSet<>();

	}

	public Boolean comprarEntradaBase(Visitante visitante) {
		if (visitante.getDinero() >= this.precioEntradaBase) {
			visitante.setDinero(visitante.getDinero() - this.precioEntradaBase);
			visitante.setTipoEntrada(TipoDeEntrada.ENTRADA_BASE);
			return this.visitantes.add(visitante);
		}
		return false;

	}

	public Boolean comprarEntradaPremium(Visitante visitante) {
		if (visitante.getDinero() >= this.precioEntradaPremium) {
			visitante.setDinero(visitante.getDinero() - this.precioEntradaPremium);
			visitante.setTipoEntrada(TipoDeEntrada.ENTRADA_PREMIUM);
			return this.visitantes.add(visitante);
		}
		return false;

	}

	@Override
	public Boolean visitarAcuario(Visitante visitante) {
		if (visitante.getTipoEntrada().equals(TipoDeEntrada.ENTRADA_PREMIUM)) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean alimentarALosPeces(Visitante visitante, ArrayList<Pez> peces) {

		if (visitarAcuario(visitante)) {
			for (Pez pez : peces) {
				pez.alimentar("Gusano");

			}
			return true;
		}
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
			if (cuidadorJaula.getJaula().getNumero() == numeroJaula) {
				return cuidadorJaula.agregarAnimal(animal);
			}

		}
		return false;
	}

	@Override
	public Boolean verEspectaculoDeDelfines(Visitante visitante) {
		Delfin delfin = new Delfin(1, "Carlos", 'M', 5, "uuuuhhh uhhhhh");
		Delfin delfin2 = new Delfin(2, "Ricardo", 'M', 6, "uuuuhhh uhhhhh");
		Delfin delfin3 = new Delfin(3, "Julian", 'M', 7, "uuuuhhh uhhhhh");
		if (visitarAcuario(visitante)) {
			delfines.add(delfin);
			delfines.add(delfin2);
			delfines.add(delfin3);
			delfin.saltar();
			delfin2.saltar();
			delfin3.saltar();
			return true;
		}
		return false;
	}

	public Boolean asignarCuidadorAJaula(Cuidador cuidador, int numeroJaula) {
		for (CuidadorJaula cuidadorJaula : cuidadoresJaulas) {
			if (cuidadorJaula.getJaula().getNumero() == numeroJaula) {
				cuidadorJaula.asignarCuidador(cuidador);
				return true;
			}
		}
		return false;
	}

	public Set<Animal> buscarAnimalesDeUnaJaula(int numeroJaula) {
		for (CuidadorJaula cuidadorJaula : cuidadoresJaulas) {
			if (cuidadorJaula.getJaula().getNumero() == numeroJaula) {
				return cuidadorJaula.getAnimales();
			}
		}
		;
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
