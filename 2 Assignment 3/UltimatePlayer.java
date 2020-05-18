/*
 * Ryan Lutz
 * 10/14/19
 * M2A3
 */
public class UltimatePlayer extends Person {
    private int jerseyNumber; // Declare vars
    private String position;
    private static int num;

    public UltimatePlayer(String fName, String lName, String pos) { // Constructor
        super(fName, lName); // Call Person constructor
        position = "handler"; // Set vars to appropriate vals
        if (pos == "cutter") {
            position = "cutter";
        }
        num++;
        jerseyNumber = num;
    }

    public String getPosition() { // Get player's position
        return position; // Return position
    }

    public String toString() { // To String
        return super.toString() + "\n   Jersey #: " + jerseyNumber + "\n   Position: " + position; // Return formatted string
    }
}