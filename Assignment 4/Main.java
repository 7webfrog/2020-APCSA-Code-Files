/* Ryan Lutz
 * 9/17/19
 * M1A4
 */

import java.util.Scanner;
import java.lang.Math;

class Main {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in); // Create the scanner
      System.out.println("Type the message to be shortened"); // Print to console
      String in = scan.nextLine(); // Get input
      int vowct = 0, repltr = 0, f = 0; // Declare vars for vowels and repeated letters
      String w = ""; // Declare vars for new strings
      int k = 0; // Declare var to keep place in string
      // String is not less than 10 letters
      if (!(in.length() < 10)) { // String is more than 10 chars
        in = in.toLowerCase(); // Set string to lowercase
        for (int j = 0; j < in.length(); j++) { // For each letter in the new string
          // Vowel check
          if (j < in.length()-1 && j > 0 && vowel(in, j) && !spcvow(in, j)) { // If it is a vowel without a space before it
            vowct++; // Increment vowel counter
            w += in.substring(k, j); // Add the string prior to the repeated letters to a new string
            k = j + 1; // Find new k (starting point).
            f = 1;
          }
          // Repeated letter check
          if (j > 0 && in.charAt(j-1) == in.charAt(j) && f == 0) { // If the characters are the same and flag has not bee set
            repltr++; // Increment repeated letter counter
            try { // Try to add to the string
              w += in.substring(k, j); // Add the string prior to the vowel to a new string
            } catch (StringIndexOutOfBoundsException e) { // If that returns an error because there was the vowel function above already did this
              break; // Then move on
            } finally {
              k = j + 1; // Find new k (starting point)
            }
          }
          f = 0; // Reset the flag
        }
        w += in.substring(k, in.length()); // Get the end of the string
        // Finish it!
        System.out.println("Shortened message: "+w); // Print all of the outputs to console
        System.out.println("Repeated letters removed: "+repltr);
        System.out.println("Vowels removed: "+vowct);
        System.out.println("Total characters saved: "+(repltr+vowct));
      } else { // String is <= 10 chars
        System.out.println("\nThis doesn't need shortening!");
      }
      scan.close(); // Close the scanner
    }

    // Determines if there is a vowel at index i of String in
    public static boolean vowel(String in, int i) {
      if (in.charAt(i) == 'a' || in.charAt(i) == 'e' || in.charAt(i) == 'i' || in.charAt(i) == 'o' || in.charAt(i) == 'u') {
        return true; // If there is, true
      } else {
        return false; // If not, false
      }
    }

    // Determines if there is a space and vowel at indices [i, i+1] of String in
    public static boolean spcvow(String in, int i) {
      if (in.substring(i-1, i+1).equals(" a") || in.substring(i-1, i+1).equals(" e") || in.substring(i-1, i+1).equals(" i") || in.substring(i-1, i+1).equals(" o") || in.substring(i-1, i+1).equals(" u")) {
        return true; // If there is, true
      } else {
        return false; // If not, false
      }
    }
}