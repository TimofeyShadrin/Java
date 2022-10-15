package gd.homework;

import java.util.ArrayList;

public abstract class Task2 {
// Вывести все простые числа от 1 до 1000
    private static final int number = Task1.getN();

    public static ArrayList<Integer> primeNumbers() {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i < number + 1; i++) {
            boolean test = true;
            for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++) {
                if (i % j == 0) {
                    test = false;
                    break;
                }
            }
            if (test) {
                result.add(i);
            }
        }
        return result;
    }
}
