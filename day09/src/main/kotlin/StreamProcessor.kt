class StreamProcessor {

  data class Result(val score: Int, val garbageCount: Int)

  fun processStream(stream: String): Result {
    var score = 0
    var garbageCount = 0

    var index = 0
    var nestLevel = 0
    var inGarbage = false

    while (index < stream.length) {
      when (Pair(stream[index], inGarbage)) {
        Pair('{', false) -> { score += ++nestLevel             }
        Pair('}', false) -> { nestLevel -= 1                   }
        Pair('!', true)  -> { index += 1                       }
        Pair('<', false) -> { inGarbage = true                 }
        Pair('>', true)  -> { inGarbage = false                }
        else             -> { if (inGarbage) garbageCount += 1 }
      }

      index += 1
    }

    return Result(score, garbageCount)
  }

}
