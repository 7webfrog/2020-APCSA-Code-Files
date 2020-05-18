import java.util.Scanner
import java.lang.Math
import java.util.ArrayList

fun main(args:Array<String>) {
  val scan:Scanner = Scanner(System.`in`)
  val list:ArrayList<TeamMember> = ArrayList<TeamMember>()
  var nextName:String
  var nextId:String
  while (true) {
    println("Enter the next name:")
    nextName = scan.nextLine()
    if (nextName.toUpperCase().equals("STOP")) {
      break
    }
    println("Enter the next ID:")
    nextId = scan.nextLine()
    list.add(TeamMember(nextName, nextId))
  }
  insertionSort(list)
  println(list)
}

fun insertionSort(list:ArrayList<TeamMember>) {
  for (i in 1..list.size-1) {
    var temp:TeamMember = list.get(i)
    var pos:Int = i
    while (pos > 0 && 0 > temp.compareTo(list.get(pos-1))) {
      list.set(pos, list.get(pos-1))
      pos--
    }
    list.set(pos, temp)
  }
}