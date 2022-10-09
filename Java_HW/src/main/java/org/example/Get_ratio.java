package org.example;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Arrays;

public class Get_ratio {

    private final String formula;

    @Contract(pure = true)
    public Get_ratio(ArrayList<String> formula)
    {
        this.formula = formula.get(0);
    }

    public int[][] get_ratios()
    {
        String[] temp = formula
                .replace("^", "")
                .replace(" = 0", "")
                .replace(" + ", " ")
                .split(" ");
        int[][] ratios = new int[temp.length][2];
        int i = 0;
        for (String word: temp)
        {
            String[] value = word.split("X");
            try
            {
                ratios[i][0] = Integer.parseInt(value[0]);
            }
            catch (Exception ex)
            {
                ratios[i][0] = 1;
            }
            if (i < temp.length - 2)
            {
                ratios[i][1] = Integer.parseInt(value[1]);
            }
            else if (i == (temp.length - 2))
            {
                ratios[i][1] = 1;
            }
            else if (i == (temp.length - 1))
            {
                ratios[i][1] = 0;
            }
            i++;
        }
        return ratios;
    }
}
