import animals.*;
import employee.Worker;
import food.Food;
import food.Grass;
import food.Meat;
import model.Aviary;
import model.Size;

public class Zoo {

    private static Aviary<Carnivorous> carnivorousAviary = new Aviary<>(Size.SMALL);
    private static Aviary<Herbivore> herbivoreAviary = new Aviary<>(Size.MEDIUM);

    public static Carnivorous getCarnivorous(String name) {
        return carnivorousAviary.getAnimal(name);
    }

    public static Herbivore getHerbivore(String name) {
        return herbivoreAviary.getAnimal(name);
    }
    public static Swim[] createPond(){
        Swim[] swims = new Swim[4];
        swims[0] = new Duck();
        swims[1] = new Fish();
        swims[2] = new Kotik();
        swims[3] = new Dog();
        return swims;
    }
    static void fillCarnivorousAviary() {
        //carnivorousAviary.addAnimal(new Dog("Dog"));
        carnivorousAviary.addAnimal(new Eagle("Eagle"));
        carnivorousAviary.addAnimal(new Kotik("Kotik"));
        carnivorousAviary.addAnimal(new Kotik());
        //carnivorousAviary.addAnimal(new Duck("Outy-Poty"));
    }

    static void fillHerbivoreAviary() {
        herbivoreAviary.addAnimal(new Goat("Shelter"));
        herbivoreAviary.addAnimal(new Fish("Fish"));
        herbivoreAviary.addAnimal(new Fish());
        //herbivoreAviary.addAnimal(new Dog("Polkan"));
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
        //worker.feed(kotik,grass);

        worker.getVoice(kotik);
        //worker.getVoice(fish);

        for(Swim a : createPond()){
            a.swim();
        }

        fillCarnivorousAviary();
        fillHerbivoreAviary();


    }
}
