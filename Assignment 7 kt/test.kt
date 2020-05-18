import java.util.Scanner
import java.lang.Math
import java.util.ArrayList

fun main(args: Array<String>) {
  val scan:Scanner = Scanner(System.`in`)
  println("Welcome to the Methods Sampler Platter. Please enter a String to duplicate.")
  var string:String = scan.nextLine()
  println("The duplicated String is: ${duplicate(string)}")
  println("Next, please enter a String to check for Edhesive Palindromes.")
  string = scan.nextLine()
  println(when (isEdhesivePalindrome(string)) {
    true -> "Nice, you found an Edhesive Palindrome!"
    false -> "Too bad, that isn't an Edhesive Palindrome."
  })
  println("Almost done! Please enter a number to scramble.")
  var dbl:Double = scan.nextDouble()
  println("The scrambled number is: ${numberScramble(dbl)}")
}

fun duplicate(str:String): String {
  val n:Int = str.length%2
  var out:String = ""
  when (n) {
    0 -> {for (i in 0..str.length-1) { // For each char in str
      for (j in 0..str.length*2) {
        out += str.get(i)
      }
    }}
    1 -> {for (i in 0..str.length-1) {
      for (j in 0..str.length) {
        out += str.get(i)
      }
    }}
  }
  return out
}

fun isEdhesivePalindrome(str:String): Boolean {
  var string = str.toLowerCase()
  if (3 >= string.length) {
    return false
  }
  for (i in 0..string.length-1) {
    when (string.get(i)) {
      '4' -> string = string.substring(0, i) + 'a' + string.substring(i+1, string.length)
      '3' -> string = string.substring(0, i) + 'e' + string.substring(i+1, string.length)
      '0' -> string = string.substring(0, i) + 'o' + string.substring(i+1, string.length)
    }
  }
  for (i in 0..string.length-1) {
    if (string.get(i) != string.get(string.length-1-i)) {
      return false
    }
  }
  return true
}

fun numberScramble(num:Double): Double {
  if (num == 0.0) {
    return 0.0
  }
  var editnum:Double = num
  editnum += 5
  editnum /= 2
  return Math.sqrt(editnum)
}