/* Term 2 Assignment 1 - Fraction */
/* A class which is used to represent fractions*/
/*
 * Ryan Lutz
 * 10/4/19
 * M2A1
 */
public class Fraction {
  private int numerator; // Declare int for numerator and denominator
  private int denominator;
  
  public Fraction() { // Default constructor
    this(1,1);
  }
  
  public Fraction(int n, int d) { // Alt constructor
    numerator = 1; // Set numerator and denominator to 1
    denominator = 1;
    if (n > 0) { // If n is positive
      numerator = n; // Set numerator to n
    }
    if (d > 0) { // If d is positive
      denominator = d; // Set denominator to d
    }
  }
  
  public String toString() { // ToString
    return numerator+"/"+denominator; // Return a frac
  }
  
  public String mixedNumber() { // Mixed number return
    if (numerator >= denominator) { // If improper fraction
      int num = numerator/denominator; // Find the integer
      if (numerator%denominator == 0) { // If there's no remainder
        return ""+num; // Return just the integer
      }
      return num+" "+(numerator%denominator)+"/"+denominator; // Else, return the entire mixed number
    }
    return numerator+"/"+denominator; // If fraction is proper, return the fraction
  }
  
  public void add(int n, int d) { // Add fractions
    if (!(n > 0 && d > 0)) { // If n or d is not valid
      return; // Return
    }
    // The next 3 lines achieve this: [(numerator * d)+(n * denominator)] / (denominator * d)
    numerator *= d;
    numerator += n * denominator;
    denominator *= d;
  }
}