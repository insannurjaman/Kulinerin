package com.example.kulinerin.features.mainscreen.checkout;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.kulinerin.R;
import com.example.kulinerin.features.mainscreen.cart.CartAdapter;
import com.example.kulinerin.features.mainscreen.payment.PaymentActivity;
import com.example.kulinerin.models.Category;
import com.example.kulinerin.models.Product;
import com.example.kulinerin.models.Seller;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    public ArrayList<Seller> sellers = new ArrayList<>();
    private RecyclerView recyclerView;
    private Button pay;
    private static CheckoutActivity instance;

    public static CheckoutActivity getInstance() {
        return instance;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        instance = this;

        hideStatusBar();

        this.generateCart();
        recyclerView = findViewById(R.id.cart_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        CartAdapter cartAdapter = new CartAdapter(this, this.sellers);

        recyclerView.setAdapter(cartAdapter);
        pay = findViewById(R.id.button_pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getInstance(), PaymentActivity.class);
                startActivity(intent);
            }
        });

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
}
