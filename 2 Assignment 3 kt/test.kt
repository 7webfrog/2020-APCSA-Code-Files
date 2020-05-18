import java.util.Scanner
import java.lang.Math
import java.util.ArrayList

fun main(args: Array<String>) {
  var person:Person = Person("John", "Doe")
  println("Printing person:\n" + person + "\n")
  var player:UltimatePlayer = UltimatePlayer("Mary", "Smith", "cutter")
  println("Printing player:\n" + player + "\n")
  var captain:Captain = Captain("Henry", "Tully", "handler", true)
  println("Printing captain:\n" + captain + "\n")
  var coach:Coach = Coach("Sara", "Lee", "Head coach")
  println("Printing coach:\n" + coach + "\n")
  var players:ArrayList<UltimatePlayer> = ArrayList<UltimatePlayer>()
  players.add(UltimatePlayer("Sammy", "Trong", "handler"))
  players.add(UltimatePlayer("Jayant", "Patel", "handler"))
  players.add(UltimatePlayer("Myra", "Ozaeta", "cutter"))
  players.add(UltimatePlayer("Lisa", "Holbrook", "cutter"))
  players.add(UltimatePlayer("Lisbeth", "Kvale", "cutter"))
  players.add(Captain("Malik", "Henry", "handler", true))
  players.add(Captain("Joseph", "Pak", "cutter", false))
  var coaches:ArrayList<Coach> = ArrayList<Coach>()
  coaches.add(Coach("Maryam", "Mathour", "Head Coach"))
  coaches.add(Coach("Soren", "Van Loben Sels", "Assistant Coach"))
  var team:UltimateTeam = UltimateTeam(players, coaches)
  println("Printing team:\n" + team.toString() + "\n")
  println("Printing cutters:\n" + team.getCutters() + "\n")
  println("Printing handlers:\n" + team.getHandlers() + "\n")
}