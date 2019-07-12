package domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<GradeType> grades;

    public Subject() {
        grades = new ArrayList<GradeType>();
    }

    public String getName() {
        return getClass().getSimpleName();
    }

    public List<GradeType> getGrades() {
        return grades;
    }

    public void addGrade(GradeType grade) {
        grades.add(grade);
    }
}
