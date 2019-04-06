package com.example.kulinerin.features.mainscreen.home.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kulinerin.R;
import com.example.kulinerin.features.mainscreen.home.Pojos.CategoryModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<CategoryModel> categoryList;

    public CategoryAdapter(ArrayList<CategoryModel> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_promo, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryModel categoryModel = categoryList.get(position);

        holder.title.setText(categoryModel.getTitle());
        Picasso.get().load(categoryModel.getImageURL()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView title;
        public final ImageView image;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.view = view;

            title = view.findViewById(R.id.tv_title_cat);
            image = view.findViewById(R.id.iv_img_Cat);

        }
    }}
