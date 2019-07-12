package domain;

import java.util.List;

public class Mathematics implements Subject {

    public String getName() {
        return getClass().getSimpleName();
    }

    public List<GradeType> getGrades() {
        return null;
    }
}
