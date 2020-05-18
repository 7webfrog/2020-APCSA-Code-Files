/*
 * Ryan Lutz
 * 9/30/19
 * M1A7
 * I had a lot of fun writing this program, and believe it or not, I wrote it perfectly the first time!
 * I didn't have to change my code at all after writing it. I wrote it all at once, and I'm proud that
 * I've managed to accomplish this feat.
 */

import java.util.Scanner;
import java.lang.Math;

class Main {
  public static void main(String[] args) { // Main method
    Scanner scan = new Scanner(System.in); // Create the scanner
    System.out.println("Welcome to the Methods Sampler Platter. Please enter a String to duplicate."); // Print to console
    String str = scan.nextLine(); // Get string input
    System.out.println("The duplicated String is: "+duplicate(str)); // Print to console, call duplicate
    System.out.println("Next, please enter a String to check for Edhesive Palindromes."); // Print to console
    str = scan.nextLine(); // Get string input
    if (isEdhesivePalindrome(str)) { // If input is an edhesive palindrome
      System.out.println("Nice, you found an Edhesive Palindrome!"); // Print to console
    } else {
      System.out.println("Too bad, that isn't an Edhesive Palindrome."); // Print to console
    }
    System.out.println("Almost done! Please enter a number to scramble."); // Print to console
    double dbl = scan.nextDouble(); // Get double input
    System.out.println("The scrambled number is: "+numberScramble(dbl)); // Print to console, call numberScramble
    scan.close(); // Close the scanner
  }

  public static String duplicate(String str) { // Takes a string and returns a string. Duplicates letters
    String temp = ""; // Declare temp string
    if (str.length()%2 == 1) { // If number of letters is odd
      for (int i=0; i<str.length(); i++) { // For each letter in str
        for (int j=0; j<str.length(); j++) { // Repeat the action for each letter the same amount of times
          temp += str.charAt(i); // Add the char at i to the temp string
        }
      }
    } else { // If number of letters is even
      for (int i=0; i<str.length(); i++) { // For each letter in str
        for (int j=0; j<str.length()*2; j++) { // Repeat the action for each letter the same amount of times
          temp += str.charAt(i); // Add the char at i to the temp string
        }
      }
    }
    return temp; // Return the temp string
  }

  public static boolean isEdhesivePalindrome(String str) { // Takes a string and returns a boolean. Checks if string is an edhesive palindrome
    String temp = ""; // Declare temp string
    int j = 0; // Declare last char for letter switch
    str = str.toLowerCase(); // Set str to lower case
    if (str.length() <= 3 || str.length() >= 15) { // If str is too short or too long
      return false; // Return false
    }
    for (int i=0; i<str.length(); i++) { // For each letter in the string
      if (str.charAt(i) == '4') { // If the char is a 4
        temp += str.substring(j, i); // Add the previous section of the string to temp
        temp += "a"; // Replace the 4 with an a
        j=i+1; // Reset j
      } else if (str.charAt(i) == '3') { // If the char is a 3
        temp += str.substring(j, i); // Add the previous section of the string to temp
        temp += "e"; // Replace the 3 with an e
        j=i+1; // Reset j
      } else if (str.charAt(i) == '0') { // If the char is a 0
        temp += str.substring(j, i); // Add the previous section of the string to temp
        temp += "o"; // Replace the 0 with an o
        j=i+1; // Reset j
      }
    }
    if (j < str.length()-1) { // If a part of the string has not been copied yet
      temp += str.substring(j, str.length()); // Add the remainder of str to temp
    }
    for (int i=0; i<temp.length(); i++) { // For each letter in temp
      if (temp.charAt(i) != temp.charAt(temp.length()-1-i)) { // If the letter at i and the letter i spaces away from the end are NOT the same
        return false; // Return false
      }
    }
    return true; // If everything is valid, return true
  }

  public static double numberScramble(double num) { // Takes a double and returns a double. Scrambles the number like scrambled eggs
    if (num < 0) { // If the number is less than 0
      return 0; // Return 0
    }
    num += 5; // Add 5 to the number
    num /= 2; // Half the number
    num = Math.sqrt(num); // Find the square root of the number
    return num; // Return num
  }
}