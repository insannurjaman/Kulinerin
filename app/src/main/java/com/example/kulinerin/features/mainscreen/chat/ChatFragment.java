package com.example.kulinerin.features.mainscreen.chat;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kulinerin.MainActivity;
import com.example.kulinerin.R;
import com.example.kulinerin.features.mainscreen.MainScreenActivity;
import com.example.kulinerin.models.ChatBubble;

import java.util.ArrayList;

public class ChatFragment extends Fragment {
    private RecyclerView chatRecyclerView;
    private ChatAdapter chatAdapter;
    private ArrayList<ChatBubble> chats = new ArrayList<>();
    private View view;

    public ChatFragment() {
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
        return this.view = inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.initChat();
        chatRecyclerView = view.findViewById(R.id.recycler_view_chat);
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(
                getActivity()
        ));

        chatRecyclerView.setHasFixedSize(true);
        chatAdapter = new ChatAdapter(MainScreenActivity.getInstance() ,chats);
        chatRecyclerView.setAdapter(chatAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
    
    public void initChat() {
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
        this.chats.add(new ChatBubble());
    }
}
