package ar.edu.unlam.pb2.zoologico;

public class Pez extends Animal {
	public Pez(Integer id, String nombre, Character sexo, Integer edad, String sonido) {
		super(id,nombre, sexo, edad, sonido);
	
		this.setAlimento("Gusano");
	}

	@Override
	protected Boolean alimentar(String alimento) {
		if(!alimento.equals("Gusano")) {
			return false;
		}
		return true;
	}

	@Override
	public String emitirSonido() {
		return this.getSonido();
	}
	

}
