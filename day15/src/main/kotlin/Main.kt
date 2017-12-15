import java.math.BigInteger

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
//      Generator A starts with 722
//      Generator B starts with 354

      var judgeCount = 0

      val genA = GeneratorA(16807, 722)
      val genB = GeneratorB(48271, 354)

      repeat(5000000) {
        val a = Integer.toBinaryString(genA.next().toInt()).takeLast(16)
        val b = Integer.toBinaryString(genB.next().toInt()).takeLast(16)

        if (a == b) judgeCount += 1
      }

      println(judgeCount)
    }
  }

}


class GeneratorA(val factor: Int, init: Int) {

  var current: BigInteger = init.toBigInteger()

  fun next(): BigInteger {
    current = (current * factor.toBigInteger()).rem(BigInteger.valueOf(2147483647))
    return if (current.rem(BigInteger.valueOf(4)) == BigInteger.ZERO) current else next()
  }

}

class GeneratorB(val factor: Int, init: Int) {

  var current: BigInteger = init.toBigInteger()

  fun next(): BigInteger {
    current = (current * factor.toBigInteger()).rem(BigInteger.valueOf(2147483647))
    return if (current.rem(BigInteger.valueOf(8)) == BigInteger.ZERO) current else next()
  }

}