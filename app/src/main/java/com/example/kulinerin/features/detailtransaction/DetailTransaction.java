package com.example.kulinerin.features.detailtransaction;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.kulinerin.R;
import com.example.kulinerin.features.transactionlist.TransactionList;
import com.example.kulinerin.models.Seller;

import java.util.ArrayList;

public class DetailTransaction extends AppCompatActivity {
    public ArrayList<Seller> products = new ArrayList<>();
    public RecyclerView productListRecyclerView;
    public ProductListAdapter adapter;
    public Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transaction);

        hideStatusBar();

        this.initProductList();
        productListRecyclerView = findViewById(R.id.recycler_view_product_list);
        productListRecyclerView.setLayoutManager(new LinearLayoutManager(
                this));
        productListRecyclerView.setHasFixedSize(true);
        adapter = new ProductListAdapter(products);
        productListRecyclerView.setAdapter(adapter);

    }

    public void hideStatusBar() {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            this.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    public void initProductList() {
        products.add(new Seller());
        products.add(new Seller());
        products.add(new Seller());
        products.add(new Seller());
        products.add(new Seller());
        products.add(new Seller());
        products.add(new Seller());
        products.add(new Seller());
    }
}
