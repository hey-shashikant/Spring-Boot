package com.example.demo;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("creating new student object...");
        Student student = new Student("Shashikant", "Solanki", "cyborg93033@gmail.com" );

        // save the student object
        System.out.printf("Saving the student object....");
        studentDAO.save(student);

        // display id of the saved student
        System.out.println("Saved student .. Generated id - " + student.getId());
    }

}
