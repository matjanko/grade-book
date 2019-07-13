package domain;

import java.util.ArrayList;
import java.util.List;

public class GradeBookImp implements GradeBook {
    private List<Subject> subjects;

    public GradeBookImp() {
        subjects = new ArrayList<Subject>();
    }

    public void addSubject(Subject subject) {
        if (subject == null)
            throw new NullPointerException("Cannot add undefined subject.");
        if (subjects.contains(subject))
            throw new IllegalArgumentException("The subject already exist in the grade book.");

        subjects.add(subject);
    }

    public void addGrade(Subject subject, GradeType gradeType) {
        if (subject == null)
            throw new NullPointerException("Cannot add grade to undefined subject.");
        if (!subjects.contains(subject))
            throw new IllegalArgumentException("The subject doesn't exist in grade book.");

        int subjectIndex = subjects.indexOf(subject);
        subjects.get(subjectIndex).addGrade(gradeType);
    }

    public double calculateAverage(Subject subject) {
        double gradesSum = 0;
        for(GradeType grade: subject.getGrades())
            gradesSum += grade.getNumberValue();

        return gradesSum / subject.getGrades().size();
    }

    public double calculateGradeBookAverage() {
        return 0;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

}
