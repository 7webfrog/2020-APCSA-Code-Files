import java.util.Scanner
import java.lang.Math
import java.util.ArrayList

fun main(args:Array<String>) {
  val b:Board = Board()
  val scan:Scanner = Scanner(System.`in`)
  println("Welcome to Battleship!\n")
  println("$b\n")
  var addNew:Boolean = true
  while (addNew) {
    println("Add a new ship? (y/n)")
    var ans:String = scan.nextLine()
    if (ans.toLowerCase().equals("y")) {
      println("Starting in which row?")
      var r:Int = scan.nextInt()
      println("Starting in which column?")
      var c:Int = scan.nextInt()
      println("How long?")
      var l:Int = scan.nextInt()
      scan.nextLine()
      println("Horizontal (h) or vertical (v)?")
      var d:String = scan.nextLine()
      var h:Boolean = d.toLowerCase().equals("h")
      if (b.addShip(r, c, l, h)) {
        println("\nNew ship added!\n\n" + b + "\n")
      } else {
        println("\nCan't put a ship there!\n")
      }
    } else {
      addNew = false
      println("\nOk, let's play!\n")
    }
    println(b.foundShip(1)) // TEST ME
    println(b.foundShip(3))
    println(b.foundShip(4))
  }
  while (!b.gameOver()) {
    println("Input row")
    var r:Int = scan.nextInt()
    println("Input column")
    var c:Int = scan.nextInt()
    var result:Int = b.shoot(r, c)
    when (result) {
      1 -> println("\nHit!\n\n" + b + "\n")
      0 -> println("\nMiss!\n\n" + b + "\n")
      2 -> println("\nYou already tried that\n")
      else -> println("\nInvalid coordinates\n")
    }
  }
  println("Game over!")
}