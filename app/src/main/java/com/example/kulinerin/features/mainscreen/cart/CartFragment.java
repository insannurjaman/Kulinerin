package com.example.kulinerin.features.mainscreen.cart;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kulinerin.R;
import com.example.kulinerin.models.Category;
import com.example.kulinerin.models.Product;
import com.example.kulinerin.models.Seller;

import java.util.ArrayList;


public class CartFragment extends Fragment {
    public ArrayList<Seller> sellers = new ArrayList<>();
    private RecyclerView recyclerView;
    private View view;

    public CartFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        generateCart();

    }

    public void generateCart() {
        Category category = new Category();
        Product product = new Product();
        product.setCategory(category);
        Seller seller = new Seller();
        seller.setProduct(product);

        sellers.add(seller);
        sellers.add(seller);
        sellers.add(seller);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView = view.findViewById(R.id.cart_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        CartAdapter cartAdapter = new CartAdapter(getActivity(), this.sellers);

        recyclerView.setAdapter(cartAdapter);

        return this.view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
