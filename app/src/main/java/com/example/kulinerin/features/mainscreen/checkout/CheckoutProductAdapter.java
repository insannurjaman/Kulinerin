package com.example.kulinerin.features.mainscreen.checkout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kulinerin.R;
import com.example.kulinerin.models.Seller;

import java.util.ArrayList;

public class CheckoutProductAdapter extends RecyclerView.Adapter<CheckoutProductAdapter.CartItemViewHolder> {

    private Context context;
    private ArrayList<Seller> items;
    private LayoutInflater layoutInflater;
    private View view;

    public CheckoutProductAdapter(Context context, ArrayList<Seller> items){
        this.context = context;
        this.items = items;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = layoutInflater.inflate(R.layout.cardview_checkout_item, viewGroup, false);
        return new CheckoutProductAdapter.CartItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutProductAdapter.CartItemViewHolder CartItemViewHolder, int i) {
//        CartItemViewHolder.textView.setText(menu.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CartItemViewHolder extends RecyclerView.ViewHolder {

//        private Seller seller;

        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);

//            seller = itemView.findViewById(R.id.menu_tittle);
        }
    }
}
