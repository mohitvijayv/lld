package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    String name;
    double rating;
    List<String> areasServiceable;
    List<Review> reviews = new ArrayList<>();
    Food foodItem; //for simplicity taking only one food item per restaurant
    public Restaurant(String name, List<String> areasServiceable, Food item) {
        this.name = name;
        this.areasServiceable = areasServiceable;
        this.foodItem = item;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public List<String> getAreasServiceable() {
        return areasServiceable;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Food getFoodItem() {
        return foodItem;
    }
}
