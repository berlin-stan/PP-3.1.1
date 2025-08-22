package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    void saveOrUpdateUser(Long id, String name, String email, int age);
    void deleteUser(Long id);
    User getUserById(Long id);
    List<User> getAllUsers();
}