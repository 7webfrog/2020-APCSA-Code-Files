import java.util.Scanner
import java.lang.Math
import java.util.ArrayList

fun main(args: Array<String>) {
  // val scan:Scanner = Scanner(System.`in`)
  val frac1:Fraction = Fraction(7, 4)
  println("Fraction 1: $frac1")
  println("As a mixed number: ${frac1.mixedNumber()}")
  val frac2:Fraction = Fraction()
  println("Frac2: $frac2")
  println("Frac2 Mixed: ${frac2.mixedNumber()}")
  val frac3:Fraction = Fraction(2, 7)
  println("Frac3: $frac3")
  println("Frac3 Mixed: ${frac3.mixedNumber()}")
  frac3.add(2, 5)
  println("Add 2/5: $frac3")
  val frac4:Fraction = Fraction(24, 6)
  println("Frac4: $frac4")
  println("Frac4 Mixed: ${frac4.mixedNumber()}")
  frac4.add(1, -2)
  println("Add 1/-2: $frac4")
  val frac5:Fraction = Fraction(5, 2)
  println("Frac5: $frac5")
  println("Frac5 Mixed: ${frac5.mixedNumber()}")
  frac5.add(2, 3)
  println("Add 2/3: $frac5")
  println("Frac5 Mixed: ${frac5.mixedNumber()}")
}