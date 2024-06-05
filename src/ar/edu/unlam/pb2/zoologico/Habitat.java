package ar.edu.unlam.pb2.zoologico;

import java.util.List;
import java.util.ArrayList;

public class Habitat {
	private String nombre;
    private int capacidadMaxima;
    private List<Animal> animales;

    public Habitat(String nombre, int capacidadMaxima) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.animales = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public boolean agregarAnimal(Animal animal) {
        if (animales.size() < capacidadMaxima) {
            animales.add(animal);
            return true;
        }
        return false;
    }

    public boolean removerAnimal(Animal animal) {
        return animales.remove(animal);
    }

    //Representa un hábitat en el zoológico.
}
