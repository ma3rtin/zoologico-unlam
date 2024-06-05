package ar.edu.unlam.pb2.zoologico;

import java.util.Comparator;

public class AnimalesOrdenadosPorNombreDescendente implements Comparator <Animal> {
	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

 // implementa la interfaz Comparator para proporcionar una lógica de comparación específica
//para objetos de tipo Animal. 
//En este caso, la comparación se realiza en función del nombre del animal en orden descendente.
	
	
/*	Descripción: Compara dos objetos Animal en función de su nombre.
	Parámetros:
	Animal o1 - el primer animal a comparar.
	Animal o2 - el segundo animal a comparar.
	Retorno: Un entero que indica el orden relativo de los objetos:
	Un valor negativo si o2 debe preceder a o1.
	Cero si o1 y o2 son iguales en términos de orden.
	Un valor positivo si o1 debe preceder a o2.
	
	*/
}
