class SpinLockStopper {

  fun computeValueAfterLastInsert(stepSize: Int, insertCount: Int): Int {
    val buffer = mutableListOf(0)
    var position = 0

    (1..insertCount).forEach {
      position = (position + stepSize).rem(it) + 1
      buffer.add(position, it)
    }

    return buffer[buffer.indexOf(insertCount) + 1]
  }

  fun computeValueAfterZero(stepSize: Int, insertCount: Int): Int {
    // Begin one iteration in:
    var position = 1
    var valueAfterZero = 1

    (2..insertCount).forEach {
      position = (position + stepSize).rem(it)

      if (position == 0) valueAfterZero = it
      position++
    }

    return valueAfterZero
  }

}
