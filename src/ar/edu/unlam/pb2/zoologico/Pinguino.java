package ar.edu.unlam.pb2.zoologico;

public class Pinguino extends Animal {
	
	private String plumaje;

	public Pinguino(Integer id, String nombre, Character sexo, Integer edad, String sonido, String plumaje) {
		super(id, nombre, sexo, edad, sonido);
		
		this.plumaje = plumaje;
	}

	@Override
	protected Boolean alimentar(String alimento) {
		if (!alimento.equals("Peces") && !alimento.equals("Krill")) {
            return false;
        }
        return true;
	}

	@Override
	public String emitirSonido() {
		return "kiu kiu";
	}

}
