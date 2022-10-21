package gb.seminarTwo;

import java.util.*;
import java.util.logging.Logger;

public class Main {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    //      Пример json: {"firstName": "Ivan", "secondName": "Ivanov", ....}
    // Результат работы методов: "select * from students where firstName = 'Ivan' and ...".

    public static void main(String[] args) {
        Logger log = Logger.getLogger(gb.seminarOne.Main.class.getName());

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

        StringBuilder sb = new StringBuilder("\nselect * from students where");
        Scanner scan = new Scanner(System.in);

        log.info("\nEnter name");
        String temp = scan.nextLine();
        sb.append(" firstName = '").append(temp).append("' and");

        log.info("\nEnter lastname");
        temp = scan.nextLine();
        sb.append(" secondName = '").append(temp).append("'");

        String q = String.valueOf(sb);
        log.info(q);

        scan.close();

        Main task2 = new Main();

        String[] paramName = new String[] {"name", "lastname", "date of birth"};
        String[] paramValue = new String[] {"Ivan", "Ivanov", "11.02.2000",
                                            "Sergey", "Petrov", "25.03.2001",
                                            "Oleg", "Sidor", "18.09.2002",
                                            "Ivan", "Ivanov", "15.05.2001"};
        log.info("\n" + task2.updateQueryByArrays(q, paramName, paramValue));

        String json = "{'name': 'Ivan', 'lastname': 'Ivanov', 'date of birth': '11/02/2000', 'status': 'student', " +
                "'name': 'Sergey', 'lastname': 'Petrov', 'date of birth': '25/03/2001', 'status': 'student', " +
                "'name': 'Oleg', 'lastname': 'Sidor', 'date of birth': '18/09/2002', 'status': 'student', " +
                "'name': 'Ivan', 'lastname': 'Ivanov', 'date of birth': '15/05/2001', 'status': 'student'}";
        log.info("\n" + task2.updateQueryByJson(q, json));
    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        Logger log = Logger.getLogger(gb.seminarOne.Main.class.getName());
        StringBuilder builder = new StringBuilder();

        try {
            String[] student = q.substring(q.indexOf("=") + 2)
                    .replace("and secondName =", "")
                    .replace("'", "")
                    .split(" {2}");

            for (int i = 0; i < paramValue.length; i += 3) {
                if (student[0].equals(paramValue[i]) && student[1].equals(paramValue[i + 1])) {
                    for (int j = 0; j < paramName.length; j++) {
                        builder.append(paramName[j])
                                .append(": ")
                                .append(paramValue[i + j])
                                .append(", ");
                    }
                    builder.deleteCharAt(builder.length() - 2).append("\n");
                }
            }
        } catch (IndexOutOfBoundsException ex) {
                log.info("No data available");
            }
            return String.valueOf(builder);
        }

    public String updateQueryByJson(String q, String json){
        Logger log = Logger.getLogger(gb.seminarOne.Main.class.getName());

        StringBuilder paramName = new StringBuilder();
        StringBuilder paramValue = new StringBuilder();

        try {
            String[] data = json.replaceAll("[{.+}]", "")
                    .split(", ");

            for (String datum : data) {
                String temp = datum.replace("'", "")
                        .split(": ")[0];
                if (!String.valueOf(paramName).contains(temp))
                    paramName.append(temp).append(";");
                paramValue.append(datum.replace("'", "")
                        .split(": ")[1]).append(";");
            }
        } catch (IndexOutOfBoundsException ex) {
            log.info("No data available");
        }

        return updateQueryByArrays(q, String.valueOf(paramName).trim().split(";"),
                String.valueOf(paramValue).trim().split(";"));
    }
}
