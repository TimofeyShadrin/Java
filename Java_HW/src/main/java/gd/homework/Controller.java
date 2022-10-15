package gd.homework;

public abstract class Controller {
    public static void controller() {
        Task1.SetN();
        System.out.println(Task1.getN());
        System.out.print("Triangular number = ");
        System.out.println(Task1.triangularNumber());
        System.out.print("Factorial = ");
        System.out.println(Task1.factorial());
    }
}
