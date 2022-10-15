package gd.homework;

import java.util.Scanner;

public abstract class Task1 {
//    Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
    private static int n = 0;

    public static void SetN() {
        Scanner scan = new Scanner(System.in);
        while (n == 0) {
            try {
                System.out.print("Enter an integer number > 0: ");
                n = scan.nextInt();
                if (n <= 0) {
                    System.out.println("Input is incorrect!");
                    n = 0;
                }
            } catch (Exception ex) {
                System.out.println("Input is incorrect!");
                SetN();
            }
        }
    }

    public static int getN() {
        return n;
    }

    public static int triangularNumber() {
        int result = 0;
        result = n / 2 * (n + 1);
        return result;
    }

    public static float factorial() {
        float result = 1f;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
