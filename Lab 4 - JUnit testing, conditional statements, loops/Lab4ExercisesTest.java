import org.junit.Test;

import static org.junit.Assert.*;

public class Lab4ExercisesTest {

    @Test
    public void testExponentCalculator() {
        Lab4Exercises test = new Lab4Exercises();
        assertEquals(25, Lab4Exercises.exponentCalculator(5, 2));
        assertEquals(1, Lab4Exercises.exponentCalculator(5, 0));
        assertThrows(IllegalArgumentException.class, () -> Lab4Exercises.exponentCalculator(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> Lab4Exercises.exponentCalculator(2, -1));
        assertThrows(IllegalArgumentException.class, () -> Lab4Exercises.exponentCalculator(0, 0));
    }

    @Test
    public void testPrintPounds() {
        assertEquals("###\n###\n###\n###\n###\n###\n###\n###\n###\n###\n", Lab4Exercises.printPounds(3, 10));
        assertThrows(IllegalArgumentException.class, () -> Lab4Exercises.printPounds(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> Lab4Exercises.printPounds(0, 10));
        assertThrows(IllegalArgumentException.class, () -> Lab4Exercises.printPounds(2, -2));
    }
}