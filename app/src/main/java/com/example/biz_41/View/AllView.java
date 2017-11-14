package com.example.biz_41.View;

import com.example.biz_41.Model.retrofit_package.Company;

import java.util.List;

/**
 * Created by Karl on 22.08.2017.
 */

public interface AllView {
    void initializeAdapter(List<Company> enterpriseList);
    void showProgressDialog();
    void hideProgressdialog();
}
