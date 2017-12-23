import kotlin.math.floor
import kotlin.math.max
import kotlin.math.sqrt

fun Int.isNotPrime(): Boolean {
  return !isPrime()
}

fun Int.isPrime(): Boolean {
  require(this > 1)
  if (this == 2) return true

  return (2..floor(sqrt(this.toDouble())).toInt()).none { this.rem(it) == 0 }
}

fun Int.nonNegativeRem(other: Int): Int {
  var result = rem(other)

  if (result < 0) {
    result += other
  }

  return result
}

fun Int.toBinaryString(minLength: Int = 0): String {
  val noPadResult = Integer.toBinaryString(this)
  return "0".repeat(max(0, minLength - noPadResult.length)) + noPadResult
}
