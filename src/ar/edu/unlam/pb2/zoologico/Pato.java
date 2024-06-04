package ar.edu.unlam.pb2.zoologico;

public class Pato extends Animal {

	private Double longitudPico;

	public Pato(Integer id, String nombre, Character sexo, Integer edad, String sonido, Double longitudPico) {
		super(id, nombre, sexo, edad, sonido);
		this.longitudPico = longitudPico;
	}

	@Override
	public String emitirSonido() {
		return "Cuack";
	}

	@Override
	protected Boolean alimentar(String alimento) {
		 if (!alimento.equals("Granos") && !alimento.equals("Plantas acuáticas")) {
	            return false;
	        }
	        return true;
	}

}
