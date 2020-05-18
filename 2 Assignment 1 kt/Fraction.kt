class Fraction {
  private var numerator:Int;
  private var denominator:Int;

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
}