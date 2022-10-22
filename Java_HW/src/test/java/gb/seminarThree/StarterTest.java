package gb.seminarThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StarterTest {

    private final Starter starter = new Starter();
    private final List<Integer> expectedList = new ArrayList<>(Arrays.asList(-2, -1, 0, 1, 2, 30));

    @Test
    void removeNegativeValueSuccessful() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);

        ArrayList<Integer> actualList = new ArrayList<>(starter.removeNegativeValue(expectedList));

        Assertions.assertEquals(expected, actualList);
    }

    @Test
    void getMinSuccessful() {
        int expected = -2;

        int actual = starter.getMin(expectedList);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getMaxSuccessful() {
        int expected = 30;

        int actual = starter.getMax(expectedList);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAverageSuccessful() {
        int expected = 5;

        int actual = starter.getAverage(expectedList);

        Assertions.assertEquals(expected, actual);
    }
}
