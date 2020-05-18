/*
 * Ryan Lutz
 * 10/14/19
 * M2A3
 */
public class Captain extends UltimatePlayer {
    private boolean type; // Declare var
    
    public Captain(String fName, String lName, String pos, boolean t) { // Constructor
        super(fName, lName, pos); // Call UltimatePlayer constructor
        type = t; // Set var to appropriate val
    }

    public String toString() { // To String
        String out; // Declare a string for captain position
        if (type) { // If offense
            out = "offense";
        } else { // If defense
            out = "defense";
        }
        return super.toString() + "\n   Captain: " + out; // Return formatted string
    }
}