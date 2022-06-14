package animals;

import model.Size;

public class Fish extends Herbivore implements Swim{
    public Fish(String name) {
        super(name);
    }

    public Fish() {
        super("fish");
    }

    @Override
    public Size getSize() {
        return Size.MEDIUM;
    }

    @Override
    public void swim() {
        System.out.println("Fish has already swam!");
    }
}
