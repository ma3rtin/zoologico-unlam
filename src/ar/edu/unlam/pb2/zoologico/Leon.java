package ar.edu.unlam.pb2.zoologico;

public class Leon extends Animal {

	private String melena;
	
	public Leon(Integer id, String nombre, Character sexo, Integer edad, String sonido,String melena) {
		super(id,nombre, sexo, edad, sonido);
		this.melena = melena;
		this.setAlimento("Carne");
	}

	@Override
	protected Boolean alimentar(String alimento) {
		if(!alimento.equals("Carne")) {
			return false;
		}
		return true;
	}
	
}
