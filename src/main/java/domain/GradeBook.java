package domain;

import java.util.List;

public interface GradeBook {
    void addSubject(Subject subject);
    void addGrade(Subject subject, GradeType gradeType);
    double calculateAverage(Subject subject);
    double calculateGradeBookAverage();
    List<Subject> getSubjects();
}
