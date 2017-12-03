package com.example.biz_41.View;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.example.biz_41.Model.retrofit_package.Company;
import com.example.biz_41.Presenter.AllPresenter;
import com.example.biz_41.Presenter.MainPresenter;
import com.example.biz_41.Presenter.RVAdapter;
import com.example.biz_41.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AllView, SettingsFragment.SettingDialogListener{
    private List<Company> enterpriseList;
    private RecyclerView rv;
    private TextView textSelected;
    ProgressDialog pd;
    private AllPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        rv=(RecyclerView)findViewById(R.id.rv);

        textSelected = (TextView)findViewById(R.id.selectedView);

        presenter = new MainPresenter(this, getApplicationContext());

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setReverseLayout(true);
        llm.setStackFromEnd(true);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        int resId = R.anim.layout_fall_down_anim;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, resId);
        rv.setLayoutAnimation(animation);
Log.d("intentcatcher", "catch intent oncreate");

        enterpriseList = new ArrayList<Company>();

       try{
           Intent intent = getIntent();
           try{

           String text_search = intent.getStringExtra("text");
               Log.d("searchlog","in main catch text = "+ text_search + " ; send to presenter");
               if (!((text_search==null)||text_search.trim().equals("")||(text_search.equals(" ")))){
               presenter.setSearchParam(text_search);
               textSelected.setText(text_search);
               Log.d("searchlog","catch status bar must bee as "+text_search);}
           }catch (Exception ignored){};
           String categoryIds = intent.getStringExtra("categoryIds");
           String regionIds = intent.getStringExtra("regionIds");
           String categoryNames = intent.getStringExtra("categoryNames");
           String regionNames = intent.getStringExtra("regionNames");
           if((categoryNames!=null)&&(regionNames!=null)){
           textSelected.setText(categoryNames+"; "+regionNames);}
           Log.d("querycontrol", "send query with = "+ categoryIds + " and "+ regionIds);
           presenter.setQueryParams(categoryIds,regionIds);

       }catch (Exception ignored){};
        presenter.initData();


        //initializeAdapter();


    }

    @Override
    protected void onStart() {
        Log.d("intentcatcher", "catch intent onStart");
        super.onStart();
    }

    public void showProgressDialog() {
        pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();

    }

    @Override
    protected void onResume() {
        Log.d("intentcatcher", "catch intent onresume");
        super.onResume();
    }

    @Override
    public void hideProgressdialog() {
        pd.dismiss();
    }

    public void initializeAdapter(List<Company> enterpriseList){

        this.enterpriseList = enterpriseList;
        Log.d("timertask", "now(initialAdapter in view) size is "+ enterpriseList.size());

        for(int i = 0; i< this.enterpriseList.size(); i++){
            Log.d("onAdapter", "before constructor list is "+ this.enterpriseList.get(i).getName()+ this.enterpriseList.get(i).getProductsAndOffers());
        }
        RVAdapter adapter = new RVAdapter(getApplicationContext(), this.enterpriseList, (v, position) -> {

             //Toast.makeText(getApplicationContext(), "name is "+ this.enterpriseList.get(position).getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
            Log.d("INTENTLOG", "intent start1");
            Log.d("INTENTLOG", this.enterpriseList.get(position).getName());
            try {
                if(this.enterpriseList.get(position).getName()!=null){
                intent.putExtra("company_slug", this.enterpriseList.get(position).getSlug());}
            }catch (Exception ignored){};
            /*try {
                String mail = this.enterpriseList.get(position).getEmails().get(0);
                if(mail!=null){
                intent.putExtra("company_mail", mail );}
            }catch (Exception ignored){};
            try {
                if(this.enterpriseList.get(position).getRegionName()!=null){
                intent.putExtra("company_reg", this.enterpriseList.get(position).getRegionName());}
            }catch (Exception ignored){};
            try {if(this.enterpriseList.get(position).getPhones()!=null){
                intent.putExtra("company_phone", this.enterpriseList.get(position).getPhones());}
            }catch (Exception ignored){};
            try {if(this.enterpriseList.get(position).getProductsAndOffers()!=null){
                intent.putExtra("company_products", this.enterpriseList.get(position).getProductsAndOffers());}
            }catch (Exception ignored){};
            try {if(this.enterpriseList.get(position).getDescription()!=null){
                intent.putExtra("company_description", this.enterpriseList.get(position).getDescription());}
            }catch (Exception ignored){};
            try {if(this.enterpriseList.get(position).getContactPeople().getDirector()!=null){
                intent.putExtra("company_director", this.enterpriseList.get(position).getContactPeople().getDirector());}
            }catch (Exception ignored){};
            try {if(this.enterpriseList.get(position).getContactPeople().getManager()!=null){
                intent.putExtra("company_manager", this.enterpriseList.get(position).getContactPeople().getManager());}
            }catch (Exception ignored){};
            try {if(this.enterpriseList.get(position).getSkype()!=null){
                intent.putExtra("company_skype", this.enterpriseList.get(position).getSkype());}
            }catch (Exception ignored){};
            try {if(this.enterpriseList.get(position).getYearOfFoundation()!=null){
                intent.putExtra("company_year", this.enterpriseList.get(position).getYearOfFoundation());}
            }catch (Exception ignored){};
            try {if(this.enterpriseList.get(position).getSitesUrl()!=null){
                intent.putExtra("company_sitesUrl", this.enterpriseList.get(position).getSitesUrl());}
            }catch (Exception ignored){};*/
Log.d("INTENTLOG", "intent start2");
            startActivity(intent);
        });
        rv.setAdapter(adapter);
        runLayoutAnimation(rv);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.bgmenu));
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
            break;
            case R.id.action_settings:
                android.app.FragmentManager fm = getFragmentManager();


                SettingsFragment dialog =  SettingsFragment.newInstance(presenter.isCashEnabled(),presenter.getAserts());
                Log.d("ONSETTINGS",String.valueOf(presenter.getAserts()));
                dialog.show(fm,"empty tag");
                break;
        }
        return true;
    }






    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_fall_down_anim);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    @Override
    public void onFinishDialog(Boolean isCashEnabled, int asserts) {
        Log.d("ONSETTINGS",String.valueOf(asserts));
        presenter.setAserts(asserts);
        presenter.setOffset(0);
        presenter.setCashEnabled(isCashEnabled);

    enterpriseList = presenter.initData();

    }

    public void showMore(View view) {
        presenter.setOffset(presenter.getOffset()+presenter.getAserts());
        Log.d("LOGOFFSET",String.valueOf(presenter.getOffset())+" "+String.valueOf(presenter.getAserts()));

        enterpriseList.addAll(presenter.initData());

    }

    private void hideProgressDialog() {
        pd.hide();
    }
}
