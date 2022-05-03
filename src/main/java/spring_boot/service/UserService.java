package spring_boot.service;

import spring_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    void addUser(User user);
    void updateUser(long id, User user);
    void removeUser(long id);

    User getUser(long id);
}
