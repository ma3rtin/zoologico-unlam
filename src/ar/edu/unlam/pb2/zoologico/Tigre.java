package ar.edu.unlam.pb2.zoologico;

public class Tigre extends Animal {
	
	Integer rayas;

	public Tigre(Integer id, String nombre, Character sexo, Integer edad, Integer rayas) {
		super(id, nombre, sexo, edad);
		this.rayas = rayas;
	}

	@Override
	protected Boolean alimentar(String alimento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String emitirSonido() {
		return "grrr";
	}
}
