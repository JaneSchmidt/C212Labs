import org.junit.Test;

import static org.junit.Assert.*;

public class Lab3ExercisesTest {

    @Test
    public void pigLatinEncoder() {
        Lab3Exercises etest = new Lab3Exercises();
        assertEquals( "ane-Jay is-way eat-gray", etest.pigLatinEncoder("Jane is great"));
        assertEquals( "Everything-way", etest.pigLatinEncoder("Everything"));
        assertEquals( "I-way ove-lay oding-cay", etest.pigLatinEncoder("I love coding"));
    }

    @Test
    public void pigLatinDecoder() {
        Lab3Exercises dtest = new Lab3Exercises();
        assertEquals( "Jane (is/wis) great", dtest.pigLatinDecoder("ane-Jay is-way eat-gray"));
        assertEquals( "come (on/won)", dtest.pigLatinDecoder("ome-cay on-way"));
        assertEquals( "love coding", dtest.pigLatinDecoder("ove-lay oding-cay"));
    }

    @Test
    public void hexToIntNBin() {
        Lab3Exercises hextest = new Lab3Exercises();
        assertEquals( "Your number is 10 (in decimal) and 1010 (in binary).", hextest.hexToIntNBin("0x000A"));
        assertEquals( "Your number is 9198 (in decimal) and 10001111101110 (in binary).", hextest.hexToIntNBin("0x23EE"));
        assertEquals( "Your number is 57390 (in decimal) and 1110000000101110 (in binary).", hextest.hexToIntNBin("0xE02E"));
    }
}