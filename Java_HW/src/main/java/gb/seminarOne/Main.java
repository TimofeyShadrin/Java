package gb.seminarOne;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Main.class.getName());
        Degree degree = new Degree();
        try (Scanner scanner = new Scanner(System.in)) {
            log.info("Enter a number: ");
            degree.setNumber(scanner.nextDouble());
            log.info("Enter a degree: ");
            degree.setDegree(scanner.nextDouble());
            String message;
            if (degree.getDegree() < 0)
                message = "And your result is: " + String.format("%.2f", degree.getResult());
            else {
                message = "And your result is: " + String.format("%.0f", degree.getResult());
            }
            log.info(message);
        }
        catch (InputMismatchException ex) {
            log.warning("Your input is incorrect!");
        }
    }
}


