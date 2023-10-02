package service;

import model.Restaurant;

import java.util.List;

public interface IOrderService {
    String placeOrder(String restaurantName, Integer quantity);
    List<Restaurant> showRestaurant(String area);
}
