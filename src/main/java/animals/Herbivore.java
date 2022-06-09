package animals;

import food.Food;
import food.Grass;
import food.Meat;

public abstract class Herbivore extends Animal {

    @Override
    public void eat(Food food) {
        if (food instanceof Grass){
            satiety += food.getEnergy();
            System.out.format("Herbivore happy, satiety - %d %n", satiety);
        }else if (food instanceof Meat){
            System.out.println("Herbivore angry");
        }

    }

}
