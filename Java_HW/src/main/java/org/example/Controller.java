package org.example;

public class Controller {
    static void controller()
    {
        Formula line = new Formula(100);
        Files first = new Files("formula_01.txt");
        Files second = new Files("formula_02.txt");
        first.write(line.create_formula());
        second.write(line.create_formula());
    }
}
