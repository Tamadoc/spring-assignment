package se.lexicon.teri.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.teri.data_access.sequencers.StudentSequencer;
import se.lexicon.teri.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("studentDao")
public class StudentDaoListImpl implements StudentDao {

    private final List<Student> students;

    public StudentDaoListImpl() {
        students = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        Student savedStudent;

        if (student.getId() == 0) {
            student.setId(StudentSequencer.nextStudentId());
            students.add(student);
            savedStudent = student;
        } else {
            Optional<Student> original = find(student.getId());
            original.ifPresent(name -> name.setName(student.getName()));
            savedStudent = original.orElse(null);
        }

        return savedStudent;
    }

    @Override
    public Optional<Student> find(int id) {
        if (id == 0) throw new IllegalArgumentException("Id should not be null");

        return students.stream().filter(student -> student.getId() == id).findFirst();
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
