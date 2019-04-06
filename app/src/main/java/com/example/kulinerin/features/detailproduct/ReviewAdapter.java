package com.example.kulinerin.features.detailproduct;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kulinerin.R;
import com.example.kulinerin.models.Review;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewItemViewHolder> {

    private Context context;
    private ArrayList<Review> items;
    private LayoutInflater layoutInflater;
    private View view;

    public ReviewAdapter (Context context, ArrayList<Review> items){
        this.context = context;
        this.items = items;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ReviewItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = layoutInflater.inflate(R.layout.reviewers_item, viewGroup, false);
        return new ReviewAdapter.ReviewItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.ReviewItemViewHolder ReviewItemViewHolder, int i) {
//        ReviewItemViewHolder.textView.setText(menu.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ReviewItemViewHolder extends RecyclerView.ViewHolder {

//        private Seller seller;

        public ReviewItemViewHolder(@NonNull View itemView) {
            super(itemView);

//            seller = itemView.findViewById(R.id.menu_tittle);
        }
    }
}
