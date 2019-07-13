package domain.subjects;

import domain.GradeType;
import java.util.LinkedList;
import java.util.List;

public abstract class Subject {
    private List<GradeType> grades;

    public void addGrade(GradeType grade) {
        if (grades == null)
            grades = new LinkedList<GradeType>();

        grades.add(grade);
    }

    public List<GradeType> getGrades() {
        return grades;
    }

    public String getName() {
        return getClass().getSimpleName();
    }

    public double calculateAverage() {
        double sum = 0;
        for(GradeType grade: grades)
            sum += grade.getNumberValue();

        return sum / grades.size();
    }
}
