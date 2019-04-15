package pl.drivingschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.drivingschool.entity.Activities;
import pl.drivingschool.entity.Role;
import pl.drivingschool.entity.User;
import pl.drivingschool.repository.ActivitiesRepository;
import pl.drivingschool.repository.RoleRepository;
import pl.drivingschool.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ActivitiesRepository activitiesRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user, Activities activities) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setActive(true);
        Role role_user = roleRepository.findByRole("ROLE_USER");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.getRoles().add(role_user);
        userRepository.save(user);

        activitiesRepository.save(activities);
        user.setEnabled(1);
    }

    @Override
    public User validateUser(User user, String email) {
        return userRepository.findByEmail(user.getEmail());
    }

    @Override
    public User findUserForUpdate(Long id) {

        return userRepository.findUserById(id);
    }

    @Override
    public User updateUser(Long id, User user){

        return userRepository.save(user);
    }

    @Override
    public List<User> findUsers() {

        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);

    }
}
