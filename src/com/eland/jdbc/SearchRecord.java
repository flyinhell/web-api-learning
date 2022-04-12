package com.eland.jdbc;

import com.eland.tools.Log4j;
import org.apache.log4j.Logger;
import org.ini4j.Wini;

import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.eland.main_start.iniPath;


public class SearchRecord {


    /**
     * 將搜尋關鍵字、搜尋數量、查詢時間 insert testdb.dbo.search_record
     *
     * @param keyword    關鍵字
     * @param totalCount 搜尋數量
     * @conn DB連線
     * @conn DB連接資訊
     */
    public void insertSearchRecord(Connection conn, String keyword, int totalCount) {
        String sql;
        SimpleDateFormat dateFormatter;
        String formatDate;
        PreparedStatement preparedStatement = null;

        Logger logger = Log4j.getInstance().loggerDatabase();
        try {
            //系統時間
            Date newTime = new Date();
            dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            formatDate = dateFormatter.format(newTime);

            //SQL語法
            Wini ini = new Wini(new File(iniPath));
            sql = ini.get("Sql", "InsertSearchRecord");
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, keyword);
            preparedStatement.setInt(2, totalCount);
            preparedStatement.setString(3, formatDate);
            preparedStatement.executeUpdate();


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    /**
     * 查詢某一關鍵字被查詢次數
     *
     * @param keyword
     * @return
     * @conn DB連接資訊
     */
    public int selectKeywordSearchNum(Connection conn, String keyword) {
        String sql;
        PreparedStatement preparedStatement = null;
        int keywordSearchNum = 0;
        Logger logger = Log4j.getInstance().loggerDatabase();

        try {
            Wini ini = new Wini(new File(iniPath));
            sql = ini.get("Sql", "SelectSearchRecordKsn");


            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, keyword);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            keywordSearchNum=  resultSet.getInt("keyword_search_num");


        } catch (Exception e) {
            logger.error(e.getMessage(), e);

        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return keywordSearchNum;
    }

    /**
     * 回傳此關鍵字 結果筆數總和
     *
     * @param keyword
     * @return
     * @conn DB連接資訊
     */
    public int selectResultNum(Connection conn, String keyword) {
        String sql;


        PreparedStatement preparedStatement = null;
        int resultNum = 0;

        Logger logger = Log4j.getInstance().loggerDatabase();
        try {


            Wini ini = new Wini(new File(iniPath));
            sql = ini.get("Sql", "SelectSearchRecordSrn");


            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, keyword);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            resultNum =  resultSet.getInt("result_num");


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return resultNum;
    }
}
