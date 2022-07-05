import animals.Kotik;

import java.util.Objects;

public class Application {
    public static boolean compareVoice(Kotik kotik0, Kotik kotik1) {
        if (kotik0 != null && kotik1 != null) {
            return Objects.equals(kotik0.getVoice(), kotik1.getVoice());
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello,World!");
        Kotik kotik1 = new Kotik();
        kotik1.setName("Murka");
        kotik1.setVoice("Mrr");
        kotik1.setSatiety(10);
        kotik1.setWeight(5);
        Kotik kotik2 = new Kotik("Barsik", "Mew", 10, 6);
        String[] strings = kotik2.liveAnotherDay();
        for (String string :
                strings) {
            System.out.println(string);

        }
        System.out.printf("Cat with name %s has weight %d %n", kotik1.getName(), kotik1.getWeight());
        System.out.println(compareVoice(kotik1, kotik2));
        System.out.println(Kotik.getCount());


    }
}
