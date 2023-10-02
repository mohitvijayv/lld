package service;

import model.Restaurant;
import model.Review;

public interface IRestaurantService {
    void registerRestaurant(Restaurant restaurant);
    void createReview(String restaurantName, Review review);
    void updateQuantity(String restaurantName, Integer newQuantity);
}
