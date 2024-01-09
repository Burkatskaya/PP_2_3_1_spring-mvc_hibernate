package web.dao;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    List<User> listUsersByCount(int count);
}
