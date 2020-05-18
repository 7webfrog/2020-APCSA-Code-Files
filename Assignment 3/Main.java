/* Ryan Lutz
 * 9/16/19
 * M1A3 - Crack the Code
 */
import java.util.Scanner;
import java.lang.Math;

class Main {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in); // Create scanner
      int f = 0; // Declare the flag
      System.out.println("Welcome. What is your name?"); // Print to console
      String name = scan.nextLine(); // Get input
      System.out.println("Hello "+name+". Try your best to crack the code!\n\nPHASE 1\nEnter a number:"); // Print to console
      int one = scan.nextInt(); // Get input
      if (one == 3) { // If code is correct
        System.out.println("Correct!\n\nPHASE 2\nEnter a number"); // Print to console
      } else {
        System.out.println("Sorry, that was incorrect!\nBetter luck next time!"); // Print to console
        f = 1; // Set the flag
      }
      if (f != 1) { // If flag is not set
        int two = scan.nextInt(); // Get input
        if (two == 1 || (two >= 33 && two <= 100)) { // If code is correct
          System.out.println("Correct!\n\nPHASE 3\nEnter a number"); // Print to console
        } else {
          System.out.println("Sorry, that was incorrect!\nBetter luck next time!"); // Print to console
          f = 1; // Set the flag
        }
      }
      if (f != 1) { // If flag is not set
        int three = scan.nextInt(); // Get input
        if (three > 0 && (three % 7 == 0 || three % 3 == 0)) { // If code is correct
          System.out.println("Correct!\nYou have cracked the code!"); // Print to console
        } else {
          System.out.println("Sorry, that was incorrect!\nBetter luck next time!"); // Print to console
        }
      }
      scan.close(); // Close the scanner
    }
}