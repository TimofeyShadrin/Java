package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Formula {

    private final int max_ratio;

    public Formula()
    {
        this.max_ratio = 5;
    }

    public Formula(int max_ratio)
    {
        this.max_ratio = max_ratio;
    }
    public int[][] createArrayForFormula()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральную степень: ");
        int k = in.nextInt();

        int[][] ratio = new int[k + 1][2];
        String[] members = new String[k + 1];

        for (int i = 0; i < k + 1; i++) {
                ratio[i][0] = (int)(Math.random() * max_ratio);
                ratio[i][1] = k - i;
            }
        return ratio;
    }
    public String create_formula(int[][] incoming)
    {
        int k = incoming.length;
        String[] members = new String[k];

        for (int i = 0; i < k; i++) {
            if (incoming[i][0] > 1 && incoming[i][1] > 1)
            {
                members[i] = Integer.toString(incoming[i][0]) + "X^" + Integer.toString(incoming[i][1]);
            }
            else if (incoming[i][1] == 1 && incoming[i][0] > 1)
            {
                members[i] = Integer.toString(incoming[i][0]) + "X";
            }
            else if (incoming[i][0] == 1 && incoming[i][1] > 1)
            {
                members[i] = "X^" + Integer.toString(incoming[i][1]);
            }
            else if (incoming[i][0] == 0)
            {
                members[i] = "0";
            }
            else if (incoming[i][0] == 1 && incoming[i][1] == 1)
            {
                members[i] = "X";
            }
            else if (incoming[i][0] > 0 && incoming[i][1] == 0)
            {
                members[i] = Integer.toString(incoming[i][0]);
            }
        }

        ArrayList<String> temp = new ArrayList<>();
        for (String member: members)
        {
            if (!Objects.equals(member, "0"))
            {
                temp.add(member);
            }
        }

        return String.join(" + ", temp) + " = 0";
    }
}
