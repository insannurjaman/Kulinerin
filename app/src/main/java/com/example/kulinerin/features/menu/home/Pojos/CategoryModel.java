package com.example.kulinerin.features.menu.home.Pojos;

public class CategoryModel  {


    private String title;
    private String imageURL;

    public CategoryModel( String title, String imageURL) {

        this.title = title;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
