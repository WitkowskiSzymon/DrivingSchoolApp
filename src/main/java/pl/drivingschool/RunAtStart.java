package pl.drivingschool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.drivingschool.entity.Role;
import pl.drivingschool.entity.User;
import pl.drivingschool.repository.RoleRepository;
import pl.drivingschool.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class RunAtStart {


    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Autowired
    public RunAtStart(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

   @PostConstruct
    public void runAtStart(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User user1 =new User();
        User user2 = new User();

        user1.setName("Szymon");
        user1.setLastName("Witkowski");
        user1.setEmail("szymonwit1988@gmail.com");
        user1.setPassword(bCryptPasswordEncoder.encode("Haslo12"));
        user1.setCreated(LocalDate.of(2019,03,07));
        user1.setUserName("simon88");
        user1.setFullName("Szymon witkowski");
        user1.setActive(true);

        user2.setName("Adam");
        user2.setLastName("Kowal");
        user2.setEmail("a.kowal1@gmail.com");
        user2.setPassword(bCryptPasswordEncoder.encode("Haslo22"));
        user2.setCreated(LocalDate.of(2019,03,06));
        user2.setUserName("kowala22");
        user2.setFullName("Adam Kowal1");
        user2.setActive(true);

        Role role1 = new Role();
        Role role2 = new Role();

        role1.setRole("ROLE_ADMIN");
        role2.setRole("ROLE_USER");

        roleRepository.save(role1);
        roleRepository.save(role2);

        user1.getRoles().add(role1);
        user1.getRoles().add(role2);

        user2.getRoles().add(role2);

        userRepository.save(user1);
        userRepository.save(user2);




    }

}
