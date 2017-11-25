fun Int.nonNegativeRem(other: Int): Int {
  var result = rem(other)

  if (result < 0) {
    result += other
  }

  return result
}
