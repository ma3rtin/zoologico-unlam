package ar.edu.unlam.pb2.zoologico;

import java.util.Comparator;

<<<<<<< HEAD
public class AnimalesOrdenadosPorNombreDescendente implements Comparator<Animal> {


=======
public class AnimalesOrdenadosPorNombreDescendente implements Comparator <Animal> {
>>>>>>> master
	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

<<<<<<< HEAD
=======

>>>>>>> master
}
