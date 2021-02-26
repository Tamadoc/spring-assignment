package se.lexicon.teri;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.teri.config.ComponentScanConfig;
import se.lexicon.teri.models.Student;
import se.lexicon.teri.service.StudentManagement;

public class App {
    public static void main(String[] args) {

        // Load the Spring configuration file/class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        // Retrieve bean from the Spring container
        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        // Call test methods on the bean
        Student student = studentManagement.create();
        System.out.println(student.toString());
        studentManagement.save(student);

        // Close the context
        context.close();
    }
}
