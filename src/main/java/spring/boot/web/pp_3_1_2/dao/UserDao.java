package spring.boot.web.pp_3_1_2.dao;

import spring.boot.web.pp_3_1_2.models.User;

import java.util.List;

public interface UserDao {

    User getUser(Long id);

    List<User> getAllUsers();

    void createUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);
}
