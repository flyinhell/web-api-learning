package com.eland;



import org.apache.log4j.Logger;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;


public class main_start {


    public final static String iniPath = "C:\\Users\\zhenfuliao\\IdeaProjects\\webNew\\opview.ini";
    private static Logger log = Logger.getLogger("Log");

    public static void main(String[] args) throws IOException {
    Wini ini = new Wini(new File(iniPath));
    String str =ini.get("DB","USER");
        System.out.println(str);


        log.info("just try!");

    }
}



