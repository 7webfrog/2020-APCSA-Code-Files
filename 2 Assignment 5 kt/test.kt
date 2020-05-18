import java.util.Scanner
import java.lang.Math
import java.util.ArrayList

fun main(args: Array<String>) {
  val wheel:GameWheel = GameWheel()
  val colors:ArrayList<String> = ArrayList<String>()
  var sum:Double = 0.0
  var out:String = ""
  for (i in  1..3) {
    var curSpin:Slice = wheel.spinWheel()
    sum += curSpin.getPrizeAmount()
    out += "Spin $i - $curSpin\n"
    colors.add(curSpin.getColor())
  }
  if (colors.get(0).equals(colors.get(1)) && colors.get(1).equals(colors.get(2))) {
    out += "Three ${colors.get(0)}s = double your money!"
    sum *= 2
  }
  println("Total prize money: \$${sum.toInt()}\n\n$out")
}