import java.util.Scanner
import java.lang.Math
import java.util.ArrayList

fun main(args: Array<String>) {
  val scan: Scanner = Scanner(System.`in`)
  println("Welcome. What is your name?")
  var name: String = scan.nextLine()
  println("Hello $name. Try your best to crack the code!\n\nPHASE 1\nEnter a number:")
  var p1: Int = scan.nextInt()
  if (p1 == 3) {
    println("Correct!\n\nPHASE 2\nEnter a number:")
  } else {
    println("Sorry, that was incorrect!\nBetter luck next time!")
    return
  }
  var p2: Int = scan.nextInt()
  if (p2 == 1 || (p2 >= 33 && 100 >= p2)) {
    println("Correct!\n\nPHASE 3\nEnter a number:")
  } else {
    println("Sorry, that was incorrect!\nBetter luck next time!")
    return
  }
  var p3: Int = scan.nextInt()
  if (p3 > 0 && (p3%3 == 0 || p3%7 == 0)) {
    println("Correct!\nYou have cracked the code!")
  }
}