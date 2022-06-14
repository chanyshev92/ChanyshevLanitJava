package animals;

import model.Size;

public class Cow extends Herbivore implements Voice,Run{
    public Cow(String name) {
        super(name);
    }

    @Override
    public Size getSize() {
        return Size.LARGE;
    }

    @Override
    public String getVoice() {
        return "Moo!";
    }

    @Override
    public void run() {
        System.out.println("Cow runs");
    }
}
