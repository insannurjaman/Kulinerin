package com.example.kulinerin.features.transactionlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kulinerin.R;
import com.example.kulinerin.models.Transaction;

import java.util.ArrayList;

public class CompleteFragment extends Fragment {
    View view;
    private RecyclerView transactionRecyclerView;
    private TransactionItemAdapter transactionAdapter;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return view = inflater.inflate(R.layout.fragment_complete, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.initTransactions();
        transactionRecyclerView = view.findViewById(R.id.recycler_view_transaction_complete);
        transactionRecyclerView.setLayoutManager(new LinearLayoutManager(
                TransactionList.getInstance()
        ));

        transactionRecyclerView.setHasFixedSize(true);
        transactionAdapter = new TransactionItemAdapter(TransactionList.getInstance(), transactions);
        transactionRecyclerView.setAdapter(transactionAdapter);
    }

    public void initTransactions() {
        this.transactions.add(new Transaction());
        this.transactions.add(new Transaction());
    }
}