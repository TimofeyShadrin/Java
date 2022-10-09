package org.example;

import java.io.FileWriter;
import java.io.IOException;
public class Files {

    private final String name;

    public Files(String name){
        this.name = name;
    }

    public void write(String line)
    {
        try(FileWriter fw = new FileWriter(name, false))
        {
            fw.write(line);
            fw.append('\n');
            fw.flush();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
