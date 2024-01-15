package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.UserDao;

import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Override
       public User show(int id) {
        return userDao.show(id);
    }

    @Override
    public List<User> listUsersByCount(int count) {
        return userDao.listUsersByCount(count);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(int id, User updateUser) {
        userDao.update(id, updateUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
