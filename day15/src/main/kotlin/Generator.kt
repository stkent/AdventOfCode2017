sealed class Generator(seed: Long, private val factor: Long, private val accept: (Long) -> Boolean) {

  private var current: Long = seed

  fun nextValue(): Long {
    current = (current * factor).rem(2147483647)
    return if (accept(current)) current else nextValue()
  }

  class GeneratorA(seed: Long, accept: (Long) -> Boolean) : Generator(seed, 16807, accept)
  class GeneratorB(seed: Long, accept: (Long) -> Boolean) : Generator(seed, 48271, accept)

}
