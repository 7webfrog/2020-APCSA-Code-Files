/*
 * Ryan Lutz
 * 10/14/19
 * M2A3
 */
import java.util.ArrayList;

public class UltimateTeam {
    private ArrayList<UltimatePlayer> players; // Declare ArrayLists
    private ArrayList<Coach> coaches;

    public UltimateTeam(ArrayList<UltimatePlayer> p, ArrayList<Coach> c) { // Constructor
        players = p; // Set ArrayLists to passed ArrayLists
        coaches = c;
    }

    public String getCutters() { // Get the cutters on the team
        String out = ""; // Declare a string for output
        for (UltimatePlayer e: players) { // For each UltimatePlayer e in players
            if (e.getPosition().equals("cutter")) { // If they are a cutter
                out += e + "\n"; // Add their name and info to the output string
            }
        }
        return out; // Return output string
    }

    public String getHandlers() { // Get the handlers on the team
        String out = ""; // Declare a string for output
        for (UltimatePlayer e: players) { // For each UltimatePlayer e in players
            if (e.getPosition().equals("handler")) { // If they are a handler
                out += e + "\n"; // Add their name and info to the output string
            }
        }
        return out; // Return output string
    }

    public String toString() { // To String
        String out = "COACHES\n"; // Declare and initialize output string
        for (Coach e: coaches) { // For each Coach e in coaches
            out += e + "\n"; // Add their name and info to the output string
        }
        out += "\nPLAYERS\n"; // Add the PLAYERS heading to the string
        for (UltimatePlayer e: players) { // For each UltimatePlayer e in players
            out += e + "\n"; // Add their name and info to the output string
        }
        return out; // Return output string
    }
}