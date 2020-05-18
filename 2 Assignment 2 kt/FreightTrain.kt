import java.util.ArrayList
class FreightTrain {
  private var train:ArrayList<Boxcar> = ArrayList<Boxcar>()

  constructor():this(1) {}
  constructor(n:Int) {
    if (0 >= n) {
      train.add(Boxcar("gizmos", 5, false))
      return
    }
    for (i in 1..n) {
      train.add(Boxcar("gizmos", 5, false))
    }
  }

  override fun toString():String {
    var out:String = ""
    for (e:Boxcar in train) {
      out += "$e\n"
    }
    return out
  }

  fun setCargo(c:String) {
    for (e:Boxcar in train) {
      e.setCargo(c)
    }
  }

  fun setMultiCargo() {
    var i = 0
    for (e:Boxcar in train) {
      when (i%4) {
        0 -> e.setCargo("gizmos")
        1 -> e.setCargo("gadgets")
        2 -> e.setCargo("widgets")
        3 -> e.setCargo("wadgets")
      }
      i++
    }
  }

  fun fillTrain() {
    for (e:Boxcar in train) {
      while (!e.isFull()) {
        e.loadCargo()
      }
    }
  }

  fun callForRepair(i:Int) {
    train.get(i).callForRepair()
  }
}