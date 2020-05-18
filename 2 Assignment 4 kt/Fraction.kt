class Fraction : Comparable<Fraction> {
  private var numerator:Int;
  private var denominator:Int;
  companion object {
    fun gcd(a:Int, b:Int): Int {
      var gcd:Int = 1
      var max:Int = when {
        a > b -> a
        else -> b
      }
      for (i in 2..max) {
        if (a%i == 0 && b%i == 0) {
          gcd = i
        }
      }
      return gcd
    }

    fun lcm(a:Int, b:Int): Int {
      for (i in 1..Integer.MAX_VALUE) {
        var cur:Int = a*i
        if (cur == 0) {
          return 0
        }
        if (b%cur == 0) {
          return i
        }
      }
      return -1
    }
  }

  constructor(): this(1, 1) {}
  constructor(n:Int, d:Int) {
    numerator = 1
    denominator = 1
    if (n > 0) {
      numerator = n
    }
    if (d > 0) {
      denominator = d
    }
    simplify()
  }

  override fun toString(): String {
    return "$numerator/$denominator"
  }

  fun mixedNumber(): String {
    when {
      numerator%denominator == 0 -> return "${numerator/denominator}"
      numerator > denominator -> return "${numerator/denominator} ${numerator%denominator}/$denominator"
      else -> return "$numerator/$denominator"
    }
  }

  fun add(n:Int, d:Int) {
    if (!(n > 0 && d > 0)) {
      return
    }
    numerator = (numerator*d + n*denominator)
    denominator *= d
  }

  override fun compareTo(other:Fraction): Int {
    val dbl1:Double = numerator.toDouble()/denominator
    val dbl2:Double = other.numerator.toDouble()/other.denominator
    return when {
      dbl1 > dbl2 -> 1
      dbl1 == dbl2 -> 0
      else -> -1
    }
  }

  fun simplify() {
    var gcd:Int = gcd(numerator, denominator)
    numerator /= gcd
    denominator /= gcd
  }
}