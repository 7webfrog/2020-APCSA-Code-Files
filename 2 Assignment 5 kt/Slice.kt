class Slice {
  private var color:String
  private var prizeAmount:Int

  constructor(c:String, p:Int) {
    color = c
    prizeAmount = p
  }

  fun getPrizeAmount():Int {
    return prizeAmount
  }

  fun getColor():String {
    return color
  }

  override fun toString():String {
    return "Color: " + color + ", Prize Amount: $" + prizeAmount
  }
}