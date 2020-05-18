/*
 * AP CS MOOC
 * Term 2 - Assignment 2, Part 2: FreightTrain
 * A class which represents a freight train with multiple boxcars.
 * 
 * Ryan Lutz
 * 10/9/19
 * M2A2
 */

import java.util.ArrayList;

public class FreightTrain
{
    // An ArrayList that stores a train with multiple boxcars
    private ArrayList<Boxcar> train = new ArrayList<Boxcar>();

    // Default constructor that sets train to an ArrayList holding one
    // boxcar containing 5 gizmos, that is not in repair.
    public FreightTrain()
    {
        this(1); // Call this with param of 1
    }

    // A constructor that sets train to an ArrayList of size n, holding
    // n boxcars, that are all hold 5 gizmos and are not in repair. If n <= 0,
    // then the train should be set to size one, with a single boxcar containing
    // 5 gizmos and not in repair.
    public FreightTrain(int n)
    {
        if (n <= 0) { // if n is negative or 0
            n = 1; // Set n to 1
        }
        for (int i=0; i<n; i++) { // For every number between i and n
            train.add(new Boxcar()); // Create a new Boxcar and add it to the list train
        }
    }

    // This method returns a String representation of the
    // Boxcar objects in the ArrayList, one per line. For example,
    // here is the String returned when toString is called on a
    // FreightTrain with 5 boxcars:
    //
    // 3 gadgets    in service
    // 2 wadgets    in service
    // 0 gizmos    in repair
    // 7 gadgets    in service
    // 0 gadgets    in repair
    //
    // Note: there is one space between the number of units and
    // the cargo type, and a tab between the cargo type and
    // "in repair"/"in service".
    public String toString()
    {
        String out = ""; // Output string
        for (Boxcar e: train) { // For each boxcar in train
            out += e+"\n"; // Add e to output, then newline
        }
        return out; // Return output string
    }

    // This method sets the cargo type of all the boxcars in the entire train.
    public void setCargo(String c)
    {
        for (Boxcar e: train) { // For each boxcar in train
            e.setCargo(c); // Set cargo to c
        }
    }

    // This method sets the boxcars to the pattern "gizmos", "gadgets", "widgets",
    // "wadgets", "gizmos", "gadgets", "widgets", "wadgets", ...
    // until the end of the train.
    public void setMultiCargo()
    {
        for (int i=0; i<train.size(); i++) { // For each boxcar in train
            Boxcar currCar = train.get(i); // currCar is the current car
            switch (i%4) { // Switch on i mod 4
                case 0: // i%4 == 0
                    currCar.setCargo("gizmos"); // Set cargo to gizmos
                    break;
                case 1: // i%4 == 1
                    currCar.setCargo("gadgets"); // Set cargo to gadgets
                    break;
                case 2: // i%4 == 2
                    currCar.setCargo("widgets"); // Set cargo to widgets
                    break;
                case 3: // i%4 == 3
                    currCar.setCargo("wadgets"); // Set cargo to wadgets
                    break;
            }
        }
    }

    // This method fills every boxcar in the train to max capacity of 10.
    // Each individual boxcar can only hold cargo if its
    // repair variable is false.
    public void fillTrain()
    {
        for (Boxcar e: train) { // For each boxcar in train
            if (e.toString().contains("in service")) { // If e is in service
                while (!e.isFull()) { // While e is not full
                    e.loadCargo(); // Add cargo to e
                }
            }
        }
    }

    // This method sets the Boxcar at location i’s repair variable to true.
    public void callForRepair(int i)
    {
        train.get(i).callForRepair(); // Call for repair on car i
    }
}
