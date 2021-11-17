package com.java.boutique.models.viewmodels;

public class ProductViewModel {
    private String type;
    private int rating;
    private String name;
    private String createdAt;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


}
