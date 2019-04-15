package pl.drivingschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.drivingschool.entity.Activities;
import pl.drivingschool.repository.ActivitiesRepository;

import java.util.List;

@Service
public class ActivitiesServiceImpl implements ActivitiesService {

    @Autowired
    ActivitiesRepository activitiesRepository;


    @Override
    public void createActivity(Activities activities) {

        activitiesRepository.save(activities);
    }


    @Override
    public Activities findActivitiesForUpdate(Long id) {

        return activitiesRepository.findActivitiesById(id);
    }

    @Override
    public Activities updateActivities(Long id, Activities activities) {

        return activitiesRepository.save(activities);
    }

    @Override
    public List<Activities> findActivities() {

        return activitiesRepository.findAll();
    }

    @Override
    public void deleteActivity(Long id) {

        activitiesRepository.deleteById(id);
    }
}
