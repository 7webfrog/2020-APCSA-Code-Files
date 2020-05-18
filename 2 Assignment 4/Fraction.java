/*
 * Ryan Lutz
 * 10/15/19
 * M2A4
 */
public class Fraction implements Comparable<Object> {
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
    simplify(); // Simplify the fraction
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

  /*public int getNumerator() { // Numerator accessor
    return numerator;
  }

  public int getDenominator() { // Denominator accessor
    return denominator;
  }*/
  
  public void add(int n, int d) { // Add fractions
    if (!(n > 0 && d > 0)) { // If n or d is not valid
      return; // Return
    }
    // The next 3 lines achieve this: [(numerator * d)+(n * denominator)] / (denominator * d)
    numerator *= d;
    numerator += n * denominator;
    denominator *= d;
    simplify(); // Simplify the fraction
  }
  
  public static int gcd(int a, int b) { // Greatest common divisor/factor
    int min = b; // Define min variable
    int out = 1; // Declare output string and defauit it to one
    if (a < b) { // If a is less than b
      min = a; // Set min to a
    }
    for (int i=1; i<=min; i++) { // For each number between 1 and the lowest of the two numbers
      if (a%i == 0 && b%i == 0) { // If both numbers are divisible by i
        out = i; // Set out to i
      }
    }
    return out; // Return the greatest common divisor
  }

  public int compareTo(Object other) { // Compare two fractions
    Fraction e = (Fraction) other; // Cast other to Fraction
    double a = (double)numerator/denominator; // Double a is the decimal of this fraction
    // double b = (double)e.getNumerator()/e.getDenominator(); // Double b is the deciaml of other fraction
    double b = (double)e.numerator/e.denominator;
    if (a > b) { // If a is greater than b
      return 1; // Return 1
    } else if (a < b) { // If b is greater than a
      return -1; // Return -1
    }
    return 0; // Else, return 0
  }

  public void simplify() { // Simplify fractions
    int gcf = gcd(numerator, denominator); // Call gcd with the numerator and denominator
    numerator /= gcf; // Numerator is itself divided by the greatest common factor
    denominator /= gcf; // Denominator is itself divided by the greatest common factor
  }
}