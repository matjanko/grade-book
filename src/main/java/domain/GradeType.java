package domain;

public enum GradeType {
    UNSATISFACTORY(1),
    POOR(2),
    SATISFACTORY(3),
    GOOD(4),
    VERY_GOOD(5),
    EXCELLENT(6);

    private int numberValue;

    GradeType(int numberValue) {
        this.numberValue = numberValue;
    }

    public int getNumberValue() {
        return numberValue;
    }
}
