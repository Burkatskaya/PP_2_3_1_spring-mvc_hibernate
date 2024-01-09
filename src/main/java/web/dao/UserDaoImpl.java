package web.dao;

import org.springframework.stereotype.Component;

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

        users.add(new User(++USERS_COUNT, "Model1", "111"));
        users.add(new User(++USERS_COUNT, "Model2", "222"));
        users.add(new User(++USERS_COUNT, "Model3", "333"));
        users.add(new User(++USERS_COUNT, "Model4", "444"));
        users.add(new User(++USERS_COUNT, "Model5", "555"));
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
