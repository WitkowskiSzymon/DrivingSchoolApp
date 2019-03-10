package pl.drivingschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.drivingschool.entity.Activities;

public interface ActivitiesRepository extends JpaRepository<Activities, Long> {

    Activities findActivitiesById(Long id);
}
