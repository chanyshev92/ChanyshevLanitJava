package animals;

import model.Size;

public class Eagle extends Carnivorous implements Voice,Run,Fly{
    public Eagle(String name) {
        super(name);
    }

    @Override
    public Size getSize() {
        return Size.SMALL;
    }

    @Override
    public void fly() {
        System.out.println("Eagle flies");
    }

    @Override
    public void run() {
        System.out.println("Eagle walks");
    }

    @Override
    public String getVoice() {
        return "EAAAAAGLE";
    }
}
