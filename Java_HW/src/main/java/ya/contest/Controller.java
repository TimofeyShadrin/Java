package ya.contest;

import java.util.logging.Logger;

public class Controller {

    private final Logger log = Logger.getLogger(Controller.class.getName());

    public void controller() {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

        EvenOdd evenOdd = new EvenOdd();
        evenOdd.setAnInt();
        log.info(evenOdd.printMatrix());
    }
}
