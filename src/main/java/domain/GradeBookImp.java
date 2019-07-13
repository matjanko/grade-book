package domain;

import domain.subjects.Subject;
import java.util.LinkedList;
import java.util.List;

public class GradeBookImp implements GradeBook {
    private List<Subject> subjects;

    public void addSubject(Subject subject) {
        if (subject == null)
            throw new NullPointerException("Cannot add undefined subject.");
        if (subjects == null)
            subjects = new LinkedList<Subject>();
        if (subjects.contains(subject))
            throw new IllegalArgumentException("The subject already exist in the grade book.");

        subjects.add(subject);
    }

    public void addGrade(Subject subject, GradeType gradeType) {
        if (subject == null)
            throw new NullPointerException("Cannot add grade to undefined subject.");
        if (!subjects.contains(subject))
            throw new IllegalArgumentException("The subject doesn't exist in grade book.");

        subjects.get(subjects.indexOf(subject)).addGrade(gradeType);
    }

    public double calculateAverage(Subject subject) {
        return subjects.get(subjects.indexOf(subject)).calculateAverage();
    }

    public double calculateGradeBookAverage() {
        double gradeSum = 0;
        for (Subject subject : subjects)
            gradeSum += calculateAverage(subject);

        return gradeSum / subjects.size();
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

}
