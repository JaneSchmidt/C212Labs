package Set;

import java.util.*;

public class MathSet {

    public static Set<Integer> intersection(Set<Integer> setA, Set<Integer> setB){
        Set<Integer> result = new HashSet<>();
        for(int x : setA){
            if(setB.contains(x)){
                result.add(x);
            }
        }
        return result;
    }

    public static Set<Integer> union(Set<Integer> setA, Set<Integer> setB){
        Set<Integer> result = new TreeSet<>();
        result.addAll(setA);
        result.addAll(setB);
        return result;

    }

    public static Set<Integer> complement(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> temp = new HashSet<>(setB);
        for (int y : temp) {
            if (setA.contains(y)) {
                setB.remove(y);
            }
        }
        return setB;
    }

    public static void main(String[] args){
        Set<Integer> setA = new TreeSet<>();
        Set<Integer> setB = new TreeSet<>();
        for(int x = 5; x < 16; x++){
            setA.add(x);
        }
        for(int x = 0; x < 10; x++){
            setB.add(x);
        }
        System.out.println(setA);
        System.out.println(setB);

        Set<Integer> resultI = intersection(setA, setB);
        Set<Integer> resultU = union(setA, setB);
        Set<Integer> resultC = complement(setA, setB);

        System.out.println("intersection: " + resultI);
        System.out.println("union: " + resultU);
        System.out.println("complement: " + resultC);


    }
}
