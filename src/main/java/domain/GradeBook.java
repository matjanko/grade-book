package domain;

import java.util.List;

public interface GradeBook {
    void addSubject(Subject subject);
    void addGrade(Subject subject, GradeType gradeType);
    double CalculateAverage(Subject subject);
    double CalculateGradeBookAverage();
    List<Subject> getSubjects();
}
