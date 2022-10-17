package gb.seminarOne;

//Дано четное число N (>0) и символы c1 и c2.
//Написать метод, который вернет строку длины N,
//которая состоит из чередующихся символов c1 и c2, начиная с c1.

// Напишите метод, который определит тип (расширение)
// файлов из текущей папки и выведет в консоль результат вида
// 1 Расширение файла: txt
// 2 Расширение файла: pdf
// 3 Расширение файла:
// 4 Расширение файла: jpg

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        String initStr = "aaabaaa";
        Logger logger = Logger.getAnonymousLogger();
        logger.info(String.valueOf(task3Func(initStr)));
    }
    public static boolean task3Func(String initStr){
        boolean isPalen = true;
        for (int i = 0; i < initStr.length() / 2; i++) {
            if (initStr.charAt(i) != initStr.charAt(initStr.length()- 1 - i)){
                isPalen = false; break;
            }
        }
        return isPalen; }

    //StringBuilder builder = new StringBuilder(text.replaceAll("[^a-zA-ZА-я]", ""));
    //return builder.toString().equalsIgnoreCase(builder.reverse().toString());

}


