package gb.seminarOne;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String pathProject = System.getProperty("home/timofei");
        String pathDir = pathProject.concat("/files");
        File dir = new File(pathDir);
        System.out.println(dir.getAbsolutePath());
        if (dir.mkdir()) {
            System.out.println("+");
        }
        else {
            System.out.println("-");
        }
        for (String fname: dir.list()) {
            System.out.println(fname);
        }
    }
}
