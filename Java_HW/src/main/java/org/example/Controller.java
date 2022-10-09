package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    static void controller()
    {
        Formula line_01 = new Formula(3);
        Formula line_02 = new Formula(3);

        Files first = new Files("formula_01.txt");
        Files second = new Files("formula_02.txt");
        first.write(line_01.create_formula(line_01.createArrayForFormula()));
        second.write(line_02.create_formula(line_02.createArrayForFormula()));

        Read result_01 = new Read("formula_01.txt");
        Read result_02 = new Read("formula_02.txt");
        System.out.println(result_01.read());
        System.out.println(result_02.read());

        Get_ratio getRatio_01 = new Get_ratio(result_01.read());
        Get_ratio getRatio_02 = new Get_ratio(result_02.read());

        System.out.println(Arrays.deepToString(getRatio_01.get_ratios()));
        System.out.println(Arrays.deepToString(getRatio_02.get_ratios()));
        Sum_ratio test = new Sum_ratio(getRatio_01.get_ratios(), getRatio_02.get_ratios());

        int[][] result = test.resultOfSum();
        System.out.println(Arrays.deepToString(result));
        Formula line_03 = new Formula();
        String out_formula = line_03.create_formula(result);
        System.out.println(out_formula);

        Files third = new Files("Result.txt");
        third.write(out_formula);
    }
}
