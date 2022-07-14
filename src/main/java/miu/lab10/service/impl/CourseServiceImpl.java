package miu.lab10.service.impl;

import miu.lab10.model.Course;
import miu.lab10.repository.CourseRepository;
import miu.lab10.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
