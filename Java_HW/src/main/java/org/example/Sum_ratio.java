package org.example;

import java.util.ArrayList;

public class Sum_ratio {

    private final int[][] ratios_01;
    private final int[][] ratios_02;

    public Sum_ratio(int[][] ratios_01, int[][] ratios_02) {
        this.ratios_01 = ratios_01;
        this.ratios_02 = ratios_02;
    }

    private int[][] findAndSumOne(int[] row, int[][] incoming)
    {
        for (int[] item: incoming)
        {
            if (item[1] == row[1])
            {
                item[0] += row[0];
            }
        }
        return incoming;
    }

    public int[][] resultOfSum()
    {
        int[][] min_array = ratios_01;
        int[][] max_array = ratios_02;
        if(ratios_02.length < ratios_01.length)
        {
            min_array = ratios_02;
            max_array = ratios_01;
        }
        int[][] result = new int[max_array.length][2];
        for (int[] line: min_array)
        {
            result = findAndSumOne(line, max_array);
        }
        return result;
    }
}
