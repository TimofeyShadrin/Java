package org.example;

import java.util.ArrayList;

public class Sum_ratio {

    private final int[][] ratios_01;
    private final int[][] ratios_02;

    public Sum_ratio(int[][] ratios_01, int[][] ratios_02) {
        this.ratios_01 = ratios_01;
        this.ratios_02 = ratios_02;
    }

    public int[][] resultOfSum()
    {
        //System.out.println(String.valueOf(Math.max(ratios_01[0][1], ratios_02[0][1]) + 1));
        int[][] result = new int[Math.max(ratios_01[0][1], ratios_02[0][1]) + 1][2];
        for (int[] line: ratios_01)
        {
            result[result.length - 1 - line[1]] = line;
        }
        for (int[] line: ratios_02)
        {
            if (result[result.length - 1 - line[1]][1] == line[1]) {
                result[result.length - 1 - line[1]][0] += line[0];
            }
            else result[result.length - 1 - line[1]] = line;
        }
        return result;
    }
}
