package se.lexicon.teri.data_access.sequencers;

public class StudentSequencer {

    private static int studentSequencer;

    public static int nextStudentId() {
        return ++studentSequencer;
    }

    public static int getStudentIdSequencer() {
        return studentSequencer;
    }
}
