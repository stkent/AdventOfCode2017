import java.io.File

class Main {

  sealed class Operation {
    class Spin(val size: Int) : Operation()
    class Exchange(val index1: Int, val index2: Int) : Operation()
    class Partner(val program1: Char, val program2: Char) : Operation()

    companion object {
      fun fromString(string: String): Operation? {
        return when {
          string.startsWith('s') -> Spin(string.drop(1).toInt())

          string.startsWith('x') -> {
            val indices = string.drop(1).split("/").map(String::toInt)
            Exchange(indices[0], indices[1])
          }

          string.startsWith('p') -> {
            val programs = string.drop(1).split("/").map(CharSequence::first)
            Partner(programs[0], programs[1])
          }

          else -> null
        }
      }
    }
  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines().first().split(",").mapNotNull { Operation.fromString(it) }
//      println(input)

      val seenStates = mutableListOf<String>()

      var programs = ('a'..'p').toList()
//      var programs = ('a'..'e').toList()

//      val input = "s1,x3/4,pe/b".split(",").mapNotNull { Operation.fromString(it) }

      var i = 0

      repeat(40) {
        input.forEach {
          programs = when (it) {
            is Operation.Spin -> programs.rotate(-it.size)

            is Operation.Exchange -> {
              programs.swap(it.index1, it.index2)
            }

            is Operation.Partner -> {
              val index1 = programs.indexOf(it.program1)
              val index2 = programs.indexOf(it.program2)
              programs.swap(index1, index2)
            }
          }
        }

        if (seenStates.contains(programs.joinToString(""))) {
          println(i)
          i += 1
        } else {
          i += 1
          seenStates.add(programs.joinToString(""))
        }
      }

      println(programs.joinToString(""))
    }
  }

}

fun <T> List<T>.swap(index1: Int, index2: Int): List<T> {
  val result = toMutableList()
  val tmp = this[index1] // 'this' corresponds to the list
  result[index1] = result[index2]
  result[index2] = tmp
  return result
}
