package gb.homework;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public abstract class Task1 {
//    Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
    private static int n = 0;
    private static final Logger log = Logger.getLogger(Task1.class.getName());

    public static void SetN() {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            try {
                log.info("Write your number");
                n = scan.nextInt();
                if(n <= 0){
                    log.warning("Input is incorrect!");
                    n = 0;
                } else {
                    flag = false;
                }
            } catch (InputMismatchException ex) {
                log.warning("Input is incorrect!");
                //SetN();
            }
            finally {
                n = 0;
            }
        }
        scan.close();
    }

    public static int getN() {
        return n;
    }

    public static int triangularNumber() {
        int result;
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
