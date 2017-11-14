package com.example.biz_41.View;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.biz_41.Model.retrofit_package.Company;
import com.example.biz_41.Presenter.AllPresenter;
import com.example.biz_41.Presenter.InfoPresenter;
import com.example.biz_41.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import ua.privatbank.paylibliqpay.CheckoutActivity;
import ua.privatbank.paylibliqpay.ErrorCode;
import ua.privatbank.paylibliqpay.LiqPay;
import ua.privatbank.paylibliqpay.LiqPayCallBack;

public class InfoActivity extends AppCompatActivity implements AllView {

    private RecyclerView rv;
    private final int ALL_FRAGMENT = 456, FRAGMENT_PRODUCT = 228;


    String enterpriseName;
    TextView ent_name, ent_mail, ent_reg, ent_phone, ent_products;

    Company currentCompany;
    int currentProduct;


    private AllPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("INTENTLOG", "intent catch");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_info);
        getSupportActionBar().hide();

        currentCompany = new Company();
        Intent intent = getIntent();
        Log.d("INTENTLOG", "intent still ok before");
        try {
            currentCompany.setName(intent.getStringExtra("company_name"));
            if (currentCompany.getName().length()>26)currentCompany.setName(currentCompany.getName().substring(0,23)+"...");
            ent_name = (TextView) findViewById(R.id.textView2);
            ent_name.setText(currentCompany.getName());
            Log.d("INTENTLOG", "name still ok");
        } catch (Exception e) {
        }
        try {
            currentCompany.setEmail(intent.getStringExtra("company_mail"));
            ent_mail = (TextView) findViewById(R.id.textMail);
            ent_mail.setText(currentCompany.getEmails().get(0));
            Log.d("INTENTLOG", "mail still ok");
        } catch (Exception e) {
        }
        try {
            currentCompany.setSkype(intent.getStringExtra("company_skype"));
            ent_mail = (TextView) findViewById(R.id.textMail);
            if(currentCompany.getSkype()!=null) {
                ent_mail.setText(ent_mail.getText() + "\nSkype id:" + currentCompany.getSkype());
                Log.d("INTENTLOG", "skype still ok");
                Log.d("INTENTLOG", currentCompany.getSkype());
            }
        } catch (Exception e) {
        }
        try {
            currentCompany.setSitesUrl(intent.getStringExtra("company_sitesUrl"));
            ent_mail = (TextView) findViewById(R.id.textMail);
            if(currentCompany.getSkype()!=null) {
            ent_mail.setText(ent_mail.getText()+ "\nSite URL::" + currentCompany.getSitesUrl());
            Log.d("INTENTLOG", "site still ok");}
        } catch (Exception e) {
        }
        try {
            currentCompany.setRegionName(intent.getStringExtra("company_reg"));
            ent_reg = (TextView) findViewById(R.id.textRegion);
            ent_reg.setText(currentCompany.getRegionName());
            Log.d("INTENTLOG", "reg still ok");
        } catch (Exception e) {
        }
        try {
            currentCompany.setDescription(intent.getStringExtra("company_description"));
            ent_reg = (TextView) findViewById(R.id.textRegion);
            if(currentCompany.getDescription()!=null) {
            ent_reg.setText(ent_reg.getText() + "\n"+currentCompany.getDescription());
            Log.d("INTENTLOG", "description still ok");}
        } catch (Exception e) {
        }
        try {
            currentCompany.setYearOfFoundation(intent.getStringExtra("company_year"));
            ent_reg = (TextView) findViewById(R.id.textRegion);
            if(currentCompany.getYearOfFoundation()!=null) {
            ent_reg.setText(ent_reg.getText() + "\n"+currentCompany.getYearOfFoundation());
            Log.d("INTENTLOG", "year still ok");}
        } catch (Exception e) {
        }
        try {
            currentCompany.setPhones(intent.getStringExtra("company_phone"));
            ent_phone = (TextView) findViewById(R.id.textTelephon);
            ent_phone.setText(currentCompany.getPhones());
            Log.d("INTENTLOG", "phone still ok");
        } catch (Exception e) {
        }
        try {
            currentCompany.getContactPeople().setDirector(intent.getStringExtra("company_director"));
            ent_phone = (TextView) findViewById(R.id.textTelephon);
            ent_phone.setText(ent_phone.getText()+ "\nДиректор:"+ currentCompany.getContactPeople().getDirector());
            Log.d("INTENTLOG", "director still ok");
        } catch (Exception e) {
        }
        try {
            currentCompany.getContactPeople().setManager(intent.getStringExtra("company_manager"));
            ent_phone = (TextView) findViewById(R.id.textTelephon);
            ent_phone.setText(ent_phone.getText()+ "\nМенеджер:"+ currentCompany.getContactPeople().getManager());
            Log.d("INTENTLOG", "manager still ok");
        } catch (Exception e) {
        }
        try {
            currentCompany.setProductsAndOffers(intent.getStringExtra("company_products"));
            ent_products = (TextView) findViewById(R.id.textProducts);
            ent_products.setText(currentCompany.getProductsAndOffers());
            Log.d("INTENTLOG", "prod still ok");
        } catch (Exception e) {
        }


        presenter = new InfoPresenter(this, getApplicationContext());


        //productList = presenter.initDataProducts();


        /*buttonAll = (Button)findViewById(R.id.buttonAll);
        buttonAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentAll.setTargetFragment(fragmentAll,ALL_FRAGMENT);
                fragmentAll.show(getFragmentManager(),"Все продукты");
            }
        });*/
    }


    private void initializeData() {

    }


    @Override
    public void initializeAdapter(List<Company> enterpriseList) {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressdialog() {

    }

    public void sendMail(View view) {

        Log.i("Send email", "");

        String[] TO = {currentCompany.getEmails().get(0)};
        String[] CC = {currentCompany.getEmails().get(0)};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        Log.d("CALLLOG",Uri.parse("mailto:" + TO).toString() );
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(emailIntent);
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
          //  Toast.makeText(this,
                  //  "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }

    public void callPhone(View view) {


        String number = currentCompany.getPhones();

        //String phone = number.replaceAll("[^0-9]", "").substring(2);

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        Log.d("CALLLOG",Uri.parse("tel:" + number).toString() );
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.d("CALLLOG","ok permission" );
            startActivity(intent);

        }

    }

    public void moreInfo(View view) {
        android.app.FragmentManager fm = getFragmentManager();


        OrderFragment dialog =  OrderFragment.newInstance();

        dialog.show(fm,"empty tag");

    }
    public void createLiqPay(){
        Log.d("paylog","upgrade clicked");
        LiqPayCallBack callBack = new LiqPayCallBack() {
            @Override
            public void onResponseSuccess(final String resp) {
                Log.d("paylog","response sucsess");
                JSONObject object = null;
                try {
                    object = new JSONObject(resp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if("success".equals(object.optString("status"))){
                    // успех
                    String cardToken = object.optString("card_token");
                }else {

                    // ошибка
                }
            }

            @Override
            public void onResponceError(final ErrorCode errorCode) {
                Log.d("paylog","response error code "+errorCode);
            }
        };


        HashMap<String, String> map = new HashMap<String, String>();
        map.put("version", "3");
        map.put("public_key", "****");
        map.put("action", "pay");
        map.put("amount", "10");
        map.put("currency", "UAH");
        map.put("description", "Оплата реклами підприємства");
        map.put("order_id", "123456");
        map.put("language", "ru");
        map.put("server_url", "https://www.wargaming.net");
        map.put("sandbox", "1");
        String privateKey = "**";
        LiqPay.checkout(getApplicationContext(), map, privateKey, callBack);
     /*Intent intent = new Intent(InfoActivity.this, CheckoutActivity.class);
        startActivity(intent);*/

    }
    public void upgrade(View view) {
        showChooseDialog();
        createLiqPay();
    }

    private void showChooseDialog() {
        android.app.FragmentManager fm = getFragmentManager();
        ChoosingPayFragment payFragment = new ChoosingPayFragment();
        payFragment.show(fm, "none tag");
    }

}

