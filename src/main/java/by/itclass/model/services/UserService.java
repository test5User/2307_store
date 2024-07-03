package by.itclass.model.services;

import by.itclass.model.dao.UserDao;
import by.itclass.model.entities.User;

public class UserService {
    private UserDao dao;
    private static UserService service;

    private UserService() {
        dao = UserDao.getInstance();
    }

    public static UserService getInstance() {
        return service == null ? new UserService() : service;
    }

    public User getUser(String login, String password) {
        return dao.selectUser(login, password);
    }

    public boolean addUser(User user) {
        return dao.insertUser(user);
    }
}
