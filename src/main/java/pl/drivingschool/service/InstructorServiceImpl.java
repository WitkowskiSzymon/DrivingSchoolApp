package pl.drivingschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.drivingschool.entity.Instructor;
import pl.drivingschool.repository.InstructorRepository;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {


    @Autowired
    InstructorRepository instructorRepository;

    @Override
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor findInstructorForUpdate(Long id) {

        return instructorRepository.findInstructorById(id);
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) {

        return instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> findInstructors() {

        return instructorRepository.findAll();
    }

    @Override
    public void deleteInstructor(Long id) {

        instructorRepository.deleteById(id);
    }
}
