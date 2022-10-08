import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\nВведите натуральную степень: ");
        int k = in.nextInt();

        int[][] ratio = new int[k][2];
        String[] members = new String[k + 1];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                ratio[i][0] = (int)(Math.random() * 5);
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
        members[k] = Integer.toString((int)(Math.random() * 100));

        ArrayList<String> temp = new ArrayList<>();
        for (String member: members)
        {
            if (!Objects.equals(member, ""))
            {
                temp.add(member);
            }
        }

        System.out.printf("\n%S = 0\n", String.join(" + ", temp));
    }
}