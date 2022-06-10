package animals;

import model.Size;

public class Duck extends Herbivore implements Voice,Swim,Fly,Run{

    public Duck(String name) {
        super(name);
    }

    public Duck() {
        super("Duck");
    }

    @Override
    public Size getSize() {
        return Size.SMALL;
    }

    @Override
    public String getVoice() {
        return "Quack!!";
    }

    @Override
    public void fly() {
        System.out.println("Duck flays");
    }

    @Override
    public void run() {
        System.out.println("Duck runs");
    }

    @Override
    public void swim() {
        System.out.println("Duck swims");
    }
}
