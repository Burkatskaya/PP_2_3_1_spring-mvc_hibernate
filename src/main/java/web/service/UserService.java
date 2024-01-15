package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    User show(int id);
    List<User> listUsersByCount(int count);
    void save(User user);
    void update(int id, User updateUser);
    void delete(int id);
}
