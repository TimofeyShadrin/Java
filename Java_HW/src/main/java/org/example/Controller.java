package org.example;

import java.util.Arrays;

public class Controller {
    static void controller()
    {
        Formula line = new Formula(100);

        Files first = new Files("formula_01.txt");
        Files second = new Files("formula_02.txt");
        first.write(line.create_formula());
        second.write(line.create_formula());

        Read result_01 = new Read("formula_01.txt");
        Read result_02 = new Read("formula_02.txt");
        System.out.println(result_01.read());
        System.out.println(result_02.read());

        Get_ratio getRatio_01 = new Get_ratio(result_01.read());
        Get_ratio getRatio_02 = new Get_ratio(result_02.read());

        System.out.println(Arrays.deepToString(getRatio_01.sum_formulas()));
        System.out.println(Arrays.deepToString(getRatio_02.sum_formulas()));
    }
}
