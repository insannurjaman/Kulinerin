package com.example.kulinerin.menu.Home.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.kulinerin.R;
import com.example.kulinerin.menu.Home.HomeActivity;
import com.example.kulinerin.menu.Home.PromoModel;

import java.util.ArrayList;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.ViewHolder> {


    private Context context;
    private ArrayList<PromoModel> listPromo;



    public ArrayList<PromoModel> getListPromo() {
        return listPromo;
    }
    public void setListPromo(ArrayList<PromoModel> listPromo) {
        this.listPromo = listPromo;
    }
    public PromoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_promo, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context)
                .load(getListPromo().get(position).getImage_drawable())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return listPromo.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = (ImageView) itemView.findViewById(R.id.imgViewPromo);
        }
    }
}
