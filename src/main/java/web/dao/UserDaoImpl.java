package web.dao;

import org.springframework.stereotype.Component;

import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class UserDaoImpl implements UserDao {
    private static int USERS_COUNT;

    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++USERS_COUNT, "Name1", "Lastname1"));
        users.add(new User(++USERS_COUNT, "Name2", "Lastname2"));
        users.add(new User(++USERS_COUNT, "Name3", "Lastname3"));
        users.add(new User(++USERS_COUNT, "Name4", "Lastname4"));
        users.add(new User(++USERS_COUNT, "Name5", "Lastname5"));
    }

    @Override
    public List<User> listUsers() {
        return users;
    }

    @Override
    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<User> listUsersByCount(int count) {
        return count > 0 && count < 100
                ? IntStream.range(0, users.size())
                .limit(count)
                .mapToObj(users::get)
                .collect(Collectors.toList())
                : users;
    }

    @Override
    public void save(User user) {
        user.setId(++USERS_COUNT);
        users.add(user);
    }

    @Override
    public void update(int id, User updateUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setLastname(updateUser.getLastname());
    }

    @Override
    public void delete(int id) {
        users.removeIf(u -> u.getId() == id);
    }
}
