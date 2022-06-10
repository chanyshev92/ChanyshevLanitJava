package animals;

import model.Size;

public class Goat extends Herbivore implements Voice,Run{

    public Goat(String name) {
        super(name);
    }

    @Override
    public Size getSize() {
        return Size.MEDIUM;
    }

    @Override
    public String getVoice() {
        return "Goo!";
    }

    @Override
    public void run() {
        System.out.println("Goat runs");
    }
}
