import animals.*;
import employee.Worker;
import food.Food;
import food.Grass;
import food.Meat;

public class Zoo {
    public static Swim[] createPond(){
        Swim[] swims = new Swim[4];
        swims[0] = new Duck();
        swims[1] = new Fish();
        swims[2] = new Kotik();
        swims[3] = new Dog();
        return swims;
    }
    public static void main(String[] args) {

        Kotik kotik = new Kotik();
        Animal duck = new Duck();
        Fish fish = new Fish();
        Animal dog = new Dog();

        Food grass = new Grass();
        Food meat = new Meat();

        Worker worker = new Worker();

        worker.feed(kotik,meat);

        worker.getVoice(kotik);
        //worker.getVoice(fish);

        for(Swim a : createPond()){
            a.swim();
        }


    }
}
