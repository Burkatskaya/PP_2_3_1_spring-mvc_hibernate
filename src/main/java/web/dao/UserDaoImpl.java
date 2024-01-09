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
    public List<User> listUsersByCount(int count) {
        return count > 0 && count < 5
                ? IntStream.range(0, users.size())
                .limit(count)
                .mapToObj(users::get)
                .collect(Collectors.toList())
                : users;
    }
}
