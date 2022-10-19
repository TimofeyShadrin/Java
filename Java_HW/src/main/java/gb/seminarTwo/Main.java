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
        StringBuilder sb = new StringBuilder("select * from students where");
        Scanner scan = new Scanner(System.in);
        log.info("Enter name");
        String temp = scan.nextLine();
        sb.append(" firstName = '").append(temp).append("' and");
        log.info("Enter name");
        temp = scan.nextLine();
        sb.append(" secondName = '").append(temp).append("'");
        String q = String.valueOf(sb);
        log.info(q);
        scan.close();
        String[] paramName = new String[] {"name", "lastname", "date of birth"};
        String[] paramValue = new String[] {"Ivan", "Ivanov", "11.02.2000",
                                            "Sergey", "Petrov", "25.03.2001",
                                            "Oleg", "Sidorov", "18.09.2002",
                                            "Ivan", "Ivanov", "15.05.2001"};

        System.out.print(updateQueryByArrays(q, paramName,paramValue));
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

    public String updateQueryByJson(String q, String json){

        return "";
    }
}
