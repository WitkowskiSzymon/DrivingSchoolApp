package pl.drivingschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.drivingschool.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findByUserName(String userName);

    User findByEmail(String email);
}
