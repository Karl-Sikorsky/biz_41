package com.example.biz_41.Presenter;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;

import com.example.biz_41.Model.retrofit_package.BizGidApi;
import com.example.biz_41.Model.retrofit_package.Company;
import com.example.biz_41.View.AllView;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ПОДАРУНКОВИЙ on 22.08.2017.
 */

public class MainPresenter implements AllPresenter {
    AllView view;
    Context context;
    private List<Company> enterpriseList;
    private BizGidApi mServise;
    public static final String BASE_URL = "https://bizguid.herokuapp.com/";
    int offset; int aserts;
    String categoryIds,regionIds, searchText;
    boolean cashEnabled;
    boolean cashneeded;
    boolean searchEnabled;
    boolean searchTextNeeded;
    CompositeDisposable mCompositeDisposable;
    MyCountDownTimer myCountDownTimer;

    public MainPresenter(AllView view, Context context) {
        Realm db = Realm.getDefaultInstance();
        this.view = view;
        this.context = context;
        this.offset = 0;
        this.aserts = 5;
        this.categoryIds = "";
        this.regionIds = "";
        this.cashEnabled=false;
        this.cashneeded=true;
        this.searchEnabled=false;
        this.searchText="";
        this.searchTextNeeded=false;

        Log.d("ONSETTINGS", "call constr");
       //mServise = ApiUtils.getApi();
    }

    public boolean isCashEnabled() {
        return cashEnabled;
    }

    public void setCashEnabled(boolean cashEnabled) {
        this.cashEnabled = cashEnabled;
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("base.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getAserts() {
        return aserts;
    }

    public void setAserts(int aserts) {
        this.aserts = aserts;
    }

    @Override
    public void setQueryParams(String categoryIds, String regionIds) {
        this.categoryIds = categoryIds;
        this.regionIds = regionIds;
        Log.d("querycontrol", "parameters setted");
    }

    @Override
    public void setSearchParam(String text_search) {
        this.searchText = text_search;
        this.searchTextNeeded=true;
        Log.d("searchlog","in presenter setted text = "+ this.searchText + " ; send to retrofit");
    }

    @Override
    public List<Company> initData() {
       /* Log.d("LOG_JSON",loadJSONFromAsset());


        try {
            JSONArray allCompanies = new JSONArray(loadJSONFromAsset());

            enterpriseList = new ArrayList<Enterprise>();
            Enterprise m_li;

            //for (int i = 0; i < allCompanies.length(); i++) {
                for (int i = 0; i < 300; i++) {
                JSONObject jo_inside = allCompanies.getJSONObject(i);
                    Log.d("LOG_JSON","start for "+ allCompanies.getJSONObject(i).getString("name"));
                try {

                    String ent_name = jo_inside.getString("name");
                    Log.d("LOG_JSON","name ok");
                    String ent_mail = jo_inside.getString("slug");
                    Log.d("LOG_JSON","slug ok");
                    String ent_telephone = jo_inside.getString("phones");
                    Log.d("LOG_JSON","tel ok");
                    String ent_reg = jo_inside.getString("regionName");
                    Log.d("LOG_JSON","region ok");
                    String ent_slug = jo_inside.getJSONArray("emails").get(0).toString();
                    Log.d("LOG_JSON","mail ok");


                    //Add your values in your `ArrayList` as below:
                    m_li = new Enterprise(ent_name,ent_slug,ent_telephone,ent_reg,ent_mail,"none");

                    Log.d("LOG_JSON","sucsess for "+ ent_name);
                    enterpriseList.add(m_li);
                }catch (Exception e){}
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

*/
        view.showProgressDialog();
        myCountDownTimer = new MyCountDownTimer(25000, 1000);

        myCountDownTimer.start();
        Log.d("timertask", "timer start");
        if (!searchTextNeeded) {

            try {
                Log.d("timertask", "now(starttimer) size is " + enterpriseList.size());
            } catch (Exception e) {
            }
            enterpriseList = new ArrayList<>();
            Log.d("querycontrol", "have query with = " + categoryIds + " and " + regionIds);
            BizGidApi bizGidApi = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(BizGidApi.class);


            mCompositeDisposable = new CompositeDisposable();

            mCompositeDisposable.add(bizGidApi.getData(categoryIds, regionIds, offset, aserts)

                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())

                    .subscribe(response -> handleResponse(response), error -> handleError(error)));

        } else {
            Log.d("searchlog","in presenter search text needed");
            try {
                Log.d("timertask", "now(starttimer) size is " + enterpriseList.size());
            } catch (Exception e) {
            }
            enterpriseList = new ArrayList<>();

            BizGidApi bizGidApi = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(BizGidApi.class);


            mCompositeDisposable = new CompositeDisposable();

            mCompositeDisposable.add(bizGidApi.getDataByText(searchText, offset, aserts)

                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())

                    .subscribe(response -> handleResponse(response), error -> handleError(error)));
            Log.d("searchlog","in presenter subscribe is ok");

        }

