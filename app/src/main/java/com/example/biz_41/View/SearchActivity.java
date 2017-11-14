package com.example.biz_41.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.biz_41.Model.Category;
import com.example.biz_41.Model.CustomItemClickListener;
import com.example.biz_41.Presenter.CategoryAdapter;
import com.example.biz_41.R;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private List<Category> categoriesList;
    private List<Category> regionsList;
    private RecyclerView rvc, rvc2;
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        rvc=(RecyclerView)findViewById(R.id.rvc);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvc.setLayoutManager(llm);
        rvc.setHasFixedSize(true);

        rvc2=(RecyclerView)findViewById(R.id.rvc2);
        edt = (EditText)findViewById(R.id.search_text);
        LinearLayoutManager llm2 = new LinearLayoutManager(this);
        rvc2.setLayoutManager(llm2);
        rvc2.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.place_search_head));
        return super.onCreateOptionsMenu(menu);

    }
    private void initializeData() {
        categoriesList = new ArrayList<>();


            categoriesList.add(new Category("59ed26240e0742b928d193b8","Діяльність екстериторіальних організацій і органів"));
            categoriesList.add(new Category("59ed26240e0742b928d193b2","Діяльність домашніх господарств"));
            categoriesList.add(new Category("59ed26240e0742b928d1923e","Сільське господарство, лісове господарство та рибне господарство"));
            categoriesList.add(new Category("59ed26240e0742b928d1924f","Добувна промисловість і розроблення кар'єрів"));
            categoriesList.add(new Category("59ed26240e0742b928d1925f","Переробна промисловість"));
            categoriesList.add(new Category("59ed26240e0742b928d192d7","Постачання електроенергії, газу, пари та кондиційованого повітря"));
            categoriesList.add(new Category("59ed26240e0742b928d192dc","Водопостачання; каналізація, поводження з відходами"));
            categoriesList.add(new Category("59ed26240e0742b928d192e7","Будівництво"));
            categoriesList.add(new Category("59ed26240e0742b928d192f4","Оптова та роздрібна торгівля; ремонт автотранспортних засобів і мотоциклів"));
            categoriesList.add(new Category("59ed26240e0742b928d1930d","Транспорт, складське господарство, поштова та кур'єрська діяльність"));
            categoriesList.add(new Category("59ed26240e0742b928d19322","Тимчасове розміщування й організація харчування"));
            categoriesList.add(new Category("59ed26240e0742b928d1932c","Інформація та телекомунікації"));
            categoriesList.add(new Category("59ed26240e0742b928d19340","Фінансова та страхова діяльність"));
            categoriesList.add(new Category("59ed26240e0742b928d1934e","Операції з нерухомим майном"));
            categoriesList.add(new Category("59ed26240e0742b928d19353","Професійна, наукова та технічна діяльність"));
            categoriesList.add(new Category("59ed26240e0742b928d1936a","Діяльність у сфері адміністративного та допоміжного обслуговування"));
            categoriesList.add(new Category("59ed26240e0742b928d19384","Державне управління й оборона; обов'язкове соціальне страхування"));
            categoriesList.add(new Category("59ed26240e0742b928d19389","Освіта"));
            categoriesList.add(new Category("59ed26240e0742b928d19391","Охорона здоров'я та надання соціальної допомоги"));
            categoriesList.add(new Category("59ed26240e0742b928d1939e","Мистецтво, спорт, розваги та відпочинок"));
            categoriesList.add(new Category("59ed26240e0742b928d193a8","Надання інших видів послуг"));

        regionsList = new ArrayList<>();

            regionsList.add(new Category("59ed26230e0742b928d18f7d","АР Крим"));
        regionsList.add(new Category("59ed26230e0742b928d18f97","Вінницька обл."));
        regionsList.add(new Category("59ed26230e0742b928d18fb9","Волинська обл."));
        regionsList.add(new Category("59ed26230e0742b928d18fce","Дніпропетровська обл."));
        regionsList.add(new Category("59ed26230e0742b928d18ff2","Донецька обл."));
        regionsList.add(new Category("59ed26230e0742b928d19021","Житомирська обл."));
        regionsList.add(new Category("59ed26230e0742b928d1903e","Закарпатська обл."));
        regionsList.add(new Category("59ed26230e0742b928d19051","Запорізька обл."));
        regionsList.add(new Category("59ed26230e0742b928d1906b","Івано-Франківська обл."));
        regionsList.add(new Category("59ed26230e0742b928d1907f","Київська обл."));
        regionsList.add(new Category("59ed26230e0742b928d190a3","Кіровоградська обл."));
        regionsList.add(new Category("59ed26230e0742b928d190bd","Луганська обл."));
        regionsList.add(new Category("59ed26230e0742b928d190de","Львівська обл."));
        regionsList.add(new Category("59ed26230e0742b928d190fc","Миколаївська обл."));
        regionsList.add(new Category("59ed26230e0742b928d19115","Одеська обл."));
        regionsList.add(new Category("59ed26230e0742b928d19136","Полтавська обл."));
        regionsList.add(new Category("59ed26230e0742b928d19155","Рівненська обл."));
        regionsList.add(new Category("59ed26230e0742b928d1916a","Сумська обл."));
        regionsList.add(new Category("59ed26230e0742b928d19184","Тернопільська обл."));
        regionsList.add(new Category("59ed26230e0742b928d19197","Харківська обл."));
        regionsList.add(new Category("59ed26230e0742b928d191ba","Херсонська обл."));
        regionsList.add(new Category("59ed26230e0742b928d191d0","Хмельницька обл."));
        regionsList.add(new Category("59ed26230e0742b928d191eb","Черкаська обл."));
        regionsList.add(new Category("59ed26230e0742b928d19206","Чернівецька обл."));
        regionsList.add(new Category("59ed26230e0742b928d19214","Чернігівська обл."));
        regionsList.add(new Category("59ed26230e0742b928d1922e","м. Київ"));
        regionsList.add(new Category("59ed26230e0742b928d19239","м. Севастополь"));



    }
    private void initializeAdapter(){
        CategoryAdapter adapterCategory = new CategoryAdapter(this, categoriesList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Log.d("tagsetclicked","set clicked for i= "+ String.valueOf(position));
                //categoriesList.get(position).setClicked(!categoriesList.get(position).isClicked());
                Log.d("tagsetclicked","set clicked");


                //Toast.makeText(getApplicationContext(), "item "+String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
        CategoryAdapter adapterRegion = new CategoryAdapter(this, regionsList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //regionsList.get(position).setClicked(!regionsList.get(position).isClicked());
                Log.d("tagsetclicked","set clicked");
                //v.setBackgroundResource(R.drawable.shape_category_enabled);

               // Toast.makeText(getApplicationContext(), "item "+String.valueOf(position), Toast.LENGTH_SHORT).show();


                    Log.d("adapter test","notify called");}


        });
        rvc.setAdapter(adapterCategory);
        rvc2.setAdapter(adapterRegion);
    }

    public void CategoriesChoosingDone(View view) {
        String selectedCategories = "";
        String selectedCategoriesNames = "";
        String selectedRegions = "";
        String selectedRegionsNames="";
        for(int i=0;i<categoriesList.size();i++){
           if(categoriesList.get(i).isClicked()){
               selectedCategories = selectedCategories + categoriesList.get(i).getId()+",";
               selectedCategoriesNames = selectedCategoriesNames + categoriesList.get(i).getName()+",";
           }
        }
        if (selectedCategories.length()>1)selectedCategories = selectedCategories.substring(0,selectedCategories.length()-1);
        for(int i=0;i<regionsList.size();i++){
            if(regionsList.get(i).isClicked()){
                selectedRegions = selectedRegions + regionsList.get(i).getId()+",";
                selectedRegionsNames = selectedRegionsNames + regionsList.get(i).getName()+",";
            }
        }
        if (selectedRegions.length()>1)selectedRegions = selectedRegions.substring(0,selectedRegions.length()-1);

        Intent intent = new Intent(SearchActivity.this, MainActivity.class);
        intent.putExtra("categoryIds", selectedCategories);
        intent.putExtra("categoryNames", selectedCategoriesNames);
        intent.putExtra("regionIds", selectedRegions);
        intent.putExtra("regionNames", selectedRegionsNames);
        Log.d("intentcatcher", "send intent");
        startActivity(intent);
    }

    public void searchByText(View view) {
        Log.d("searchlog","have text = "+edt.getText().toString().trim() + " ; send to main");
        Intent intent = new Intent(SearchActivity.this, MainActivity.class);
        intent.putExtra("text", edt.getText().toString().trim());
        startActivity(intent);

    }

    public void hintCategory(View view){
        categoriesList.get(0).setClicked(!categoriesList.get(0).isClicked());
    }
    public void hintRegion(View view) {
        regionsList.get(0).setClicked(!regionsList.get(0).isClicked());
    }
}
