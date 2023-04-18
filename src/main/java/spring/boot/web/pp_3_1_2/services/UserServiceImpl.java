package spring.boot.web.pp_3_1_2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.web.pp_3_1_2.dao.UserDao;
import spring.boot.web.pp_3_1_2.models.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
