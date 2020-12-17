package it.academy;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestClassTest {

    @Test
    public void testClassTest() {
        List<Integer> list = Arrays.asList(10, 10, 10, 10, 10);
        double actual = TestClass.average(list);
        double expected = 10;
        assertEquals(expected, actual, 1e-2);
    }

}
