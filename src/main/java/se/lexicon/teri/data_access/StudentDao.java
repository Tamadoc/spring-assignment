package se.lexicon.teri.data_access;

import se.lexicon.teri.models.Student;

import java.util.List;

public interface StudentDao {

    Student save(Student student);

    Student find(int id);

    List<Student> findAll();

    void delete(int id);
}
