package ar.edu.unlam.pb2.zoologico;

public class Elefante extends Animal {

	private Double tamanioColmillos;
	
	public Elefante(Integer id, String nombre, Character sexo, Integer edad, String sonido, Double tamanioColmillos) {
		super(id, nombre, sexo, edad, sonido);
		this.tamanioColmillos = tamanioColmillos;
	}

	@Override
	protected Boolean alimentar(String alimento) {
		 // Los elefantes pueden comer una variedad de alimentos.
        switch (alimento) {
            case "Hierbas":
            case "Hojas":
            case "Frutas":
            case "Corteza":
            case "Raíces":
            case "Flores":
                return true;
            default:
                return false;
        }
	}
<<<<<<< HEAD

	@Override
	public String emitirSonido() {
		return this.getSonido();
	}
=======
	
	@Override
	public String emitirSonido() {
		return "Trumpet";
	}

>>>>>>> master
}
