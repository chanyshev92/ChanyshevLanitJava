import model.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] params = readParams();
        System.out.println(Calculator.execute(params));
    }

    private static String[] readParams() {

        Scanner in = new Scanner(System.in);
        String operator = in.nextLine();
        String arg1 = in.nextLine();
        String arg2 = in.nextLine();
        return new String[]{operator, arg1, arg2};
    }
}
