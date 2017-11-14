package com.example.biz_41.Presenter;

/**
 * Created by Karl on 16.05.2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.biz_41.Model.Category;
import com.example.biz_41.Model.CustomItemClickListener;
import com.example.biz_41.R;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
Context context;
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {


        TextView name;


        CategoryViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.category_card);


        }
    }

    List<Category> categories;


    CustomItemClickListener listener = new CustomItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
           // Toast.makeText(v.getContext(), "item "+String.valueOf(position), Toast.LENGTH_SHORT).show();
            categories.get(position).setClicked(!categories.get(position).isClicked());
            if(categories.get(position).isClicked()){
                categories.get(position).setBackground(R.drawable.shape_category_enabled);}
            else {
                categories.get(position).setBackground(R.drawable.shape_category);
            }
            Log.d("tagsetclicked","set clicked in adapter for i= "+ String.valueOf(position));
        }
    };

    public CategoryAdapter(Context context, List<Category> categories, CustomItemClickListener listener){
        this.categories = categories;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }





    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_card, viewGroup, false);
        final CategoryViewHolder pp = new CategoryViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* if(categories.get(i).isClicked()){
                    pp.name.setBackgroundResource(R.drawable.shape_category_enabled);
                    Log.d("tagsetclicked","change background");
                }
*/
                Log.d("allok","allok1");
                //v.setBackgroundResource();

                Log.d("allok","allok2");
                listener.onItemClick(v, pp.getAdapterPosition());
                notifyDataSetChanged();
                Log.d("allok","allok3");
            }
        });

        return pp;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder persnViewHolder, int i) {
        persnViewHolder.name.setText(categories.get(i).getName());
        Log.d("tagsetclicked","onBind holder check");
        persnViewHolder.itemView.setBackgroundResource(categories.get(i).getBackground());


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


}