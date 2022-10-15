package gd.homework;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public abstract class Controller {
    public static void controller() throws IOException {
        Task1.SetN();
        System.out.print("Triangular number = ");
        System.out.println(Task1.triangularNumber());
        System.out.print("Factorial = ");
        System.out.println(Task1.factorial());
        System.out.println("Prime numbers of "+ Task1.getN() + " are:");
        System.out.println(String.valueOf(Task2.primeNumbers()));
        System.out.print("Enter formula: ");
        System.out.println("Result = " + Task3.calculate());
    }
}
