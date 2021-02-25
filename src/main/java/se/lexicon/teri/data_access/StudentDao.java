package se.lexicon.teri.data_access;

import se.lexicon.teri.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    Student save(Student student);

    Optional<Student> find(int id);

    List<Student> findAll();

    void delete(int id);
}
