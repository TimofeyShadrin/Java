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
        String[] paramName = new String[] {"name", "lastname", "date of birth"};
        String[] paramValue = new String[] {"Ivan", "Ivanov", "11.02.2000",
                                            "Sergey", "Petrov", "25.03.2001",
                                            "Oleg", "Sidor", "18.09.2002",
                                            "Ivan", "Ivanov", "15.05.2001"};
        log.info("\n" + updateQueryByArrays(q, paramName, paramValue));
        String json = "{'name': 'Ivan', 'lastname': 'Ivanov', 'date of birth': '11/02/2000', " +
                "'name': 'Sergey', 'lastname': 'Petrov', 'date of birth': '25/03/2001', " +
                "'name': 'Oleg', 'lastname': 'Sidor', 'date of birth': '18/09/2002', " +
                "'name': 'Ivan', 'lastname': 'Ivanov', 'date of birth': '15/05/2001'}";
        log.info("\n" + updateQueryByJson(q, json));
    }

    public static String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        String[] student = q.substring(q.indexOf("=") + 2)
                .replace("and secondName =", "")
                .replace("'", "")
                .split(" {2}");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < paramValue.length; i+=3) {
            if (student[0].equals(paramValue[i]) && student[1].equals(paramValue[i + 1])){
                builder.append(paramName[0])
                        .append(": ")
                        .append(paramValue[i])
                        .append(", ")
                        .append(paramName[1])
                        .append(": ")
                        .append(paramValue[i + 1])
                        .append(", ")
                        .append(paramName[2])
                        .append(": ")
                        .append(paramValue[i + 2])
                        .append("\n");
            }
        }
        return String.valueOf(builder);
    }

    public static String updateQueryByJson(String q, String json){
        String[] data = json.replaceAll("[{.+}]", "")
                .split(", ");
        StringBuilder paramName = new StringBuilder();
        StringBuilder paramValue = new StringBuilder();
        for (String datum : data) {
            String temp = datum.replace("'", "")
                    .split(": ")[0];
            if (!String.valueOf(paramName).equals(temp))
                paramName.append(temp).append(";");
            paramValue.append(datum.replace("'", "")
                    .split(": ")[1]).append(";");
        }
        return updateQueryByArrays(q, String.valueOf(paramName).trim().split(";"),
                String.valueOf(paramValue).trim().split(";"));
    }
}
