package animals;

public class Eagle extends Carnivorous implements Voice,Run,Fly{
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
