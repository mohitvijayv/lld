import model.Food;
import model.Restaurant;
import model.User;
import service.OrderService;
import service.RestaurantService;
import service.UserService;

import java.util.List;

public class ClearFood {
    public static void main(String[] args) {
        UserService userService = new UserService();
        RestaurantService restaurantService = RestaurantService.getInstance();
        OrderService orderService = OrderService.getInstance();

        userService.registerUser(new User("mohit", "HSR"));
        userService.registerUser(new User("nitesh", "BTM"));
        userService.registerUser(new User("himanshu", "HSR"));

        restaurantService.registerRestaurant(new Restaurant("FC-1", List.of("HSR", "BTM"),
                new Food("Burger", 10, 10)));

        restaurantService.registerRestaurant(new Restaurant("FC-2", List.of("BTM"),
                new Food("pizza", 100, 10)));

        restaurantService.registerRestaurant(new Restaurant("FC-3", List.of("HSR"),
                new Food("fries", 100, 5)));

        System.out.println(orderService.showRestaurant("HSR"));
        System.out.println(orderService.placeOrder("FC-1", 2));

    }
}
