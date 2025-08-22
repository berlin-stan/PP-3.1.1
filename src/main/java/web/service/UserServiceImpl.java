package web.service;

import web.dao.UserDao;
import web.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void saveOrUpdateUser(Long id, String name, String email, int age) {
        User user;
        if (id != null) {
            user = userDao.getUserById(id);
            user.setName(name);
            user.setEmail(email);
            user.setAge(age);
            userDao.updateUser(user);
        } else {
            user = new User(name, email, age);
            userDao.saveUser(user);
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}