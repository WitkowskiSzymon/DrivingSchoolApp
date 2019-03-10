package pl.drivingschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.drivingschool.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    Instructor findInstructorById(Long id);
}
