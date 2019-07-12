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
        Subject subject = Mockito.mock(Mathematics.class);

        // when
        gradeBook.addSubject(subject);

        // then
        Assert.assertTrue(gradeBook.getSubjects().contains(subject));
    }

    @Test (expected = NullPointerException.class)
    public void addGradeSubjectNotExistInGradeBookTest() {
        // given
        Subject subject = Mockito.mock(Mathematics.class);

        // when
        gradeBook.addGrade(subject, GradeType.GOOD);

        // then
        // throw exception
    }

    @Test
    public void addGradeSubjectExistInGradeBookTest() {
        // given
        Subject subject = Mockito.mock(Mathematics.class);

        // when
        gradeBook.addGrade(subject, GradeType.GOOD);

        // then
        Assert.assertEquals(subject.getGrades().get(0), GradeType.GOOD);
    }
}
