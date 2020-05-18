/*
 * Ryan Lutz
 * 10/14/19
 * M2A3
 */
public class Person {
    private String firstName; // Declare vars
    private String lastName;

    public Person(String fName, String lName) { // Constructor
        firstName = fName; // Set vars to appropriate vals
        lastName = lName;
    }
    public String toString() { // To String
        return lastName +", " + firstName; // Return formatted string
    }
}