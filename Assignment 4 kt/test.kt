import java.util.Scanner
import java.lang.Math
import java.util.ArrayList

fun main(args: Array<String>) {
  val scan: Scanner = Scanner(System.`in`)
  println("Type the message to be shortened")
  var input: String = scan.nextLine()
  if (10 > input.length) {
    println("This doesn't need shortening!")
    return
  }
  var out: String = ""
  input = input.toLowerCase()
  var j: Int = 0
  var flag: Int = 0
  var vowel: Int = 0
  var repeat: Int = 0
  for (i in 1..input.length-1) {
    val e: Char = input.get(i)
    val d: Char = input.get(i-1)
    if (!(d == ' ' && (e == 'a' || e == 'e' || e == 'i' || e == 'o' || e == 'u'))) {
      if (e == 'a' || e == 'e' || e == 'i' || e == 'o' || e == 'u') {
        out += input.substring(j, i)
        flag++
        j = i+1
        vowel++
      }
      if (e == d && flag == 0) {
        out += input.substring(j, i)
        j = i+1
        repeat++
      }
      flag = 0
    }
  }
  if (j != input.length) {
    out += input.substring(j, input.length)
  }
  println("Shortened message: $out")
  println("Repeated letters removed: $repeat")
  println("Vowels removed: $vowel")
  println("Total characters saved: ${vowel+repeat}")
}