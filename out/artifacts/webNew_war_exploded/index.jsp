<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>填寫關鍵字</title>
  </head>
  <body>
  關鍵字查詢
  <form action="KeywordSearchServlet"  method="post">
    <input type="text" name="keyword" maxlength="15" size="15"/>
    <input type="submit" value="Submit"/>
  </form>
  關鍵字搜尋次數及結果
  <form action="SelectSearchRecordServlet"  method="post">
    <input type="text" name="keyword" maxlength="15" size="15"/>
    <input type="submit" value="Submit"/>
  </form>

  </body>
</html>
