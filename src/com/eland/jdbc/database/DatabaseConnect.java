package com.eland.jdbc.database;

import com.eland.tools.Log4j;
import org.apache.log4j.Logger;

import static com.eland.main_start.iniPath;

import org.ini4j.Wini;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnect {

    private static DatabaseConnect connectionFactory = new DatabaseConnect();

    public Connection connect() {
        Logger logger = Log4j.getInstance().loggerDatabase();
        String jdbcDriver;
        String dbUrl;
        String user;
        String password;
        Connection conn = null;

        try {
            Wini ini = new Wini(new File(iniPath));

            jdbcDriver = ini.get("DB", "JDBC_DRIVER");
            dbUrl = ini.get("DB", "DB_URL");
            user = ini.get("DB", "USER");
            password = ini.get("DB", "PASS");
            Class.forName(jdbcDriver);

            // System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(dbUrl, user, password);
            // System.out.println("Connected database successfully...");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

        }
        return conn;
    }

    public DatabaseConnect() {
        Logger logger = Log4j.getInstance().loggerDatabase();
        String jdbcDriver;
        try {
            Wini ini = new Wini(new File(iniPath));
            jdbcDriver = ini.get("DB", "JDBC_DRIVER");
            Class.forName(jdbcDriver);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static DatabaseConnect getInstance() {
        Logger logger = Log4j.getInstance().loggerDatabase();
        try {
            if (connectionFactory == null) {
                connectionFactory = new DatabaseConnect();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return connectionFactory;

    }


}
