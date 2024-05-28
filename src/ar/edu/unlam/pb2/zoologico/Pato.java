package ar.edu.unlam.pb2.zoologico;

public class Pato extends Animal {

	Double longitudPico;

	public Pato(Integer id, String nombre, Character sexo, Integer edad, Double longitudPico) {
		super(id, nombre, sexo, edad);
		this.longitudPico = longitudPico;
	}

	@Override
	public String emitirSonido() {
		return "cuac";
	}

	@Override
	protected Boolean alimentar(String alimento) {
		// TODO Auto-generated method stub
		return null;
	}

}
