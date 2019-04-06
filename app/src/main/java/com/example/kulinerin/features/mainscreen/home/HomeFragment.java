package com.example.kulinerin.features.mainscreen.home;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.kulinerin.R;
import com.example.kulinerin.features.mainscreen.MainScreenActivity;
import com.example.kulinerin.features.mainscreen.home.Adapters.CategoryAdapter;
import com.example.kulinerin.features.mainscreen.home.Adapters.ProductAdapter;
import com.example.kulinerin.models.Category;
import com.example.kulinerin.models.Product;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    //category
    private RecyclerView categoryRecyclerView;
    private RecyclerView.Adapter categoryAdapter;
    private ArrayList<Category> categories = new ArrayList<>();

    //product
    private RecyclerView productRecyclerView;
    private RecyclerView.Adapter productAdapter;
    private ArrayList<Product> products = new ArrayList<>();

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/

        //make translucent statusBar on kitkat devices
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(MainScreenActivity.getInstance(), WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            MainScreenActivity.getInstance().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(MainScreenActivity.getInstance(), WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            MainScreenActivity.getInstance().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        MainScreenActivity.getInstance().getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        MainScreenActivity.getInstance().getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        //Setting up category
        this.initCategory();
        categoryRecyclerView = view.findViewById(R.id.recycler_view_category);
        categoryRecyclerView.setLayoutManager(new GridLayoutManager(
                MainScreenActivity.getInstance(),
                2,
                GridLayoutManager.HORIZONTAL,
                false));
        categoryAdapter = new CategoryAdapter(categories);
        categoryRecyclerView.setAdapter(categoryAdapter);


        //Setting up product
        this.initProduct();
        productRecyclerView = view.findViewById(R.id.recycler_view_product);
        productRecyclerView.setLayoutManager(new GridLayoutManager(
                MainScreenActivity.getInstance(),
                2,
                GridLayoutManager.VERTICAL,
                false));
        productAdapter = new ProductAdapter(products);
        productRecyclerView.setNestedScrollingEnabled(false);
        productRecyclerView.setAdapter(productAdapter);
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

    //Catgory
    private void initCategory(){
        categories.add(new Category("Sayuran","https://riauaktual.com/application/views/web/berita/61194223351-gallery_jvpu3mi6uk.jpg"));
        categories.add(new Category("Telur","http://cdn2.tstatic.net/tribunnews/foto/bank/images/telur-ayam_20180317_180649.jpg"));
        categories.add(new Category("Susu","http://pedomanbengkulu.com/wp-content/uploads/2018/07/received_1850261045032778.jpeg"));
        categories.add(new Category("Jagung","https://www.pertanianku.com/wp-content/uploads/2017/07/Inilah-Kelebihan-Jagung-Tongkol.jpg"));
        categories.add(new Category("Beras", "http://cdn2.tstatic.net/jakarta/foto/bank/images/beras_20180524_072617.jpg"));
        categories.add(new Category("Beras", "http://cdn2.tstatic.net/jakarta/foto/bank/images/beras_20180524_072617.jpg"));
        categories.add(new Category("Beras", "http://cdn2.tstatic.net/jakarta/foto/bank/images/beras_20180524_072617.jpg"));
        categories.add(new Category("Beras", "http://cdn2.tstatic.net/jakarta/foto/bank/images/beras_20180524_072617.jpg"));
        categories.add(new Category("Beras", "http://cdn2.tstatic.net/jakarta/foto/bank/images/beras_20180524_072617.jpg"));
        categories.add(new Category("Beras", "http://cdn2.tstatic.net/jakarta/foto/bank/images/beras_20180524_072617.jpg"));
    }

    //Catgory
    private void initProduct(){
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());
    }
}
