package it.academy;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestClassTest {

    @Test
    public void testClassTest() {
        List<Integer> list = Arrays.asList(1, 2,null, null);
        double actual = TestClass.average(list);
        double expected = 1.5;
        assertEquals(expected, actual, 0);
    }

}
