package animals;

import food.Food;
import food.Grass;
import food.Meat;
import food.WrongFoodException;

public abstract class Carnivorous extends Animal{

    public Carnivorous(String name) {
        super(name);
    }

    @Override
    public void eat(Food food) throws WrongFoodException {

        if (food instanceof Meat){
            satiety += food.getEnergy();
            System.out.format("Carnivorous happy, satiety  - %d %n", satiety);
        }else if (food instanceof Grass){
            throw new WrongFoodException();
        }
    }

}
