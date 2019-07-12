package domain;

public interface GradeBook {
    void addSubject(Subject subject);
    void addGrade(Subject subject, GradeType gradeType);
    double CalculateAverage(Subject subject);
    double CalculateGradeBookAverage();
}
