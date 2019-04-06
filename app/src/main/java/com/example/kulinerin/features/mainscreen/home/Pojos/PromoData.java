package com.example.kulinerin.features.mainscreen.home.Pojos;

import android.util.Log;

import java.util.ArrayList;

public class PromoData {


public static String[][] data = new String[][]{
        {"https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwizza3jvKzhAhUPbn0KHYxCBDkQjRx6BAgBEAU&url=https%3A%2F%2Fapkpure.com%2Fid%2Fpromo-grab-food-guide-terlengkap%2Fcom.guidereferencegrabfood.ojekonlinepanduan&psig=AOvVaw15w_E0WjHEcMMPSzcVBFmS&ust=1554124877113564"}
        ,
        {"https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwiezIu_0KzhAhVz8XMBHeaoBdgQjRx6BAgBEAU&url=https%3A%2F%2Fsg.everydayonsales.com%2Fnews%2F2762%2F3-grabfood-promo-code-that-you-use-for-food-ordering-with-food-price-as-low-as-1%2F&psig=AOvVaw15w_E0WjHEcMMPSzcVBFmS&ust=1554124877113564"},
        };


public static ArrayList<PromoModel> getListData(){

        PromoModel promoModel = null;
        ArrayList<PromoModel> list = new ArrayList<>();

        for (int i=0; i < data.length; i++ ) {

            promoModel = new PromoModel();
            promoModel.setImage_drawable(i);
            promoModel.setIndex(i);

            list.add(promoModel);

            Log.i("add", list.toString());

        }

        return list;
    }

    }


