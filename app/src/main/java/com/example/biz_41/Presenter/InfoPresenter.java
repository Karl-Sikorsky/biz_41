package com.example.biz_41.Presenter;

import android.content.Context;

import com.example.biz_41.Model.retrofit_package.BizGidApi;
import com.example.biz_41.Model.retrofit_package.Company;
import com.example.biz_41.View.AllView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karl on 22.08.2017.
 */

public class InfoPresenter implements AllPresenter {
    AllView view;
    Context context;
    private BizGidApi mServise;

    String slug;

  public InfoPresenter(AllView view, Context context){
      this.view = view;
      this.context = context;
      //mServise = ApiUtils.getApi();
  }

    @Override
    public List<Company> initData() {
        return null;
    }



    @Override
    public void initAdapter() {
    view.initializeAdapter(new ArrayList<>());
    }

    @Override
    public boolean isCashEnabled() {
        return false;
    }

    @Override
    public void setCashEnabled(boolean enabled) {

    }

    @Override
    public int getOffset() {
        return 0;
    }

    @Override
    public void setOffset(int offset) {

    }

    @Override
    public int getAserts() {
        return 0;
    }

    @Override
    public void setAserts(int aserts) {

    }

    @Override
    public void setQueryParams(String categoryIds, String regionIds) {

    }

    @Override
    public void setSearchParam(String text_search) {

    }

    /*@Override
    public List<Enterprise> createDatafromDB() {
        return null;
    }

    @Override
    public void saveToDB(List<Enterprise> list) {

    }*/
}
