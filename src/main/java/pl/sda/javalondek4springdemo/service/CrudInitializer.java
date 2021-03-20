package pl.sda.javalondek4springdemo.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sda.javalondek4springdemo.model.Address;
import pl.sda.javalondek4springdemo.model.Course;
import pl.sda.javalondek4springdemo.model.Teacher;
import pl.sda.javalondek4springdemo.repository.CourseRepository;
import pl.sda.javalondek4springdemo.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CrudInitializer implements CommandLineRunner {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public CrudInitializer(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Teacher mariusz = new Teacher();
        mariusz.setAddress(new Address("warszawa", "polna", 328938L));
        Course java = new Course("Java od podstaw", mariusz);
        List<Course> courseList = new ArrayList<>();
        courseList.add(java);
        mariusz.setCourseList(courseList);
        Teacher save = teacherRepository.save(mariusz);
        //  courseRepository.save(java);
        System.out.println(save
        );
    }
}
