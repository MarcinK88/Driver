package pl.coderslab.service;

import pl.coderslab.model.User;

import java.util.List;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);

    List<User> findAll();

    void save(User user);

    User getOne(long id);

    void delete(User user);
}
