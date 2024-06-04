package ar.edu.unlam.pb2.zoologico;

import java.util.ArrayList;

public interface Acuario {
	Boolean visitarAcuario(Visitante visitante);
	Boolean alimentarALosPeces(Visitante visitante);
	Boolean verEspectaculoDeDelfines(Visitante visitante);
	Boolean agregarVisitaGuiada(VisitaGuiada visitasGuiadas);
}
