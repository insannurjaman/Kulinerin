package com.example.kulinerin.features.mainscreen.notification;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kulinerin.R;
import com.example.kulinerin.features.mainscreen.MainScreenActivity;
import com.example.kulinerin.models.Notification;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {
    private RecyclerView notificationRecyclerView;
    private NotificationAdapter notificationAdapter;
    private ArrayList<Notification> notifications = new ArrayList<>();
    private View view;

    public NotificationFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return view = inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.initNotification();
        notificationRecyclerView = view.findViewById(R.id.recycler_view_notification);
        notificationRecyclerView.setLayoutManager(new LinearLayoutManager(
                getActivity()
        ));

        notificationRecyclerView.setHasFixedSize(true);
        notificationAdapter = new NotificationAdapter(MainScreenActivity.getInstance() ,notifications);
        notificationRecyclerView.setAdapter(notificationAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void initNotification() {
        this.notifications.add(new Notification());
        this.notifications.add(new Notification());
        this.notifications.add(new Notification());
        this.notifications.add(new Notification());
    }
}
