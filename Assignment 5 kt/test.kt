import java.util.Scanner
import java.lang.Math
import java.util.ArrayList

fun main(args: Array<String>) {
  val scan:Scanner = Scanner(System.`in`)
  println("How long do you want the array?")
  var input:Int = scan.nextInt()
  if (0 > input) {
    println("Not a valid length!")
    return
  }
  var list:Array<Double> = Array<Double>(input, {_ -> 0.0})
  var avg:Double = 0.0
  var max:Double = Double.MIN_VALUE
  var min:Double = Double.MAX_VALUE
  var inc:Boolean = true
  var dec:Boolean = true
  for (i in 0..list.size-1) {
    println("Enter a number")
    list[i] = scan.nextDouble()
    avg += list[i]
    if (list[i] > max) {
      max = list[i]
    }
    if (min > list[i]) {
      min = list[i]
    }
  }
  print("Your array is {")
  for (i in 0..list.size-2) {
    print("${list[i]}, ")
  }
  println("${list[list.size-1]}}")
  println("The average is ${avg/list.size}")
  println("The range is ${max-min}")
  for (i in 1..list.size-1) {
    if (list[i] > list[i-1]) {
      dec = false
    }
    if (list[i-1] > list[i]) {
      inc = false
    }
  }
  if (inc) {
    println("The array is sorted in increasing order")
  } else if (dec) {
    println("The array is sorted in decreasing order")
  } else {
    println("The array is unsorted")
  }
}