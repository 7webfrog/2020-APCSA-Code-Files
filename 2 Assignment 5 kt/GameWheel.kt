import java.util.*

class GameWheel {
  private var slices:ArrayList<Slice>
  private var currentPos:Int
  
  constructor() {
    slices = ArrayList<Slice>()
    currentPos = 0
    initGameWheel()
    scramble()
  }

  fun spinWheel(): Slice {
    var power:Int = (Math.random()*100+1).toInt()
    var newPos:Int = (currentPos + power) % slices.size
    currentPos = newPos
    return slices.get(currentPos)
  }

  private fun scramble() {
    val reds:ArrayList<Slice> = ArrayList<Slice>()
    val blacks:ArrayList<Slice> = ArrayList<Slice>()
    val blues:ArrayList<Slice> = ArrayList<Slice>()
    for (e:Slice in slices) {
      when (e.getColor()) {
        "red" -> reds.add(e)
        "black" -> blacks.add(e)
        "blue" -> blues.add(e)
      }
    }
    val newreds:ArrayList<Slice> = ArrayList<Slice>()
    val newblacks:ArrayList<Slice> = ArrayList<Slice>()
    val newblues:ArrayList<Slice> = ArrayList<Slice>()
    for (i in 0..reds.size-1) {
      newreds.add(i, reds.get((Math.random()*reds.size).toInt()))
    }
    for (i in 0..blacks.size-1) {
      newblacks.add(i, blacks.get((Math.random()*blacks.size).toInt()))
    }
    for (i in 0..blues.size-1) {
      newblues.add(i, blues.get((Math.random()*blues.size).toInt()))
    }
    var j:Int = 0
    var k:Int = 0
    var l:Int = 0
    for (i in 0..slices.size-1) {
      when (slices.get(i).getColor()) {
        "red" -> {
          slices.set(i, reds.get(j))
          j++
        }
        "black" -> {
          slices.set(i, blacks.get(k))
          k++
        }
        "blue" -> {
          slices.set(i, blues.get(l))
          l++
        }
      }
    }
  }

  private fun initGameWheel() {
    slices.add(Slice("black", 8000))
    for (i in 1..39) {
      slices.add(when {
        i%2 == 1 -> Slice("red", i*10)
        i%10 == 0 -> Slice("black", i*200)
        else -> Slice("blue", i*100)
      })
    }
  }
}