        /*
        Log.d("realmLOG", "start");
        mServise.getData().enqueue(new Callback<List<EnterpriseObject>>() {
            @Override
            public void onResponse(Call<List<EnterpriseObject>> call, Response<List<EnterpriseObject>> response) {

                if (response.isSuccessful()) {
                    Log.d("realmLOG", "response sucsess");
                    for (int i = 0; i < response.body().size(); i++) {
                        Log.d("MainActivity", response.body().get(i).getName() + response.body().get(i).getId());
                        enterpriseList.add(new Enterprise(response.body().get(i).getName(), response.body().get(i).getId(), response.body().get(i).getPhones().get(0), response.body().get(i).getRegionName(), response.body().get(i).getSlug(), response.body().get(i).getSlug()));
                    }
                    for (int i = 0; i < enterpriseList.size(); i++) {
                        Log.d("onAdapter", "wtf after we parse list he is " + enterpriseList.get(i).getDescription());
                    }
                    Log.d("onAdapter", "creating list size is: " + enterpriseList.size());
                    Log.d("MainActivity", "posts loaded from API");
                    saveToDB(enterpriseList);

                    initAdapter();
                } else {
                    int statusCode = response.code();
                    Log.d("realmLOG", "response not ok");
                    enterpriseList = new ArrayList<Enterprise>(createDatafromDB());
                    Log.d("realmLOG", "data created");
                    initAdapter();
                }
            }

            @Override
            public void onFailure(Call<List<EnterpriseObject>> call, Throwable t) {
                Log.d("MainActivity", call.toString());
                Log.d("MainActivity", "error loading from API");
                Log.d("MainActivity", t.toString());
                Log.d("MainActivity", mServise.getData().toString());
                Log.d("realmLOG", "failure");
                enterpriseList = new ArrayList<Enterprise>(createDatafromDB());
                Log.d("realmLOG", "but data created");
                for (int i = 0; i < enterpriseList.size(); i++) {
                    Log.d("realmLOG", enterpriseList.get(i).getName());
                }
                initAdapter();
            }
        });
               */
        return enterpriseList;
    }

    private void handleError(Throwable error) {
        //Toast.makeText(context, "error бля", Toast.LENGTH_SHORT).show();
       enterpriseList = createDatafromDB();
        initAdapter();
        Log.d("response", "have a bad response handle error");
        try{
        Log.d("timertask", "now(handleerror) size is "+ enterpriseList.size());
    }catch (Exception e){}
    }

    private void handleResponse(List<Company> response) {
        enterpriseList.clear();
        try{
        Log.d("timertask", "now(handleresponse) size is "+ enterpriseList.size());
        }catch (Exception e){}
        cashneeded=false;
       // Toast.makeText(context, "отлично", Toast.LENGTH_SHORT).show();
        for(int i =0;i<response.size();i++){
            Log.d("RXTAG",response.get(i).getName());
            enterpriseList.add(new Company(response.get(i)));
            if(response.get(i).getSkype()!=null){
            Log.d("RXTAG",response.get(i).getSkype());}
        }
        try{
        Log.d("timertask", "now(before saveToBD) size is "+ enterpriseList.size());
    }catch (Exception e){}
        saveToDB(enterpriseList);
        Log.d("timertask", "now(after saveToBD) size is "+ enterpriseList.size());
        try{
        Log.d("timertask", "now(after saveToBD) size is "+ enterpriseList.size());
        }catch (Exception e){}
        initAdapter();


    }



    @Override
    public void initAdapter() {
        view.hideProgressdialog();
        try{
        Log.d("timertask", "now(hideprogrdialog in initAdapter) size is "+ enterpriseList.size());
    }catch (Exception e){}
        view.initializeAdapter(enterpriseList);

    }


    public List<Company> createDatafromDB() {
        List<Company> enterprisesfromDB = new ArrayList<>();

        Realm myRealm =  Realm.getDefaultInstance();
        myRealm.beginTransaction();
        RealmResults<Company> results1 =
                myRealm.where(Company.class).findAll();
        for(Company i : results1){
            enterprisesfromDB.add(new Company(i));
            Log.d("realmLOG",i.getName());
        }
        myRealm.commitTransaction();
        myRealm.close();
        return enterprisesfromDB;

    }


    public void saveToDB(List<Company> list) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                // This will create a new object in Realm or throw an exception if the
                // object already exists (same primary key)
                // realm.copyToRealm(obj);

                // This will update an existing object with the same primary key
                // or create a new object if an object with no primary key = 42
                /*RealmResults<Company> results1 =
                        realm.where(Company.class).findAll();
                if(results1.size()>30){
                    for(int i=0;i<list.size();i++){
                        results1.get(i).setAll(list.get(i));
                    }
                }*/
                RealmResults<Company> realmRes = realm.where(Company.class).findAll();
                if (realmRes.size()>50){
                    for(int i=0;i<10;i++) {
                        realmRes.deleteFirstFromRealm();
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    realm.copyToRealmOrUpdate(list.get(i));
                }
            }
        });

        realm.close();
    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            int progress = (int) (millisUntilFinished/1000);
            Log.d("timertask", "op "+progress);

        }

        @Override
        public void onFinish() {
Log.d("TIMERTASK", "timer fifnish");
            if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed() && cashneeded) {
                mCompositeDisposable.dispose();
                enterpriseList = createDatafromDB();
                Log.d("timertask", "adapter called");
                initAdapter();
            }

        }
    }
}
