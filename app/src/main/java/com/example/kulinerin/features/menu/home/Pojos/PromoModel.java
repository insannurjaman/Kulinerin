package com.example.kulinerin.features.menu.home.Pojos;

import android.os.Parcel;
import android.os.Parcelable;

public class PromoModel implements Parcelable {
    private int image_drawable;
    private int index;


    public int getImage_drawable() {
        return image_drawable;
    }

    public void setImage_drawable(int image_drawable) {
        this.image_drawable = image_drawable;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.image_drawable);
        dest.writeInt(this.index);
    }

    public PromoModel() {
    }

    protected PromoModel(Parcel in) {
        this.image_drawable = in.readInt();
        this.index = in.readInt();
    }

    public static final Parcelable.Creator<PromoModel> CREATOR = new Parcelable.Creator<PromoModel>() {
        @Override
        public PromoModel createFromParcel(Parcel source) {
            return new PromoModel(source);
        }

        @Override
        public PromoModel[] newArray(int size) {
            return new PromoModel[size];
        }
    };
}
