package com.example.biz_41.Presenter;


import com.example.biz_41.Model.retrofit_package.Company;

import java.util.List;

/**
 * Created by Karl on 22.08.2017.
 */

public interface AllPresenter {
    List<Company> initData();

    void initAdapter();
     boolean isCashEnabled();
     void setCashEnabled(boolean enabled) ;
    int getOffset();
    void setOffset(int offset);
    int getAserts();
    void setAserts(int aserts);
    void setSlug(String slug);

    void setQueryParams(String categoryIds, String regionIds);

    void setSearchParam(String text_search);


    //List<Enterprise> createDatafromDB();
    //void saveToDB(List<Enterprise> list);
}
