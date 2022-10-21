package gb.seminarThree;

import org.jetbrains.annotations.NotNull;

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
                .limit(10).boxed()
                .toList();

        String[] content = new String[]
                {
                        "\nThe resulting list: ",
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
        return Collections.min(list);

    }

    // Найти максимальное значение
    public Integer getMax(List<Integer> list) {
        return Collections.max(list);

    }

    // Найти среднее значение
    public Integer getAverage(@NotNull List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        int result = 0;

        if (list.isEmpty() || list.size() == 1) throw new RuntimeException("Your list is empty!");
        else {
            while (iterator.hasNext()) {
                result += iterator.next();
            }
        }
        return result / list.size();
    }
}
