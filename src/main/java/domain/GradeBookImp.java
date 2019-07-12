package domain;

import java.util.ArrayList;
import java.util.List;

public class GradeBookImp implements GradeBook {
    private List<Subject> subjects;

    public void addSubject(Subject subject) {
        if (subjects == null)
            subjects = new ArrayList<Subject>();

        subjects.add(subject);
    }

    public void addGrade(Subject subject, GradeType gradeType) {

    }

    public double CalculateAverage(Subject subject) {
        return 0;
    }

    public double CalculateGradeBookAverage() {
        return 0;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
