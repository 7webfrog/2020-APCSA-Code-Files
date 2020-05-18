open class UltimatePlayer:Person {
  private companion object {
    private var num:Int = 0
    fun getNum():Int {return num}
    fun addNum() {num++}
  }

  private var jerseyNumber:Int
  private var position:String

  constructor(firstName:String, lastName:String, pos:String):super(firstName, lastName) {
    position = "handler"
    if (pos.equals("cutter")) {
      position = "cutter"
    }
    addNum()
    jerseyNumber = getNum()
  }

  fun getPosition():String {
    return position
  }

  override fun toString():String {
    return "${super.toString()}\n   Jersey #: $jerseyNumber\n   Position: $position"
  }
}