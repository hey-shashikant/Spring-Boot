package com.example.demo;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication()
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            createMultipleStudent(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numberOfRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted " + numberOfRowsDeleted + " students");
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrive student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student with Id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // change first name to "Prashansa"
        System.out.println("Updating student with Id: " + studentId);
        myStudent.setFirstName("Prashansa");

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("Updated Student " + myStudent);
    }

    private void queryByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> students = studentDAO.findByLastName("Solanki");

        // display a list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {

        // get a list of students
        List<Student> students = studentDAO.findAll();

        // display list of students
        for (Student student : students) {
            System.out.println(student);
        }

    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating new student object...");
        Student student = new Student("Preeti", "Solanki", "solankipreeti@gmail.com");

        // save the student
        System.out.println("Saving student object...");
        studentDAO.save(student);

        // display id of the saved student
        int theId = student.getId();
        System.out.println("Saved student object Generated Id..." + theId);

        // retrieve student based on the id: primary key
        System.out.println("Reading student object with given id..." + theId);
        Student readStudent = studentDAO.findById(theId);

        // display student
        System.out.printf("My Student...");
        System.out.println("Reading student object with given id..." + readStudent);

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
