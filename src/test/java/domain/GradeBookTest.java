package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
}
