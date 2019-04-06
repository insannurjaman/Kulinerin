package com.example.kulinerin.models;

public class Category  {
    private String title;
    private String imageURL;

    public Category() {}

    public Category( String title, String imageURL) {

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
