package com.sample.mydash.service;

import com.sample.mydash.entity.User;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDAOService {

    private static List<User> userList = new ArrayList<>();
    private static int userCount = 0;

    static {
        userList.add(new User(1, "Adam", new Date(), null));
        userList.add(new User(2, "Eve", new Date(), null));
        userList.add(new User(3, "Jack", new Date(), null));
        userCount = userList.size();
    }

    public List<User> listAllUsers() {
        return userList;
    }

    public User addUser(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        userList.add(user);
        return user;
    }

    public User findUser(int id) {
        for(User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteUser(int id) {
        Iterator<User> itrUser = userList.listIterator();
        User user = null;
        while(itrUser.hasNext()) {
            user = itrUser.next();
            if (user.getId() == id) {
                itrUser.remove();
                return user;
            }
        }
        return null;
    }
}
