package com.eland.tools;


import org.apache.log4j.Logger;

import static com.eland.main_start.iniPath;

import org.apache.log4j.PropertyConfigurator;
import org.ini4j.Wini;


import java.io.File;


import java.io.IOException;


public class Log4j {
    private static Log4j log4j = new Log4j();



    public Logger loggerDatabase() {
        Logger loggerDatabase = null;
        String log4jPath;
        try {


            loggerDatabase = Logger.getLogger("loggerDatabase");
            Wini ini = new Wini(new File(iniPath));
            log4jPath = ini.get("System", "Log4jPropertyConfig");
            PropertyConfigurator.configure(log4jPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loggerDatabase;

    }

    public Logger loggerWeb() {
        Logger loggerWeb = null;
        String log4jPath;
        try {
            loggerWeb = Logger.getLogger("loggerWeb");
            Wini ini = new Wini(new File(iniPath));
            log4jPath = ini.get("System", "Log4jPropertyConfig");
            PropertyConfigurator.configure(log4jPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loggerWeb;
    }

    public static Log4j getInstance() {
        try {
            if (log4j == null) {
                log4j = new Log4j();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return log4j;
    }

}
