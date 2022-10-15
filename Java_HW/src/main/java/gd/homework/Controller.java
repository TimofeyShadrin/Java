package gd.homework;

public abstract class Controller {
    public static void controller() {
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
