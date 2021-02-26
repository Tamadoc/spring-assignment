package se.lexicon.teri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.teri.data_access.StudentDao;
import se.lexicon.teri.models.Student;
import se.lexicon.teri.util.UserInputService;

import java.util.List;

@Component("studentManagementConsole")
public class StudentManagementConsoleImpl implements StudentManagement {

    // Inject dependencies with @Autowired fields
    @Autowired
    private UserInputService inputService;

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student create() {
        System.out.print("Enter name of student: ");
        String name = inputService.getString();

        System.out.println("Creating Student...");
        Student student = new Student(name);

        System.out.print("Save student Y/N: ");
        String saveStudent = inputService.getString();
        if (saveStudent.equalsIgnoreCase("y")) {
            save(student);
        } else {
            student = null;
        }
        return student;
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return null;
    }

    @Override
    public Student remove(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        // Use StudentDao to find all students. Make use of dependency in app
        return null;
    }

    @Override
    public Student edit(Student student) {
        return null;
    }
}
