package gd.homework;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Task3 {

    private static final ArrayList<String> result = new ArrayList<>();

    public static String getInput() {
        Scanner scan = new Scanner(System.in);
        StringBuilder temp = new StringBuilder();
        String input = scan.nextLine();
        for (char ch: input.toCharArray()) {
            switch (ch) {
                case '+' -> temp.append(" + ");
                case '-' -> temp.append(" - ");
                case '*' -> temp.append(" * ");
                case '/' -> temp.append(" / ");
                default -> temp.append(ch);
            }
        }
        input = String.valueOf(temp);
        System.out.println(input);
        StringBuilder filter = new StringBuilder();
        for (char ch: input.toCharArray()) {
            if (flag(ch)) filter.append(ch);
        }
        input = String.valueOf(filter);
        return input;
    }

    private static boolean flag(char ch) {
        boolean flag = false;
        String necessarily = "0123456789+-*/. ";
        for (char symbol: necessarily.toCharArray()) {
            if (ch == symbol) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
