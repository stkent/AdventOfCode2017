class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = 329

      val l = mutableListOf<Int>()
      l.add(0)
      l.add(1)

      var pos = 1

      (2..2017).forEach{
        pos = (pos + input).rem(l.size)
        l.add(pos + 1, it)
        pos += 1
      }

      println(l[l.indexOf(2017) + 1])

      var pos2 = 1
      var result = 1

      (2..50000000).forEach {
        pos2 = (pos2 + input).rem(it)

        if (pos2 == 0) result = it
        pos2 += 1
      }

      println(result)
    }
  }

}
