package animals;

import food.Food;
import food.Grass;
import food.Meat;

public abstract class Carnivorous extends Animal{

    @Override
    public void eat(Food food) {
        if (food instanceof Meat){
            satiety += food.getEnergy();
            System.out.format("Carnivorous happy, satiety  - %d %n", satiety);
        }else if (food instanceof Grass){
            System.out.println("Carnivorous angry");
        }
    }

}
