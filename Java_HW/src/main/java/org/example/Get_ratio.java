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
                .trim()
                .split(" ");
        int[][] ratios = new int[temp.length][2];
        int i = 0;
        for (String word: temp)
        {
            String[] value = word.split("X");
            //System.out.println(Arrays.toString(value));
            try
            {
                if (value.length == 2) {
                    if (String.valueOf(value[0]).equals("")) {
                        ratios[i][0] = 1;
                    } else {
                        ratios[i][0] = Integer.parseInt(value[0]);
                    }
                    ratios[i][1] = Integer.parseInt(value[1]);
                }
                else if (value.length == 1) {
                    System.out.println(word);
                    if (word.endsWith("X")) {
                        ratios[i][0] = Integer.parseInt(value[0]);
                        ratios[i][1] = 1;
                    } else {
                        ratios[i][0] = Integer.parseInt(value[0]);
                        ratios[i][1] = 0;
                    }
                } else if (value.length == 0) {
                    ratios[i][0] = 1;
                    ratios[i][1] = 1;
                }

            }
            catch (Exception Ex)
            {
                System.out.println(String.valueOf(Ex));
            }
            i++;
        }
        return ratios;
    }
}
