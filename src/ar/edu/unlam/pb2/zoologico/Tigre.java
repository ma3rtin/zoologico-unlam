package ar.edu.unlam.pb2.zoologico;

public class Tigre extends Animal {

	private String patronRayas; 
	
	public Tigre(Integer id, String nombre, Character sexo, Integer edad, String sonido, String patronRayas) {
		super(id, nombre, sexo, edad, sonido);
		this.patronRayas = patronRayas;
		
	}

	@Override
	protected Boolean alimentar(String alimento) {
		if(!alimento.equals("Carne")) {
			return false;
		}
		return true;
	}

}
