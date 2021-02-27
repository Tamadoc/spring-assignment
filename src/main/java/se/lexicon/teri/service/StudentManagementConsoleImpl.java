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
        String saveRequest = inputService.getString();

        if (saveRequest.equalsIgnoreCase("y")) {
            student = save(student);
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
        Student student = studentDao.find(id);

        if (student == null) {
            System.out.println("Student with id " + id + " not found");
        }

        return student;
    }

    @Override
    public Student remove(int id) {
        Student student = find(id);

        if (student != null) {
            studentDao.delete(id);
        }

        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        Student foundStudent = null;
        if (student != null) {
            foundStudent = studentDao.find(student.getId());
        } else {
            System.out.println("Student cannot be null");
        }

        if (foundStudent != null) {
            System.out.print("Edit student - enter new name: ");
            String name = inputService.getString();

            System.out.println("Editing Student...");
            foundStudent.setName(name);
        }

        return foundStudent;
    }
}
