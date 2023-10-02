package service;

import model.Restaurant;

import java.util.List;

public class OrderService implements IOrderService{
    RestaurantService restaurantService = RestaurantService.getInstance();
    private static OrderService obj = null;
    private OrderService() {

    }
    public static OrderService getInstance() {
        if (obj == null) {
            return new OrderService();
        }
        return obj;
    }
    @Override
    public String placeOrder(String restaurantName, Integer quantity) {
        return restaurantService.processOrder(restaurantName, quantity);
    }

    @Override
    public List<Restaurant> showRestaurant(String area) {
        return restaurantService.getListOfRestaurantServiceable(area);
    }
}
