package service;

import dao.RestaurantDao;
import model.Restaurant;
import model.Review;

import java.util.List;

public class RestaurantService implements IRestaurantService{
    private static RestaurantService obj;
    private RestaurantDao restaurantDao = RestaurantDao.getInstance();
    private RestaurantService() {

    }

    public static RestaurantService getInstance() {
        if (obj == null) {
            return new RestaurantService();
        }
        return obj;
    }

    @Override
    public void registerRestaurant(Restaurant restaurant) {
        //add validations
        restaurantDao.addRestaurant(restaurant);
    }

    @Override
    public void createReview(String restaurantName, Review review) {
        //update average rating
        updateRating(restaurantName, review);
        //update review list
        updateReviewList(restaurantName, review);

    }

    @Override
    public void updateQuantity(String restaurantName, Integer newQuantity) {
        restaurantDao.addItem(restaurantName, newQuantity);
    }

    private void updateRating(String restaurantName, Review review) {
        double currentRating = restaurantDao.getRestaurantRating(restaurantName);
        int totalReviews = restaurantDao.getTotalNoOfReviews(restaurantName);
        double newAverageRating = (currentRating * totalReviews + review.getRating())/(totalReviews+1);
        restaurantDao.updateRating(restaurantName, newAverageRating);
    }

    private void updateReviewList(String restaurantName, Review review) {
        restaurantDao.addReview(restaurantName, review);
    }

    public List<Restaurant> getListOfRestaurantServiceable(String area) {
        return restaurantDao.getRestaurantsByArea(area);
    }

    public String processOrder(String restaurantName, Integer quantityOrdered) {
        int quantityAvailable = restaurantDao.getFoodQuantityAvailable(restaurantName);
        boolean canPlaceOrder = quantityAvailable >= quantityOrdered;
        if (canPlaceOrder) {
            restaurantDao.decreaseQuantity(restaurantName, quantityOrdered);
        }
        String orderStatus = canPlaceOrder
                ? "Order is successfully placed"
                : "Cannot place order";
        return orderStatus;
    }
}
