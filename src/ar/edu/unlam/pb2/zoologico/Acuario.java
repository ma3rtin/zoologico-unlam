package ar.edu.unlam.pb2.zoologico;

import java.util.ArrayList;

public interface Acuario {
	Boolean visitarAcuario(Visitante visitante);
	Boolean alimentarALosPeses(Visitante visitante,ArrayList<Pez> peces);
}
