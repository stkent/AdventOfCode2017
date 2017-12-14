import kotlin.math.max

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
