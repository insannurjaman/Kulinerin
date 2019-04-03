package com.example.kulinerin.features.mainscreen.home;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.kulinerin.R;
import com.example.kulinerin.features.mainscreen.MainScreenActivity;
import com.example.kulinerin.features.mainscreen.home.Adapters.CategoryAdapter;
import com.example.kulinerin.features.mainscreen.home.Adapters.PromoAdapter;
import com.example.kulinerin.features.mainscreen.home.Pojos.CategoryModel;
import com.example.kulinerin.features.mainscreen.home.Pojos.PromoData;
import com.example.kulinerin.features.mainscreen.home.Pojos.PromoModel;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class HomeActivity extends Fragment {

    TextView tvTitle;

    private ArrayList<PromoModel> imagePromoArrayList;
    private RecyclerView rvPromo;
    private RecyclerView rvCategory;
    private RecyclerView.Adapter categoryAdapter;
    private PromoAdapter promoAdapter;
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


        //Setting up promo image
        rvPromo = view.findViewById(R.id.rv_promo);
        rvPromo.setHasFixedSize(true);
        imagePromoArrayList = new ArrayList<>();





        //Setting up category
        ArrayList<CategoryModel> categories = initCategory();
        this.rvCategory = view.findViewById(R.id.rv_category);
        this.rvCategory.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainScreenActivity.getInstance(), LinearLayoutManager.HORIZONTAL, false);
        this.rvCategory.setLayoutManager(mLayoutManager);
        categoryAdapter = new CategoryAdapter(categories);

        this.rvCategory.setAdapter(categoryAdapter);




        if (savedInstanceState == null) {
            //setActionBarTitle("Mode List");
            imagePromoArrayList.addAll(PromoData.getListData());
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
        PromoAdapter promoAdapter = new PromoAdapter(MainScreenActivity.getInstance());

        promoAdapter.setListPromo(imagePromoArrayList);

        rvPromo.setAdapter(promoAdapter);
        rvPromo.setLayoutManager(new LinearLayoutManager(MainScreenActivity.getInstance(), LinearLayoutManager.HORIZONTAL,false));
        Log.d("makan", "bubur");
    }








    //Catgory
    private ArrayList<CategoryModel> initCategory(){
        ArrayList<CategoryModel> list = new ArrayList<>();

        list.add(new CategoryModel("Sayuran","https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjQxK_927HhAhXb7XMBHVlMDgQQjRx6BAgBEAU&url=https%3A%2F%2Friauaktual.com%2Fnews%2Fdetail%2F57678%2Fsayursayuran-ini-sebaiknya-tidak-dimakan-mentah.html&psig=AOvVaw2aGvro4bevRfsz4yN1nSan&ust=1554305134331082"));
        list.add(new CategoryModel("Telur","https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwj-1qea3LHhAhWh7XMBHZ5gABMQjRx6BAgBEAU&url=http%3A%2F%2Fwww.tribunnews.com%2Fnasional%2F2018%2F03%2F17%2Fberita-hoax-telur-palsu-resahkan-masyarakat-4-hal-ini-harus-diperhatikan&psig=AOvVaw2wqAN_rkHV9ENDvQtuNJBR&ust=1554305179859641"));
        list.add(new CategoryModel("Susu","https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjPupes3LHhAhWi_XMBHY-CDrMQjRx6BAgBEAU&url=http%3A%2F%2Fpedomanbengkulu.com%2F2018%2F07%2Fketahui-perbedaan-susu-formula-susu-uht-dan-susu-pasteurisasi%2F&psig=AOvVaw3BaM2C-e_moFKsf21vrUeA&ust=1554305226818983"));
        list.add(new CategoryModel("Jagung","https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjaq8a63LHhAhXV6XMBHdx3BJ8QjRx6BAgBEAU&url=https%3A%2F%2Fwww.pioneer.com%2Fweb%2Fsite%2Findonesia%2FInilah-Kelebihan-Jagung-Tongkol&psig=AOvVaw0CPymfW55jEX8G5AoOkZSU&ust=1554305261683302"));
        list.add(new CategoryModel("Beras", "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwiL58HK3LHhAhXyQ3wKHasRCe4QjRx6BAgBEAU&url=http%3A%2F%2Fjakarta.tribunnews.com%2F2018%2F09%2F28%2Fdata-tak-akurat-impor-beras-berdampak-menurunkan-kesejahteraan-petani&psig=AOvVaw1D7dpi-iw2U7IxpAQdlVRr&ust=1554305294679813"));

        return list;
    }
}
