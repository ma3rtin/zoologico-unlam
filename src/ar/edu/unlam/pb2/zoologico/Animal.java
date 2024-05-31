package ar.edu.unlam.pb2.zoologico;

import java.util.Objects;

public abstract class Animal {
	private Double peso;
	private Double altura;
	private Integer edad;
	private String nombre;
	private Integer id;
	private Character sexo;
	private String alimento;
//	private String sonido;
	
	public Animal (Integer id,String nombre, Character sexo, Integer edad) {
		this.id = id;
	}
	
	public abstract String emitirSonido();

	public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	protected abstract Boolean alimentar(String alimento);

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
