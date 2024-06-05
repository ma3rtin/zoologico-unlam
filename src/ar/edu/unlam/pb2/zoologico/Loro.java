package ar.edu.unlam.pb2.zoologico;

public class Loro extends Animal {
	
	private String colorPlumas;
	private Boolean puedeHablar;
	
	public Loro(Integer id, String nombre, Character sexo, Integer edad, String sonido, String colorPlumas, Boolean puedeHablar) {
		super(id, nombre, sexo, edad, sonido);
		this.colorPlumas = colorPlumas;
		this.puedeHablar = true;
		this.setAlimento("Semillas");

	
	}

	@Override
	protected Boolean alimentar(String alimento) {
		if(!alimento.equals("Semillas")) {
			return false;
		}
		return true;
	}

	@Override
	public String emitirSonido() {
		return this.getSonido();
	}

}
