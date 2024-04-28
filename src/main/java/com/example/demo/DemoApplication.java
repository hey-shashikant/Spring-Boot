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
            createMultipleStudent(studentDAO);
        };
    }

    private void createMultipleStudent(StudentDAO studentDAO) {

        // create the student object
        Student student1 = new Student("Shashikant", "Solanki", "cyborg93033@gmail.com" );
        Student student2 = new Student("Chirag", "Madan", "chirubhaiya@gmail.com" );
        Student student3 = new Student("Garv", "Pratap", "garvpratapsingh.gps@gmail.com" );

        // save the student object
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

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
