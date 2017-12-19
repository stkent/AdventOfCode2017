import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()

      val map = mutableMapOf<GridPoint, Char>().withDefault { ' ' }

      input.forEachIndexed { nRow, row ->
        row.forEachIndexed { nCol, value ->
          map.put(GridPoint(nCol, -nRow), value)
        }
      }

//      println(map)

      var gridPoint = map.entries.first { it.key.y == 0 && it.value == '|' }.key
      var direction = Direction.SOUTH
      val seenLetters = mutableListOf<Char>()

      var steps = 0

      while (true) {
        steps += 1
//        println(gridPoint)
//        println(direction)

//        Thread.sleep(100)

        val nextGridPoint = gridPoint.step(direction)
        val nextChar = map.getValue(nextGridPoint)

        nextChar.let {
          if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(it)) {
            seenLetters.add(it)
            print(it)
          }

          if (nextChar == 'Y') {
            println("part2: ${steps + 1}")
            System.exit(1)
          }

          gridPoint = nextGridPoint
        }

        if (nextChar == '+') {
          val directions = Direction.values().toMutableList()
          directions.remove(direction.uTurn())
          gridPoint = nextGridPoint

          direction = directions.first { map.getValue(gridPoint.step(it)) != ' ' }
        }

      }
    }
  }

}
