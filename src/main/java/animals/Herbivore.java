package animals;

import food.Food;
import food.Grass;
import food.Meat;
import food.WrongFoodException;

public abstract class Herbivore extends Animal {

    public Herbivore(String name) {
        super(name);
    }

    @Override
    public void eat(Food food) throws WrongFoodException {

        if (food instanceof Grass){
            satiety += food.getEnergy();
            System.out.format("Herbivore happy, satiety - %d %n", satiety);
        }else if (food instanceof Meat){
            throw new WrongFoodException();
        }
    }

}
