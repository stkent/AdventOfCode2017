class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = "xlqgujun"
      val hasher = KnotHasher()

      val rowInputs = (0..127).map { row -> "$input-$row" }
          .map { hasher.hash(it).chunked(2) }
          .map { it.map { it2 -> String.format("%8s", Integer.toBinaryString(Integer.parseInt(it2, 16))).replace(" ", "0") } }

//      println(rowInputs)
      println(rowInputs.flatten().sumBy { it.count { char -> char == '1' } })

      val entryMap = mutableMapOf<GridPoint, Boolean>()

      println(rowInputs)

      rowInputs.forEachIndexed { index, row ->
        row.joinToString("").forEachIndexed { col, s -> entryMap.put(GridPoint(index, col), s == '1') }
      }

      println(entryMap)

      val usedCoords = entryMap.filter { it.value }.keys.toMutableSet()
      println(usedCoords.reversed())

      var count = 0
      while (usedCoords.isNotEmpty()) {
        val seedCoord = usedCoords.first()
        val coordsToExplore = mutableSetOf(seedCoord)
        val exploredCoords = mutableSetOf<GridPoint>()

        while (!coordsToExplore.isEmpty()) {
          val nextCoord = coordsToExplore.first()
          println(nextCoord)

          val connectedCoords = nextCoord.neighbors4().filter { it.x in 0..127 && it.y >= 0 && it.y <= 127 }
              .filter { usedCoords.contains(it) }
              .filterNot { exploredCoords.contains(it) }

          coordsToExplore.addAll(connectedCoords)
          coordsToExplore.remove(nextCoord)
          exploredCoords.add(nextCoord)
        }

        count += 1
        usedCoords.removeAll(exploredCoords)
      }

      println(count)
    }
  }

}
