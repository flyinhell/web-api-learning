package com.eland.factory;

import com.eland.dao.SearchRecordDAO;
import com.eland.dao.SearchRecordDaoImpl;

public  class DAOFactory {
    public static SearchRecordDAO getSearchRecordInstance(){
        return new SearchRecordDaoImpl();
    }
}
