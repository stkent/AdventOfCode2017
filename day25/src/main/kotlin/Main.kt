class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val initialState = State.A
      val checksumSteps = 12386363

      val tape = mutableMapOf<Int, Boolean>()
      var index = 0
      var state = initialState

      repeat(checksumSteps) {
        val current = tape.getOrPut(index) { false }
        tape.put(index, state.newValue(current))
        index += state.indexDelta(current)
        state = state.nextState(current)
      }

      val checksum = tape.count { it.value }

      println("Part 1 solution: $checksum")
    }
  }

}

enum class State {
  A, B, C, D, E, F;

  fun newValue(current: Boolean): Boolean {
    return when (Pair(this, current)) {
      Pair(A, false) -> true
      Pair(A, true)  -> false
      Pair(B, false) -> true
      Pair(B, true)  -> false
      Pair(C, false) -> true
      Pair(C, true)  -> false
      Pair(D, false) -> true
      Pair(D, true)  -> false
      Pair(E, false) -> true
      Pair(E, true)  -> true
      Pair(F, false) -> true
      Pair(F, true)  -> true
      else           -> throw IllegalStateException()
    }
  }

  fun indexDelta(current: Boolean): Int {
    return when (Pair(this, current)) {
      Pair(A, false) ->  1
      Pair(A, true)  -> -1
      Pair(B, false) -> -1
      Pair(B, true)  ->  1
      Pair(C, false) -> -1
      Pair(C, true)  ->  1
      Pair(D, false) -> -1
      Pair(D, true)  -> -1
      Pair(E, false) -> -1
      Pair(E, true)  -> -1
      Pair(F, false) -> -1
      Pair(F, true)  ->  1
      else           -> throw IllegalStateException()
    }
  }

  fun nextState(current: Boolean): State {
    return when (Pair(this, current)) {
      Pair(A, false) -> B
      Pair(A, true)  -> E
      Pair(B, false) -> C
      Pair(B, true)  -> A
      Pair(C, false) -> D
      Pair(C, true)  -> C
      Pair(D, false) -> E
      Pair(D, true)  -> F
      Pair(E, false) -> A
      Pair(E, true)  -> C
      Pair(F, false) -> E
      Pair(F, true)  -> A
      else           -> throw IllegalStateException()
    }
  }

}
