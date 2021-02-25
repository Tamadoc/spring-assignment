package se.lexicon.teri.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.teri.models.Student;
import se.lexicon.teri.data_access.sequencers.StudentSequencer;

import java.util.List;
import java.util.Optional;

@Component("studentDao")
public class StudentDaoListImpl implements StudentDao {

    List<Student> students;

    @Override
    public Student save(Student student) {
        if (student.getId() == 0) {
            student.setId(StudentSequencer.nextStudentId());
            students.add(student);
        } else {
            Optional<Student> original = find(student.getId());
            original.ifPresent(name -> name.setName(student.getName()));
        }
        return student;
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
