package pl.drivingschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.drivingschool.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    Participant findParticipantById(Long id);



    Participant findByParticipantName(String participantName);

    Participant findByEmail(String email);
}
