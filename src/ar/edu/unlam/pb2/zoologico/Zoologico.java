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
	private Double precioEntradaBase;
	private Double precioEntradaPremium;
	private Set<Visitante> visitantes;
	private Set<VisitaGuiada> visitasGuiadas;
	private List<Delfin> delfines;
	private Set<CuidadorJaula> cuidadoresJaulas;
	private List<Pez> peces;


	public Zoologico(String nombre, LocalTime horaInicioVisita, LocalTime horaFinVisita) {
		this.nombre = nombre;
		this.horaInicioVisita = horaInicioVisita;
		this.horaFinVisita = horaFinVisita;
		this.precioEntradaBase = 500.0;
		this.precioEntradaPremium = 1000.0;
		this.peces = new ArrayList<>();
		this.visitantes = new TreeSet<>();
		this.visitasGuiadas = new HashSet<>();
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
	
		@Override
	public Boolean visitarAcuario(Visitante visitante) {
		if (visitante.getTipoEntrada().equals(TipoDeEntrada.ENTRADA_PREMIUM)) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean alimentarALosPeces(Visitante visitante) {
		if (visitarAcuario(visitante)) {
			for (Pez pez : peces) {
				pez.alimentar("Gusano");
			}
			return true;
		}
		return false;
    }
	
	public Boolean agregarPeces(Pez pez) {
        return this.peces.add(pez);

	}

	public Boolean agregarJaula(Jaula jaula) {
		CuidadorJaula cuidadorJaula = new CuidadorJaula(null, jaula);
		return this.cuidadoresJaulas.add(cuidadorJaula);
	}

	public Boolean agregarCuidadorJaula(Cuidador cuidador, Jaula jaula) {
		return this.cuidadoresJaulas.add(new CuidadorJaula(cuidador, jaula));
	}

	public Boolean agregarAnimalAJaula(Animal animal, Integer numeroJaula) {
		for (CuidadorJaula cuidadorJaula : cuidadoresJaulas) {
			if (cuidadorJaula.getJaula().getNumero() == numeroJaula) {
				return cuidadorJaula.agregarAnimal(animal);
			}

		}
		return false;
	}


	@Override
	public Boolean verEspectaculoDeDelfines(Visitante visitante) {
		if (visitarAcuario(visitante)) {
			for (Delfin delfin : delfines) {
				delfin.saltar();
			}
			return true;
		}
		return false;
	}

	public Boolean asignarCuidadorAJaula(Cuidador cuidador, Integer numeroJaula) {
		for (CuidadorJaula cuidadorJaula : cuidadoresJaulas) {
			if (cuidadorJaula.getJaula().getNumero() == numeroJaula) {
				cuidadorJaula.asignarCuidador(cuidador);
				return true;
			}
		}
		return false;
	}

	public List<Animal> buscarAnimalesDeUnaJaula(Integer numeroJaula) {
		for (CuidadorJaula cuidadorJaula : cuidadoresJaulas) {
			if (cuidadorJaula.getJaula().getNumero() == numeroJaula) {
				return cuidadorJaula.getAnimales();
			}
		}
		;
		return null;
	}
	
	public List<Animal> buscarAnimalesDeUnaJaulaOrdenadosPorNombre(Integer numeroJaula) {
		for (CuidadorJaula cuidadorJaula : cuidadoresJaulas) {
			if (cuidadorJaula.getJaula().getNumero() == numeroJaula) {
				return cuidadorJaula.obtenerAnimalesOrdenadosPorNombre();
			}
		}
		return null;

	}
	
	public boolean agregarDelfin(Delfin delfin) {
		return this.delfines.add(delfin);
	}
	
	
	public boolean agregarPez(Pez pez) {
		return this.peces.add(pez);
	}



}
