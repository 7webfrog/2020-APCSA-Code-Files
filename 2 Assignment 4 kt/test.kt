import java.util.Scanner
import java.lang.Math
import java.util.ArrayList

fun main(args: Array<String>) {
  // val scan:Scanner = Scanner(System.`in`)
  val fraction1:Fraction = Fraction(8, 10)
  println("Fraction 1: " + fraction1)
  val fraction2:Fraction = Fraction(12, 8)
  println("Fraction 2: " + fraction2)
  val fraction3:Fraction = Fraction(4, 5);
  println("Fraction 3: " + fraction3)
  println()
  println("Compare fraction 1 to fraction 2: " + fraction1.compareTo(fraction2))
  println("Compare fraction 2 to fraction 1: " + fraction2.compareTo(fraction1))
  println()
  println("Compare fraction 1 to fraction 3: " + fraction1.compareTo(fraction3))
  println("Compare fraction 3 to fraction 1: " + fraction3.compareTo(fraction1))
  println()
  println("Compare fraction 2 to fraction 3: " + fraction2.compareTo(fraction3))
  println("Compare fraction 3 to fraction 2: " + fraction3.compareTo(fraction2))
}