package dao;

import model.Food;
import model.Restaurant;
import model.Review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestaurantDao {
    private static RestaurantDao obj = null;
    private static Map<String, Restaurant> restaurantMap = new HashMap<>();

    private RestaurantDao() {
    }

    public static RestaurantDao getInstance() {
        if (obj == null) {
            return new RestaurantDao();
        }
        return obj;
    }


    public void addRestaurant(Restaurant restaurant) {

        restaurantMap.put(restaurant.getName(), restaurant);
    }

    public double getRestaurantRating(String restaurantName) {
        return restaurantMap.get(restaurantName).getRating();
    }

    public int getTotalNoOfReviews(String restaurantName) {
        return restaurantMap.get(restaurantName).getReviews().size();
    }

    public void updateRating(String restaurantName, double newAverageRating) {
        restaurantMap.get(restaurantName).setRating(newAverageRating);
    }

    public void addReview(String restaurantName, Review review) {
        restaurantMap.get(restaurantName).getReviews().add(review);
    }

    public List<Restaurant> getRestaurantsByArea(String area) {
        return restaurantMap.values()
                .stream()
                .filter(restaurant -> restaurant.getAreasServiceable().contains(area))
                .collect(Collectors.toList());
    }

    public int getFoodQuantityAvailable(String restaurantName) {
        return restaurantMap.get(restaurantName).getFoodItem().getQuantity();
    }

    public void decreaseQuantity(String restaurantName, Integer quantity) {
        Food item = restaurantMap.get(restaurantName).getFoodItem();
        item.setQuantity(item.getQuantity() - quantity);

    }

    public void addItem(String restaurantName, Integer newQuantity) {
        Food item = restaurantMap.get(restaurantName).getFoodItem();
        item.setQuantity(item.getQuantity() + newQuantity);
    }
}
