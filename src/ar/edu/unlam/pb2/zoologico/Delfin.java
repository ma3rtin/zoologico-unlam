package ar.edu.unlam.pb2.zoologico;

public class Delfin extends Animal {
	
	public Delfin(Integer id, String nombre, Character sexo, Integer edad, String sonido) {
		super(id,nombre, sexo, edad, sonido);
		
		this.setAlimento("Peces");
	}

	@Override
	protected Boolean alimentar(String alimento) {
		if(!alimento.equals("Peces")) {
			return false;
		}
		return true;
	}
	
	public Boolean saltar() {
		return true;
	}

	@Override
	public String emitirSonido() {
		return this.getSonido();
	}
	
	@Override
	public String emitirSonido() {
		return "Chasquillos y silbidos";
	}


}
