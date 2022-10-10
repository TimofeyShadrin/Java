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
        int j = 0;
        for (String word: temp)
        {
            String[] value = word.split("X");
            //System.out.println(Arrays.toString(value));
            try
            {
                ratios[i][0] = Integer.parseInt(value[0]);
            }
            catch (Exception ex)
            {
                ratios[i][0] = 1;
            }
            try
            {
                ratios[i][1] = Integer.parseInt(value[1]);
            }
            catch (Exception ex)
            {
                if (j == 0) ratios[i][1] = 1;
                else ratios[i][1] = 0;
                j++;
            }
            i++;
        }
        return ratios;
    }
}
