package model;

import animals.Animal;

import java.util.HashMap;

public class Aviary<T extends Animal> {

    private Size size;
    private HashMap<String, T> aviaryMap;

    public Aviary(Size size) {
        this.size = size;
        aviaryMap = new HashMap<>();
    }

    public void addAnimal(T animal) {

        if (size == animal.getSize()) {
            aviaryMap.put(animal.getName(), animal);
        } else {
            throw new WrongSizeException();
        }
    }

    public T getAnimal(String name) {

        return aviaryMap.get(name);
    }

    public boolean removeAnimal(String name) {

        T animalType = getAnimal(name);
        if (animalType != null) {
            aviaryMap.remove(name);
            return true;
        } else {
            return false;
        }
    }
}
