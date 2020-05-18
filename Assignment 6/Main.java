/*
 * Ryan Lutz
 * 9/24/19
 * M1A6
 */
import java.util.Scanner;
import java.lang.Math;

class Main {
    public static void main(String[] args) {
      int f = 0, length = 0; // Declare ints for flag and array length
      Scanner scan = new Scanner(System.in); // Create the scanner
      while (f == 0) { // While the array length is invalid or it's the first run
        System.out.println("Enter an array length (must be 10 or greater):"); // Print to console
        length = scan.nextInt(); // Get input
        if (length >= 10) { // If the input is valid
          f = 1; // Raise the flag to exit the loop
        }
      }
      scan.close(); // Close the scanner
      int[] array1 = new int[length]; // Declare the arrays with the input length
      int[] array2 = new int[length];
      for (int i = 0; i < length; i++) { // For each element in both arrays
        array1[i] = (int)(Math.random()*100 + 1); // Assign a random number to the i element in both arrays
        array2[i] = (int)(Math.random()*100 + 1);
      }
      System.out.print("\nFirst Array: "); // Print to console
      for (int i = 0; i < length; i++) { // For each element in the array
        System.out.print(array1[i]+" "); // Print element to console
      }
      System.out.print("\n\nSecond Array: "); // Print to console
      for (int i = 0; i < length; i++) { // For each element in the array
        System.out.print(array2[i]+" "); // Print element to console
      }
      int[] out = new int[length*2]; // Declare the output array
      int j = 0; // Stores the current location in out
      f = 0; // Reset the flag from earlier
      for (int i = 0; i < length; i++) { // For each element in array1 and array2
        for (int k = 0; k <= j; k++) { // For each element in output array
          if (array1[i] == out[k]) { // If the element in array1 matches any previous element in output
            f = 1; // Set the flag
          }
        }
        if (f != 1) { // If the flag is not set
          out[j] = array1[i]; // Set the output 
          j++; // Increment j
        }
        f = 0; // Reset the flag
        for (int k = 0; k <= j; k++) { // For each element in the output array
          if (array2[i] == out[k]) { // If the element in array2 matches any previous element in output
            f = 1; // Set the flag
          }
        }
        if (f != 1) { // If flag is not set
          out[j] = array2[i]; // Set the output
          j++; // Increment j
        }
        f = 0; // Reset the flag
      }
      while (j < out.length) { // For the open elements in the output array
        out[j] = 0; // Set them equal to 0
        j++; // Increment j
      }
      System.out.print("\n\nMerged Array: "); // Print to console
      for (int i = 0; i < out.length; i++) { // For each element in the output array
        if (out[i] != 0) { // If the current element is not 0
          System.out.print(out[i]+" "); // Print to console
        }
      }
    }
}