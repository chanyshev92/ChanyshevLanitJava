package animals;

public class Dog extends Carnivorous implements Voice, Swim, Run{
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
