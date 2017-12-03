package com.example.biz_41.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.biz_41.Model.retrofit_package.BizGidApi;
import com.example.biz_41.Model.retrofit_package.Company;
import com.example.biz_41.View.AllView;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Karl on 22.08.2017.
 */

public class InfoPresenter implements AllPresenter {
    AllView view;
    Context context;
    private BizGidApi mServise;
    public static final String BASE_URL = "https://bizguid.herokuapp.com/";
    CompositeDisposable mCompositeDisposable;
    String slug;
    Company enterprise;

  public InfoPresenter(AllView view, Context context){
      this.view = view;
      this.context = context;
      //mServise = ApiUtils.getApi();
  }
  public void setSlug(String slug){
      this.slug = slug;
  }


    @Override
    public List<Company> initData() {

        view.showProgressDialog();


            enterprise = new Company();

            BizGidApi bizGidApi = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(BizGidApi.class);


            mCompositeDisposable = new CompositeDisposable();

            mCompositeDisposable.add(bizGidApi.getEnterprise(slug)

                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())

                    .subscribe(response -> handleResponse(response), error -> handleError(error)));



            ArrayList<Company> enterpriseList = new ArrayList<>();
            enterpriseList.add(enterprise);
        return enterpriseList;
    }
    private void handleError(Throwable error) {
        //Toast.makeText(context, "error бля", Toast.LENGTH_SHORT).show();
        Log.d("infoPresenter", "have a bad response handle error");
        initAdapter();


    }
    private void handleResponse(Company response) {


        enterprise = new Company();
        // Toast.makeText(context, "отлично", Toast.LENGTH_SHORT).show();

            Log.d("infoPresenter","RESPONSE! "+ response.getName());
            Log.d("infoPresenter", "RESP MAIL "+ response.getEmails().get(0));
        if(response.getContactPeople().getDirector()!=null){
            Log.d("infoPresenter"," dir: "+response.getContactPeople().getDirector());}

        enterprise.setAll(new Company(response));
        Log.d("infoPresenter","in handleResponse mail"+enterprise.getEmails().get(0));
            if(response.getSkype()!=null){
                Log.d("infoPresenter",response.getSkype());}



        initAdapter();


    }




    @Override
    public void initAdapter() {
        view.hideProgressdialog();
        ArrayList<Company> enterpriseList = new ArrayList<>();
        enterpriseList.add(enterprise);
        Log.d("infoPresenter","in initAdapter mail"+enterprise.getEmails().get(0));
    view.initializeAdapter(enterpriseList);
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
