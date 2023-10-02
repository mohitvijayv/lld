package service;

import dao.UserDao;
import model.User;

public class UserService implements IUserService {
    private UserDao userDao = UserDao.getInstance();


    @Override
    public void registerUser(User user) {
        //add validation if user already exists
        userDao.addUser(user);
    }
}
