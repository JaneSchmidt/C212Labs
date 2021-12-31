import java.util.*;

public class Person {
    private String firstName;
    private String lastName;
    private String birthdate;

    public Person(String firstName, String lastName, String birthdate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }
    public Person() {
        String firstName = "";
        String lastName = "";
        String birthdate = "";
    }

    public void setFirstName(String fName){this.firstName = fName;}
    public void setLastName(String lName){this.lastName = lName;}
    public void setBirthdate(String bDate){this.birthdate = bDate;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getBirthdate(){return birthdate;}


// Animal dog = new Doggo
// package interfaceslearning;
// public interface Polygon
// if there is common logic between all children
// then use an abstract class
// ex all animals have a number of legs
// @Override : tells them you're overriding something from the parent class
// interface -> what a class has to have
// abstract -> what a class has to be
// super : is a reference variable that is used to refer to parent class objects

// missing C class
// MIT
}
