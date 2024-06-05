package ar.edu.unlam.pb2.zoologico;

import java.util.ArrayList;

public interface Acuario {
	Boolean visitarAcuario(Visitante visitante);
	Boolean alimentarALosPeces(Visitante visitante);
	Boolean verEspectaculoDeDelfines(Visitante visitante);
	Boolean agregarVisitaGuiada(VisitaGuiada visitasGuiadas);
	
	//La interfaz Acuario define un conjunto de métodos que cualquier clase 
	//que la implemente debe proporcionar. 
	//Estos métodos están relacionados con las actividades y 
	//servicios que se ofrecen en la sección del acuario dentro del zoológico.
}
