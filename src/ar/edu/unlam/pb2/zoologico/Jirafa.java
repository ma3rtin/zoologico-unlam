package ar.edu.unlam.pb2.zoologico;

public class Jirafa extends Animal {
	
	Double longitudCuello;

	public Jirafa(Integer id, String nombre, Character sexo, Integer edad, String sonido, Double longitudCuello) {
		super(id, nombre, sexo, edad, sonido);
		this.longitudCuello = longitudCuello;
	}

	@Override
	protected Boolean alimentar(String alimento) {
		// TODO Auto-generated method stub
		return null;
	}
}
