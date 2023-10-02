package dao;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static UserDao obj = null;
    Map<String, User> userMap = new HashMap<>();

    private UserDao() {
    }

    public static UserDao getInstance() {
        if (obj == null) {
            return new UserDao();
        }
        return obj;
    }

    public void addUser(User user) {
        userMap.put(user.getName(), user);
    }
}
