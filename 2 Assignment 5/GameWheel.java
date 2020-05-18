/* Term 2 Assignment 5 - Game Wheel */
/* GameWheel class*/
/* 
 * Ryan Lutz
 * 10/18/19
 * M2A5
 */
import java.util.*;
import java.lang.*;

public class GameWheel
{
  // List of slices making up the wheel
  private List<Slice> slices;
  
  // Position of currently selected slice on wheel
  private int currentPos;

  
  /* Creates a wheel with 40 preset slices which are then randomized (keeping 
   * the color pattern the same).
   */
  public GameWheel()
  {
    slices = new ArrayList<Slice>();
    currentPos = 0;
    initGameWheel();
    scramble();
  }

  
  /* Spins the wheel by so that a different slice is selected. Return that 
   * slice (Note: the 20 slices following the current slice are more likely to 
   * be returned than the other 20).
   */
  public Slice spinWheel()
  {
    //spin power between range of 1-100 (inclusive)
    int power = (int)(Math.random()*100 + 1);
    int newPos = (currentPos + power) % slices.size();
    currentPos = newPos;
    return slices.get(currentPos);
  }
  
  
  /* Helper method for the constructor. Randomizes the positions of the slices 
   * that are in the wheel, but without changing the pattern of the colors 
   * (i.e. the red slices will still be at odd indices, the black slices at 
   * multiples of 10, and the blue slices at all other even indices).
   */ 
  private void scramble()
  {
    ArrayList<Slice> black = new ArrayList<Slice>(); // Declare new ArrayLists for each color
    ArrayList<Slice> red = new ArrayList<Slice>();
    ArrayList<Slice> blue = new ArrayList<Slice>();
    for (Slice e: slices) { // For each slice in slices
      switch(e.getColor()) { // Switch on the color
        case "black": // Color = black
          black.add(e); // Add the slice to the black list
          break;
        case "red": // Color = red
          red.add(e); // Add the slice to the red list
          break;
        case "blue": // Color = blue
         blue.add(e); // Add the slice to the blue list
          break;
      }
    }
    ArrayList<Slice> newblack = new ArrayList<Slice>(); // Declare new ArrayLists for each color randomized
    ArrayList<Slice> newred = new ArrayList<Slice>();
    ArrayList<Slice> newblue = new ArrayList<Slice>();
    for (int i=black.size(); i>0; i--) { // For each element in the old black ArrayList
      newblack.add(black.remove((int)(Math.random()*black.size()))); // Add a random element to the new black list from the old black list and remove it
    }
    for (int i=red.size(); i>0; i--) { // For each element in the old red ArrayList
      newred.add(red.remove((int)(Math.random()*red.size()))); // Add a random element to the new red list from the old red list and remove it
    }
    for (int i=blue.size(); i>0; i--) { // For each element in the old blue ArrayList
      newblue.add(blue.remove((int)(Math.random()*blue.size()))); // Add a random element to the new blue list from the old blue list and remove it
    }
    int j=0, k=0, m=0; // Declare counter variables for each new color ArrayList
    for (int i=0; i<slices.size(); i++) { // For each slice in slices
      String color = slices.get(i).getColor(); // Get the color of the current slice
      switch(color) { // Switch on color
        case "black": // Color = black
          slices.set(i, newblack.get(j)); // Set the current element in slices to the j element in newblack
          j++; // Increment j
          break;
        case "red": // Color = red
          slices.set(i, newred.get(k)); // Set the current element in slices to the k element in newred
          k++; // Increment k
          break;
        case "blue": // Color = blue
          slices.set(i, newblue.get(m)); // Set the current element in slices to the m element in newblue
          m++; // Increment m
          break;
      }
    }
  }

  /**
   * Returns the list of slices that make up the GameWheel
   * @return the list of slices that make up the GameWheel.
   */
  public List<Slice> getSlices() {
    return slices;
  }
  
  // Helper method which initializes the slices in the wheel
  private void initGameWheel()
  {
    slices.add(new Slice("black", 8000));
    for (int i=1; i < 40; i++)
    {
      if (i%2 == 1)
        slices.add(new Slice("red", i*10));
      else if (i%10 == 0)
        slices.add(new Slice("black", i*200));
      else
        slices.add(new Slice("blue", i*100));
    }
  }
}
