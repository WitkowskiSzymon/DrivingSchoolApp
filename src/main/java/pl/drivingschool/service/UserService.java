package pl.drivingschool.service;

import pl.drivingschool.entity.Activities;
import pl.drivingschool.entity.User;

import java.util.List;

public interface UserService {

    public void createUser(User user, Activities activities);

    public User validateUser (User user, String email);

    public User findUserForUpdate(Long id);

    public User updateUser(Long id, User user);

    public List<User> findUsers();

    public void deleteUser(Long id);
}
