package gb.homework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public abstract class Task3 {
// Реализовать простой калькулятор

    private static String[] getInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder temp = new StringBuilder();
        for (char ch: input.toCharArray()) {
            switch (ch) {
                case '+' -> temp.append(" + ");
                case '-' -> temp.append(" - ");
                case '*' -> temp.append(" * ");
                case '/' -> temp.append(" / ");
                default -> temp.append(ch);
            }
        }
        input = String.valueOf(temp);
        StringBuilder filter = new StringBuilder();
        for (char ch: input.toCharArray()) {
            if (flag(ch)) filter.append(ch);
        }
        input = String.valueOf(filter);
        return input.split(" ");
    }

    private static boolean flag(char ch) {
        boolean flag = false;
        String necessarily = "0123456789+-*/. ";
        for (char symbol: necessarily.toCharArray()) {
            if (ch == symbol) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static String calculate() throws IOException {
        String result = "";
        ArrayList<String> members = new ArrayList<>(List.of(getInput()));
        for (int i = 0; i < members.size(); i++) {
            String temp = "";
            if (members.get(i).equals("*")) {
                temp = String.valueOf(Double.parseDouble(members.get(i - 1)) *
                        Double.parseDouble(members.get(i + 1)));
                members.set(i, temp);
                members.remove(i + 1);
                members.remove(i - 1);
                i--;
            }
            else if (members.get(i).equals("/")) {
                if (members.get(i + 1).equals("0")) {
                    temp = "You can't divide by zero";
                    members.clear();
                    members.add(temp);
                    Logger logger = Logger.getLogger(Main.class.getName());
                    //ConsoleHandler ch = new ConsoleHandler();
                    FileHandler fh = new FileHandler("log.xml");
                    //logger.addHandler(ch);
                    logger.addHandler(fh);
                    XMLFormatter xml = new XMLFormatter();
                    fh.setFormatter(xml);
                    logger.log(Level.WARNING, "You can't divide by zero");
                    break;
                    }
                else {
                    temp = String.valueOf(Double.parseDouble(members.get(i - 1)) /
                            Double.parseDouble(members.get(i + 1)));
                    members.set(i, temp);
                    members.remove(i + 1);
                    members.remove(i - 1);
                    i--;
                }
            }
        }
        for (int i = 0; i < members.size(); i++) {
            String temp = "";
            if (members.get(i).equals("+")) {
                temp = String.valueOf(Double.parseDouble(members.get(i - 1)) +
                        Double.parseDouble(members.get(i + 1)));
                members.set(i, temp);
                members.remove(i + 1);
                members.remove(i - 1);
                i--;
            }
            else if (members.get(i).equals("-")) {
                temp = String.valueOf(Double.parseDouble(members.get(i - 1)) -
                        Double.parseDouble(members.get(i + 1)));
                members.set(i, temp);
                members.remove(i + 1);
                members.remove(i - 1);
                i--;
                }
            }

        result = members.get(0);
        return result;
    }
}
