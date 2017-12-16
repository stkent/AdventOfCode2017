sealed class DanceMove {
  class Spin(val size: Int) : DanceMove()
  class Exchange(val index1: Int, val index2: Int) : DanceMove()
  class Partner(val program1: Char, val program2: Char) : DanceMove()

  companion object {
    fun fromString(string: String): DanceMove? {
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
