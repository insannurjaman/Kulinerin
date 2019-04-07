package com.example.kulinerin.features.mainscreen.notification;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kulinerin.R;
import com.example.kulinerin.models.Notification;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ChatItemViewHolder> {

    private Context context;
    private ArrayList<Notification> items;
    private LayoutInflater layoutInflater;
    private View view;

    public NotificationAdapter(Context context, ArrayList<Notification> items){
        this.context = context;
        this.items = items;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ChatItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = layoutInflater.inflate(R.layout.item_notification, viewGroup, false);
        return new NotificationAdapter.ChatItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.ChatItemViewHolder ChatItemViewHolder, int i) {
//        ChatItemViewHolder.textView.setText(menu.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ChatItemViewHolder extends RecyclerView.ViewHolder {

//        private Seller seller;

        public ChatItemViewHolder(@NonNull View itemView) {
            super(itemView);

//            seller = itemView.findViewById(R.id.menu_tittle);
        }
    }
}
