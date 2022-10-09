package org.example;

import java.util.ArrayList;
import java.io.*;

public class Read {

    private final ArrayList<String> incoming = new ArrayList<>();
    private final String path;

    public Read(String path)
    {
        this.path = path;
    }

    public ArrayList<String> read()
    {
        try(BufferedReader br = new BufferedReader(new FileReader(this.path)))
        {
            //чтение построчно
            String temp;
            while((temp=br.readLine())!=null){
                incoming.add(temp);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return incoming;
    }
}
