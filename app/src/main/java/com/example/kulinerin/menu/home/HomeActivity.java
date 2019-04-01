package com.example.kulinerin.menu.home;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.kulinerin.R;
import com.example.kulinerin.menu.home.Adapters.PromoAdapter;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    TextView tvTitle;

    private ArrayList<PromoModel> imagePromoArrayList;
    private RecyclerView rvPromo;
    private PromoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/

        //make translucent statusBar on kitkat devices
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);


        //Setting up promo image
        rvPromo = findViewById(R.id.rv_promo);
        rvPromo.setHasFixedSize(true);



        imagePromoArrayList = new ArrayList<>();


        if (savedInstanceState == null) {
            //setActionBarTitle("Mode List");
            imagePromoArrayList.addAll(PromoImage.getListData());
            showRecyclerList();

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

    private void showRecyclerList() {
        PromoAdapter promoAdapter = new PromoAdapter(this);

        promoAdapter.setListPromo(imagePromoArrayList);

        rvPromo.setAdapter(promoAdapter);
        rvPromo.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false));
        Log.d("makan", "bubur");
    }
}
