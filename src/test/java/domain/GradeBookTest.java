package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GradeBookTest {
    GradeBook gradeBook;

    @Before
    public void before() {

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
}
