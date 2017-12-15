class Judge {

  fun countMatches(generatorA: Generator, generatorB: Generator, nRepeats: Int): Int {
    var result = 0

    repeat(nRepeats) {
      val a = generatorA.nextValue()
      val b = generatorB.nextValue()

      if (a and 0xFFFF == b and 0xFFFF) result += 1
    }

    return result
  }

}
