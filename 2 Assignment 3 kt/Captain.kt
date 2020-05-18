class Captain:UltimatePlayer {
  private var type:Boolean

  constructor(firstName:String, lastName:String, pos:String, type:Boolean):super(firstName, lastName, pos) {
    this.type = type
  }

  override fun toString():String {
    var pos:String = when (type) {
      true -> "offense"
      false -> "defense"
    }
    return "${super.toString()}\n   Captain: $pos"
  }
}