package com.example.kulinerin.features.transactionlist;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.kulinerin.R;
import com.example.kulinerin.features.detailtransaction.DetailTransaction;
import com.example.kulinerin.models.Transaction;

import java.util.ArrayList;

public class TransactionItemAdapter extends RecyclerView.Adapter<TransactionItemAdapter.ChatItemViewHolder> {

    private Context context;
    private ArrayList<Transaction> items;
    private LayoutInflater layoutInflater;
    private View view;

    public TransactionItemAdapter(Context context, ArrayList<Transaction> items){
        this.context = context;
        this.items = items;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ChatItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = layoutInflater.inflate(R.layout.item_transaction_list, viewGroup, false);
        return new TransactionItemAdapter.ChatItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionItemAdapter.ChatItemViewHolder viewHolder, int i) {
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransactionList.getInstance(), DetailTransaction.class);
                TransactionList.getInstance().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ChatItemViewHolder extends RecyclerView.ViewHolder {

//        private Seller seller;
        LinearLayout layout;

        public ChatItemViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout_transaction_item);
//            seller = itemView.findViewById(R.id.menu_tittle);
        }
    }
}
