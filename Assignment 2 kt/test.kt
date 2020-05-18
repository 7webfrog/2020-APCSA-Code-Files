import java.util.Scanner
import java.lang.Math
import java.util.ArrayList

fun main(args: Array<String>) {
  val scan: Scanner = Scanner(System.`in`)
  println("Seconds since Unix Epoch:")
  var input: Int = scan.nextInt()
  var years: Int = 1970 + input/31104000
  input %= 31104000
  var months: Int = input/2592000
  input %= 2592000
  var days: Int = input/86400
  input %= 86400
  var hours: Int = input/3600
  input %= 3600
  var mins: Int = input/60
  input %= 60
  println("Year: $years\nMonth: $months\nDay: $days\nHour: $hours\nMin: $mins\nSec: $input")
}