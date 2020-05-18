import java.util.Scanner
import java.lang.Math
import java.util.ArrayList

fun main(args: Array<String>) {
  val scan:Scanner = Scanner(System.`in`)
  var lng:Int = 0
  while (10 > lng) {
    println("Enter an array length (must be 10 or greater):")
    lng = scan.nextInt()
  }
  var lista:Array<Int> = Array<Int>(lng, {_ -> 0})
  var listb:Array<Int> = Array<Int>(lng, {_ -> 0})
  print("First Array: ")
  for (i in 0..lng-1) {
    lista[i] = (Math.random() * 100 + 1).toInt()
    print("${lista[i]} ")
  }
  print("\nSecond Array: ")
  for (i in 0..lng-1) {
    listb[i] = (Math.random() * 100 + 1).toInt()
    print("${listb[i]} ")
  }
  var merged:Array<Int> = Array<Int>(2*lng, {_ -> 0})
  for (i in 0..merged.size-1) {
    when (i%2) {
      0 -> {
        for (j in 0..i) {
          if (merged[j] == lista[i/2]) {
            break
          }
          merged[i] = lista[i/2]
        }
      }
      1 -> {
        for (j in 0..i) {
          if (merged[j] == listb[i/2]) {
            break
          }
          merged[i] = listb[i/2]
        }
      }
    }
  }
  print("\nMerged Array: ")
  for (i:Int in merged) {
    if (i != 0) {
      print("$i ")
    }
  }
}