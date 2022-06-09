package animals;

import food.Food;

public class Duck extends Herbivore implements Voice,Swim,Fly,Run{
    @Override
    public String getVoice() {
        return "Quack!!";
    }

    @Override
    public void fly() {
        System.out.println("Duck flays");;
    }

    @Override
    public void run() {
        System.out.println("Duck runs");;
    }

    @Override
    public void swim() {
        System.out.println("Duck swims");;
    }
}
