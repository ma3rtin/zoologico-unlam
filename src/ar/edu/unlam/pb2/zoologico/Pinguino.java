package ar.edu.unlam.pb2.zoologico;

public class Pinguino extends Animal {
	
	String plumaje;

	public Pinguino(Integer id, String nombre, Character sexo, Integer edad, String plumaje) {
		super(id, nombre, sexo, edad);
		
		this.plumaje = plumaje;
	}

	@Override
	protected Boolean alimentar(String alimento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String emitirSonido() {
		return "kiu kiu";
	}

}