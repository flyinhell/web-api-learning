package com.eland.servlet;

import com.eland.entities.SearchRecordEntity;

import com.eland.factory.DAOFactory;
import com.eland.tools.Log4j;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SelectSearchRecordServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response){

        String keyword;         //關鍵字
        int keywordSearchNum=0;   //關鍵字被查詢次數
        int resultNum=0;          //結果數量總和

        Logger logger = Log4j.getInstance().loggerWeb(); //Log設定
        SearchRecordEntity searchRecordEntity;
        List searchRecordList;

        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            logger.info("---- SelectSearchRecord Start----");


            //取得關鍵字
            keyword = request.getParameter("keyword");
            response.setContentType("text/html");
            logger.info("get keyword");

            //從DB中取值
            searchRecordList= DAOFactory.getSearchRecordInstance().selectSearchRecord();
            Iterator iterator = searchRecordList.iterator();

            //取得關鍵字搜尋次數及結果筆數總和
            while (iterator.hasNext()) {
                searchRecordEntity = (SearchRecordEntity) iterator.next();
                if (searchRecordEntity.getKeyword().equals(keyword)){
                    keywordSearchNum++;
                    resultNum=resultNum+searchRecordEntity.getTotalCount();
                }
            }
            logger.info("Get KeywordSearchNum & Get ResultNum");


            //將keyword、keywordSearchNum、resultNum存入model中
            Map<String, Object> model = new HashMap<>();
            model.put("keyword", keyword);
            model.put("keywordSearchNum", keywordSearchNum);
            model.put("resultNum", resultNum);
            logger.info("將keyword、keywordSearchNum、resultNum存入model中");


            request.setAttribute("model", model);
            request.getRequestDispatcher("SelectSearchRecordPage.jsp").forward(request, response);

            logger.info("---- SelectSearchRecord End----");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

        }
    }
}
