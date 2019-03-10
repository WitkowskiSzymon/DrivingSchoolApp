package pl.drivingschool.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.drivingschool.repository.ActivitiesRepository;

public class ActivitiesConverter implements Converter<String, Long> {

    @Autowired
    ActivitiesRepository activitiesRepository;

    @Override
    public Long convert(String s) {

        return Long.parseLong(s);



    }
}
