import domain.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import domain.subjects.Biology;
import domain.subjects.Mathematics;
import domain.subjects.Subject;

public class GradeBookTest {
    GradeBook gradeBook;

    @Before
    public void before() {
        gradeBook = new GradeBookImp();
    }

    @Test
    public void addSubjectTest() {
        // given
        Subject subject = Mockito.mock(Subject.class);

        // when
        gradeBook.addSubject(subject);

        // then
        Assert.assertTrue(gradeBook.getSubjects().contains(subject));
    }

    @Test (expected = NullPointerException.class)
    public void addSubjectWhenSubjectIsNullTest() {
        // when
        gradeBook.addSubject(null);

        // then
        // throw exception
    }

    @Test (expected = IllegalArgumentException.class)
    public void addSubjectExistingInGradeBookTest() {
        // given
        Subject subject = Mockito.mock(Subject.class);
        gradeBook.addSubject(subject);

        // when
        gradeBook.addSubject(subject);

        // then
        // throw exception
    }

    @Test (expected = NullPointerException.class)
    public void addGradeAndSubjectIsNullGradeBookTest() {
        // when
        gradeBook.addGrade(null, GradeType.GOOD);

        // then
        // throw exception
    }

    @Test (expected = IllegalArgumentException.class)
    public void addGradeAndSubjectNotExistInGradeBookTest() {
        // given
        Subject subject = Mockito.mock(Subject.class);

        // when
        gradeBook.addGrade(subject, GradeType.GOOD);

        // then
        // throw exception
    }

    @Test
    public void addGradeTest() {
        // given
        Subject subject = Mockito.spy(new Mathematics());
        gradeBook.addSubject(subject);

        // when
        gradeBook.addGrade(subject, GradeType.GOOD);
        int expectedGrade = gradeBook.getSubjects().get(0).getGrades().get(0).getNumberValue();

        // then
        Assert.assertEquals(4, expectedGrade);
    }

    @Test
    public void calculateAverageTest() {
        // given
        Subject subject = Mockito.spy(new Mathematics());
        gradeBook.addSubject(subject);
        gradeBook.addGrade(subject, GradeType.GOOD);
        gradeBook.addGrade(subject, GradeType.EXCELLENT);
        gradeBook.addGrade(subject, GradeType.POOR);
        gradeBook.addGrade(subject, GradeType.UNSATISFACTORY);

        // when
        double expectedAverage = gradeBook.calculateAverage(subject);

        // then
        Assert.assertEquals(3.25, expectedAverage, 0);
    }

    @Test
    public void calculateGradeBookAverageTest() {
        // given
        Subject math = Mockito.spy(new Mathematics());
        Subject biology = Mockito.spy(new Biology());
        gradeBook.addSubject(math);
        gradeBook.addSubject(biology);
        gradeBook.addGrade(math, GradeType.GOOD);
        gradeBook.addGrade(math, GradeType.EXCELLENT);
        gradeBook.addGrade(biology, GradeType.POOR);
        gradeBook.addGrade(biology, GradeType.UNSATISFACTORY);

        // when
        double expectedAverage = gradeBook.calculateGradeBookAverage();

        // then
        Assert.assertEquals(3.25, expectedAverage, 0);
    }
}
