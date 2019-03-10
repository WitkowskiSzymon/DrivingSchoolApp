package pl.drivingschool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.drivingschool.entity.Participant;
import pl.drivingschool.entity.Role;
import pl.drivingschool.repository.ParticipantRepository;
import pl.drivingschool.repository.RoleRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class RunAtStart {


    private ParticipantRepository participantRepository;

    private RoleRepository roleRepository;

    @Autowired
    public RunAtStart(ParticipantRepository participantRepository, RoleRepository roleRepository) {
        this.participantRepository = participantRepository;
        this.roleRepository = roleRepository;
    }

//    @PostConstruct
    public void runAtStart(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        Participant part1 =new Participant();
        Participant part2 = new Participant();

        part1.setFirstName("Adam");
        part1.setLastName("Kowal");
        part1.setEmail("a.kowal@gmail.com");
        part1.setPassword(bCryptPasswordEncoder.encode("Haslo12"));
        part1.setCreated(LocalDate.of(2019,03,07));
        part1.setParticipantName("kowala12");
        part1.setFullName("Adam Kowal");
        part1.setActive(true);

        part2.setFirstName("Adam1");
        part2.setLastName("Kowal1");
        part2.setEmail("a.kowal1@gmail.com");
        part2.setPassword(bCryptPasswordEncoder.encode("Haslo22"));
        part2.setCreated(LocalDate.of(2019,03,06));
        part2.setParticipantName("kowala22");
        part2.setFullName("Adam Kowal1");
        part2.setActive(true);

        Role role1 = new Role();
        Role role2 = new Role();

        role1.setRole("ROLE_ADMIN");
        role2.setRole("ROLE_USER");

        roleRepository.save(role1);
        roleRepository.save(role2);

        part1.getRoles().add(role1);
        part1.getRoles().add(role2);

        part2.getRoles().add(role2);

        participantRepository.save(part1);
        participantRepository.save(part2);




    }

}
