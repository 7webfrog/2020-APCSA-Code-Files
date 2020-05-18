import java.util.Scanner
import java.lang.Math
import java.util.ArrayList

fun main(args: Array<String>) {
  val scan: Scanner = Scanner(System.`in`)
  println("Please enter ratings from the movie review website.")
  var web1: Int = scan.nextInt()
  var web2: Int = scan.nextInt()
  var web3: Int = scan.nextInt()
  println("Please enter ratings from the focus group.")
  var foc1: Double = scan.nextDouble()
  var foc2: Double = scan.nextDouble()
  println("Please enter the average movie critic rating.")
  var crit1: Double = scan.nextDouble()
  println("Average website rating: ${(web1.toDouble() + web2 + web3) / 3}")
  println("Average focus group rating: ${(foc1+foc2)/2}")
  println("Average movie critic rating: $crit1")
  println("Overall movie rating: ${(web1.toDouble() + web2 + web3)/3*.2 + (foc1 + foc2)/2*.3 + crit1*.5}")
}