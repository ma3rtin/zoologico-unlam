package ar.edu.unlam.pb2.zoologico;

public abstract class Animal {
	private Double peso;
	private Double altura;
	private Integer edad;
	private String nombre;
	private Integer id;
	private Character sexo;
	private String alimento;
	private String sonido;
	
	public Animal (Integer id,String nombre, Character sexo, Integer edad, String sonido) {
		

	}

	public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}
	
	
	
}
