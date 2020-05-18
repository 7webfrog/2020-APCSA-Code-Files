class Boxcar {
  private var cargo:String = "gizmos"
  private var numUnits:Int
  private var repair:Boolean

  constructor():this("gizmos", 5, false) {}
  constructor(c:String, u:Int, r:Boolean) {
    setCargo(c)
    numUnits = 0
    if (u >= 0 && 10 >= u && !r) {
      numUnits = u
    }
    repair = r
  }

  override fun toString():String {
    return when {
      repair -> "$numUnits $cargo\tin repair"
      else -> "$numUnits $cargo\tin service"
    }
  }

  fun loadCargo() {
    if (numUnits != 10 && !repair) {
      numUnits++
    }
  }

  fun getCargo():String {
    return cargo
  }

  fun setCargo(c:String) {
    var temp:String = c.toLowerCase()
    cargo = "gizmos"
    if (temp.equals("gadgets") || temp.equals("widgets") || temp.equals("wadgets")) {
      cargo = temp
    }
  }

  fun isFull():Boolean {
    return numUnits == 10
  }

  fun callForRepair() {
    repair = true
    numUnits = 0
  }
}