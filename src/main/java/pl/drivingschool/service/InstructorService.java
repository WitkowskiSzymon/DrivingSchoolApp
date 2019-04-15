package pl.drivingschool.service;

import pl.drivingschool.entity.Instructor;

import java.util.List;

public interface InstructorService {

    public Instructor createInstructor(Instructor instructor);

    public Instructor findInstructorForUpdate(Long id);

    public Instructor updateInstructor(Long id, Instructor instructor);

    public List<Instructor> findInstructors();

    public void deleteInstructor(Long id);
}
