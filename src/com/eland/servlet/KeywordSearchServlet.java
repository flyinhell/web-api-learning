package com.eland.servlet;


import com.eland.jsonCreator.JsonGenerator;
import com.eland.entities.SearchRecordEntity;
import com.eland.factory.DAOFactory;
import com.eland.tools.Log4j;
import com.eland.tools.TdsConnect;
import com.eland.fromJson.Json;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class KeywordSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String keyword;         //關鍵字
        String encodeUserJson;  //Json物件轉碼(UTF-8)
        String para;            //參數，用於傳入TDS站台
        String responseJson;    //從TDS回傳的Json
        int totalCount;         //結果筆數


        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        TdsConnect tdsConnect = new TdsConnect();

        Gson gson = new Gson();
        SearchRecordEntity searchRecord = new SearchRecordEntity();

        Logger logger = Log4j.getInstance().loggerWeb();


        try {
            logger.info("----keyword Search Start----");

            //得到關鍵字
            keyword = request.getParameter("keyword");
            response.setContentType("text/html");
            logger.info("Get keyword");

            //建立Json物件
            JsonGenerator jsonGenerator = new JsonGenerator();
            String userJson = jsonGenerator.jsonGenerator(keyword);
            logger.info("Get String Json");

            //Json物件轉碼
            encodeUserJson = tdsConnect.urlEncode(userJson, "UTF-8");

            //連接到TDS並進行搜尋
            String url = "http://172.17.10.11:6060/web/P2PServer.jsp";
            para = "action=search&txtInput_json=" + encodeUserJson;
            logger.info("TDS Connect");


            //TDS回傳值(Json)
            responseJson = tdsConnect.sendPost(url, para);
            Json json = gson.fromJson(responseJson, Json.class);
          //  totalCount = json.getResponseList().getTotalCount();
           if (json.getResponseList().getTotalCount() == null) {
                totalCount = 0;
            } else {
                totalCount = json.getResponseList().getTotalCount();
            }
            logger.info("TDS回傳值(Json)");

            //將輸入關鍵字與取得查詢筆數存入DB
            searchRecord.setKeyword(keyword);
            searchRecord.setTotalCount(totalCount);
            DAOFactory.getSearchRecordInstance().insertSearchRecord(searchRecord);
            logger.info("關鍵字與取得查詢筆數存入DB");


            // 設定請求屬性
            request.setAttribute("keyword", keyword);
            request.setAttribute("responseJson", responseJson);
            // 轉發至 JSP
            request.getRequestDispatcher("ShowJsonPage.jsp").forward(request, response);

            logger.info("----keyword Search End----");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
