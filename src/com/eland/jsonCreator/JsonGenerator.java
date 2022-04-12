package com.eland.jsonCreator;

import com.eland.tools.Log4j;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.eland.main_start.iniPath;


public class JsonGenerator {


    /**
     * 透過ini去產生json
     *
     * @param keyword 關鍵字
     * @return 回傳一個Json 字串
     */
    public String jsonGenerator(String keyword) {
        Logger logger = Log4j.getInstance().loggerWeb();
        Json json = new Json();
        Gson gson = new Gson();
        FieldFilter fieldFilter = new FieldFilter();
        FieldFilterSituation fieldFilterSituationType = new FieldFilterSituation();
        FieldFilterSituation fieldFilterSituationPostTime = new FieldFilterSituation();
        List<FieldFilterSituation> fieldFilterSituationList;
        List<String> targetDatabaseList;
        Category category = new Category();
        List<String> categoryList;
        Sort sort = new Sort();
        SearchRange searchRange = new SearchRange();
        SearchOrder searchOrder = new SearchOrder();
        List<SearchOrder> searchOrderList;
        List<String> resultFieldList;

        String userJson = null;
        try {
            Wini ini = new Wini(new File(iniPath));

            //查詢類型
            json.setQueryType("keyword");
            json.setKeyword(keyword);

            //FieldFilter
            fieldFilterSituationType.setField("$p_type_2$");
            fieldFilterSituationType.setCondition(ini.get("Json", "FieldFilterTypeCondition"));
            fieldFilterSituationPostTime.setField("post_time");
            fieldFilterSituationPostTime.setCondition(ini.get("Json", "FieldFilterPostTime"));
            fieldFilterSituationList = Arrays.asList(fieldFilterSituationType, fieldFilterSituationPostTime);
            fieldFilter.setAnd(fieldFilterSituationList);
            json.setFieldFilter(fieldFilter);

            //target_db
            targetDatabaseList = Arrays.asList(ini.get("Json", "TargetDb").split(","));
            json.setTargetDb(targetDatabaseList);

            //Category
            categoryList = Arrays.asList("/UDB");
            category.setAnd(categoryList);
            sort.setOrderType(ini.get("Json", "OrderType"));
            category.setSort(sort);
            category.setDepth(Integer.parseInt(ini.get("Json", "Depth")));
            json.setCategory(category);


            //SearchRange
            searchRange.setStartPos(Integer.parseInt(ini.get("Json", "StartPos")));
            searchRange.setMaxRecord(Integer.parseInt(ini.get("Json", "MaxRecord")));
            json.setSearchRange(searchRange);


            //SearchOrder
            searchOrder.setField("post_time");
            searchOrder.setOrderType("des");
            searchOrderList = Arrays.asList(searchOrder);
            json.setSearchOrder(searchOrderList);

            //resultFieldList
            resultFieldList = Arrays.asList(ini.get("Json", "FieldList").split(","));
            json.setResultField(resultFieldList);

            userJson = gson.toJson(json);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return userJson;
    }

}
