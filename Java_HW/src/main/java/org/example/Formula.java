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
    public String create_formula()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\nВведите натуральную степень: ");
        int k = in.nextInt();

        int[][] ratio = new int[k][2];
        String[] members = new String[k + 1];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                ratio[i][0] = (int)(Math.random() * max_ratio);
                ratio[i][1] = k - i;
            }
            if (ratio[i][0] > 1 && ratio[i][1] > 1)
            {
                members[i] = Integer.toString(ratio[i][0]) + "X^" + Integer.toString(ratio[i][1]);
            }
            else if (ratio[i][1] == 1)
            {
                members[i] = Integer.toString(ratio[i][0]) + "X";
            }
            else if (ratio[i][0] == 1)
            {
                members[i] = "X^" + Integer.toString(ratio[i][1]);
            }
            else if (ratio[i][0] == 0)
            {
                members[i] = "";
            }
        }
        members[k] = Integer.toString((int)(Math.random() * max_ratio));

        ArrayList<String> temp = new ArrayList<>();
        for (String member: members)
        {
            if (!Objects.equals(member, ""))
            {
                temp.add(member);
            }
        }

        return String.join(" + ", temp) + " = 0";
    }
}
