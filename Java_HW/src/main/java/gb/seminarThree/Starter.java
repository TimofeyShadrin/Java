package gb.seminarThree;

import java.util.*;
import java.util.logging.Logger;

public class Starter {
    public static void main(String[] args) {

        Starter starter = new Starter();
        Logger log = Logger.getLogger(Starter.class.getName());

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

        List<Integer> numbers = new Random()
                .ints(-10, 10)
                .limit(5)
                .boxed()
                .toList();

        String[] content = new String[]
                {
                        "\nMy resulting list: ",
                        "\nOdd and positive numbers: ",
                        "\nMinimum value: ",
                        "\nMaximum value: ",
                        "\nAverage value: "
                };
        Object[] result = new Object[]
                {
                        numbers,
                        starter.removeNegativeValue(numbers),
                        starter.getMin(numbers),
                        starter.getMax(numbers),
                        starter.getAverage(numbers)
                };

        StringBuilder info = new StringBuilder();

        for (int i = 0; i < content.length; i++) {
            info.append(content[i]);
            info.append(result[i]);
        }

        log.info(String.valueOf(info));
    }

    // Нужно удалить из него четные числа
    public List<Integer> removeNegativeValue(List<Integer> list) {
        ArrayList<Integer> integers = new ArrayList<>();

        for (int temp : list) {
            if (temp % 2 != 0 && temp > 0)
                integers.add(temp);
        }

        return integers;
    }

    // Найти минимальное значение
    public Integer getMin(List<Integer> list) {
        int result;
        if (!list.isEmpty()) {
            result = Collections.min(list);
        } else {
            result = 0;
        }
        return result;

    }

    // Найти максимальное значение
    public Integer getMax(List<Integer> list) {
        int result;
        if (!list.isEmpty()) {
            result = Collections.max(list);
        } else {
            result = 0;
        }
        return result;

    }

    // Найти среднее значение
    public Integer getAverage(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        int result = 0;

        try {
            while (iterator.hasNext()) {
                result += iterator.next();
            }
            result = result / list.size();

        } catch (ArithmeticException ex) {
            result = 0;
        }
        return result;
    }
}
