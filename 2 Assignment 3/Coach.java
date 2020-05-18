/*
 * Ryan Lutz
 * 10/14/19
 * M2A3
 */
public class Coach extends Person {
    private String role; // Declare var

    public Coach(String fName, String lName, String r) { // Constructor
        super(fName, lName); // Call Person constructor
        role = r; // Set var to appropriate val
    }

    public String toString() { // To String
        return super.toString() + "\n   Role: " + role; // Return formatted string
    }
}