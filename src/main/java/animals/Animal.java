package animals;

import food.Food;
import food.WrongFoodException;
import model.Size;

public abstract class Animal{

    protected int satiety;
    protected String name;

    public Animal(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public abstract Size getSize();

    public abstract void eat(Food food) throws WrongFoodException;
}
