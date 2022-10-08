import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральную степень: ");
        int k = in.nextInt();

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i <= k; i++) {
            numbers.add((int) (-1 + Math.random() * 10));
        }
        int i = 0;
        for (int item : numbers) {
            if (i <= (k - 2)) {
                if (item != 0){
                    System.out.printf("%dX^%d + ", item, k - i);
                }
                else
                {
                    continue;
                }
            }
            else if (i == (k - 1)){
                if(item != 0)
                {
                    System.out.printf("%dX + ", item);
                }
                else
                {
                    continue;
                }
            }
            else {
                if (item != 0)
                {
                    System.out.printf("%d = 0", item);
                }
                else
                {
                    System.out.print("= 0");
                }
            }
            i++;
        }
    }
}