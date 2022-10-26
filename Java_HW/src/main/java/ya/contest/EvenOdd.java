package ya.contest;

import java.util.Scanner;
import java.util.logging.Logger;

public class EvenOdd {

    private int anInt = 0;
    private final Logger log = Logger.getLogger(EvenOdd.class.getName());

    public void setAnInt() {
        while (anInt <= 0) {
            try {
                Scanner scan = new Scanner(System.in);
                log.info("Enter an integer and positive number:");
                anInt = Integer.parseInt(scan.nextLine());
                scan.close();

            } catch (NumberFormatException ex) {
                log.warning("Your input is incorrect! Try again.");
                anInt = 0;
            }
        }
    }

    private int[][] createMatrix() {
        
        int[][] result = new int[2 * anInt + 1][2 * anInt + 1];
        int even = 1;
        int odd = -1;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (i == j) result[i][j] = 0;
                else if (i % 2 == 0 && j % 2 != 0 ||
                        i % 2 != 0 && j % 2 == 0) {
                    result[i][j] = even++;
                }
                else {
                    result[j][i] = odd--;
                }
            }
        }
        return result;
    }

    public String printMatrix() {
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < createMatrix().length; i++) {
            for (int j = 0; j < createMatrix()[i].length; j++) {
                sb.append(createMatrix()[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return String.valueOf(sb);
    }
}
