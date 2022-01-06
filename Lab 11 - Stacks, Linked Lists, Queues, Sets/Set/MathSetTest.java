package Set;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class MathSetTest {

    @Test
    public void testIntersection(){
        Set<Integer> setA = new TreeSet<>();
        Set<Integer> setB = new TreeSet<>();
        Set<Integer> intersection = new TreeSet<>();
        for(int x = 0; x < 10; x++){
            setA.add(x);
        }
        for(int x = 0; x < 10; x++){
            setB.add(x);
            x++;
        }
        for(int x = 0; x < 10; x++){
            intersection.add(x);
            x++;
        }
        assertEquals(intersection, MathSet.intersection(setA, setB));
        setA.remove(2);
        intersection.remove(2);
        assertEquals(intersection, MathSet.intersection(setA, setB));
        setB.remove(4);
        intersection.remove(4);
        assertEquals(intersection, MathSet.intersection(setA, setB));
    }

    @Test
    public void testComplement(){
        Set<Integer> setA = new TreeSet<>();
        Set<Integer> setB = new TreeSet<>();
        Set<Integer> complement = new TreeSet<>();
        for(int x = 4; x < 16; x++){
            setA.add(x);
        }
        for(int x = 0; x < 10; x++){
            setB.add(x);
        }
        for(int x = 0; x < 4; x++){
            complement.add(x);
        }
        assertEquals(complement, MathSet.complement(setA, setB));
        setB.remove(0);
        complement.remove(0);
        assertEquals(complement, MathSet.complement(setA, setB));
    }

    @Test
    public void testUnion(){
        Set<Integer> setA = new TreeSet<>();
        Set<Integer> setB = new TreeSet<>();
        Set<Integer> union = new TreeSet<>();
        for(int x = 0; x < 5; x++){
            setA.add(x);
        }
        for(int x = 4; x < 13; x++){
            setB.add(x);
        }
        for(int x = 0; x < 13; x++){
            union.add(x);
        }
        assertEquals(union, MathSet.union(setA, setB));
        setA.remove(0);
        setB.remove(12);
        union.remove(0);
        union.remove(12);
        assertEquals(union, MathSet.union(setA, setB));
    }


}
