package web.service;

import web.model.User;

import java.util.List;


public interface UserService {

    void createUsersTable();


    void createUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);

    boolean deleteUser(long id);

    User getUserById(long id);
}
