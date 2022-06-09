package animals;

public class Cow extends Herbivore implements Voice,Run{
    @Override
    public String getVoice() {
        return "Moo!";
    }

    @Override
    public void run() {
        System.out.println("Cow runs");
    }
}
