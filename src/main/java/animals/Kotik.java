package animals;

public class Kotik {

    private static int count;
    private static final int METHODS = 5;

    private String name;
    private String voice;
    private int satiety;
    private int weight;

    public Kotik(String name, String voice, int satiety, int weight) {
        this.name = name;
        this.voice = voice;
        this.satiety = satiety;
        this.weight = weight;
        count++;
    }

    public Kotik() {
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static int getCount() {
        return count;
    }

    public boolean play() {
        if (satiety > 0) {
            System.out.println("plays");
            satiety--;
            return true;
        } else {

            System.out.println("hungry");
            return false;
        }


    }

    public boolean sleep() {
        if (satiety > 0) {
            System.out.println("sleeps");
            satiety--;
            return true;
        } else {

            System.out.println("hungry");
            return false;
        }

    }

    public boolean wash() {
        if (satiety > 0) {
            System.out.println("washes");
            satiety--;
            return true;
        } else {

            System.out.println("hungry");
            return false;
        }

    }

    public boolean walk() {
        if (satiety > 0) {
            System.out.println("walks");
            satiety--;
            return true;
        } else {

            System.out.println("hungry");
            return false;
        }

    }

    public boolean hunt() {
        if (satiety > 0) {
            System.out.println("hunts");
            satiety--;
            return true;
        } else {

            System.out.println("hungry");
            return false;
        }

    }

    public void eat() {
        eat(1, "defaultFoodName");
    }

    public void eat(int satiety) {
        this.satiety += satiety;

    }

    public void eat(int satiety, String foodName) {
        this.satiety += satiety;

    }

    public String[] liveAnotherDay() {
        String[] strings = new String[24];
        for (int i = 0; i < 24; i++) {
            int rand = (int) (Math.random() * METHODS) + 1;
            switch (rand) {
                case (1): {
                    if (play()) {
                        strings[i] = String.format("%d - %s", i, "play");
                    } else {
                        eat(10);
                        strings[i] = String.format("%d - %s", i, "eat");
                    }
                    continue;
                }
                case (2):
                    if (sleep()) {
                        strings[i] = String.format("%d - %s", i, "sleep");
                    } else {
                        eat(10);
                        strings[i] = String.format("%d - %s", i, "eat");
                    }
                    continue;
                case (3):
                    if (wash()) {
                        strings[i] = String.format("%d - %s", i, "wash");
                    } else {
                        eat(10);
                        strings[i] = String.format("%d - %s", i, "eat");
                    }
                    continue;
                case (4):
                    if (walk()) {
                        strings[i] = String.format("%d - %s", i, "walk");
                    } else {
                        eat(10);
                        strings[i] = String.format("%d - %s", i, "eat");
                    }
                    continue;
                case (5): {
                    if (hunt()) {
                        strings[i] = String.format("%d - %s", i, "hunt");
                    } else {
                        eat(10);
                        strings[i] = String.format("%d - %s", i, "eat");
                    }
                }

            }
        }

        return strings;
    }
}

