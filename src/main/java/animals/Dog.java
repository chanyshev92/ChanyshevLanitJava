package animals;

import model.Size;

public class Dog extends Carnivorous implements Voice, Swim, Run{
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super("Dog");
    }

    @Override
    public Size getSize() {
        return Size.MEDIUM;
    }

    @Override
    public void run() {
        System.out.println("Dog runs!");
    }

    @Override
    public void swim() {
        System.out.println("Dog swims");
    }

    @Override
    public String getVoice() {
        return "Bark!";
    }
}
