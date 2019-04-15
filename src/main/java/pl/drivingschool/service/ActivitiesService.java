package pl.drivingschool.service;

import pl.drivingschool.entity.Activities;

import java.util.List;

public interface ActivitiesService {

    public void createActivity(Activities activities);

    public Activities findActivitiesForUpdate(Long id);

    public Activities updateActivities(Long id, Activities activities);

    public List<Activities> findActivities();

    public void deleteActivity(Long id);
}
