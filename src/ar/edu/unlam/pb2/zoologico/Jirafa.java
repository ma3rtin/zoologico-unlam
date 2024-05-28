package ar.edu.unlam.pb2.zoologico;

public class Jirafa extends Animal {
	
	Double longitudCuello;

	public Jirafa(Integer id, String nombre, Character sexo, Integer edad, Double longitudCuello) {
		super(id, nombre, sexo, edad);
		this.longitudCuello = longitudCuello;
	}

	@Override
	protected Boolean alimentar(String alimento) {
		
		return null;
	}

	@Override
	public String emitirSonido() {
		return "...";
	}
}
