import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()
//      val input = listOf(
//          "../.# => ##./#../...",
//          ".#./..#/### => #..#/..../..../#..#"
//      )

      val rules = input.map { s ->
        val rawGrids = s.split(" => ").map { it.split('/') }
        return@map PixelSquare(rawGrids[0]) to PixelSquare(rawGrids[1])
      }

      var image = listOf(
          ".#.",
          "..#",
          "###"
      )

//      println(rules)
//
//      println(rules.filter { image.permutations().contains(it.first) })

//      println(image.permutations().joinToString("\n\n\n"))

      repeat(18) {
        println(it)
        val squareSize = if (image.size.rem(2) == 0) 2 else 3
        val nSteps = image.size / squareSize
//        println(squareSize)
//        println(nSteps)

        val newImage = mutableListOf<String>()

        for (nRow in 0 until nSteps) {
          val pixelSquares = mutableListOf<PixelSquare>()

          for (nCol in 0 until nSteps) {
            if (squareSize == 2) {
              val oldPs = PixelSquare(listOf(
                  image[nRow*squareSize].substring(nCol*squareSize, (nCol+1)*squareSize),
                  image[nRow*squareSize+1].substring(nCol*squareSize, (nCol+1)*squareSize)
              ))

              pixelSquares.add(rules.first { oldPs.permutations().contains(it.first) }.second)
            } else {
              val oldPs = PixelSquare(listOf(
                  image[nRow*squareSize].substring(nCol*squareSize, (nCol+1)*squareSize),
                  image[nRow*squareSize+1].substring(nCol*squareSize, (nCol+1)*squareSize),
                  image[nRow*squareSize+2].substring(nCol*squareSize, (nCol+1)*squareSize)
              ))

              pixelSquares.add(rules.first { oldPs.permutations().contains(it.first) }.second)
            }
          }

          val psr = pixelSquares.reduce { acc, ps -> PixelSquare(acc.rows.mapIndexed { index, row -> row + ps.rows[index] })}
          newImage.addAll(psr.rows)
        }

        image = newImage

//        println("image: ")
//        println(newImage.joinToString("\n"))
      }

      println("p1: ${image.map { it.characterCounts()['#']!! }.sum()}")
    }
  }

}

data class PixelSquare(val rows: List<String>) {

  val size = rows.size

  fun flippedHorizontally() = PixelSquare(rows.map(String::reversed))

  fun flippedVertically() = PixelSquare(rows.reversed())

  fun rotatedClockwise(): PixelSquare {
    val newRows = (0 until size).map { newRowNumber ->
      (0 until size).map { newColNumber ->
        rows[size - 1 - newColNumber][newRowNumber]
      }.joinToString("")
    }

    return PixelSquare(newRows)
  }

  fun permutations(): Set<PixelSquare> {
    val result = mutableSetOf<PixelSquare>()
    result.add(this.flippedHorizontally())
    result.add(this.flippedVertically())
    result.add(this)
    result.add(this.rotatedClockwise())
    result.add(this.rotatedClockwise().rotatedClockwise())
    result.add(this.rotatedClockwise().rotatedClockwise().rotatedClockwise())

    result.add(this.rotatedClockwise().flippedVertically())
    result.add(this.rotatedClockwise().flippedVertically().flippedHorizontally())

    result.add(this.rotatedClockwise().rotatedClockwise().flippedVertically())
    result.add(this.rotatedClockwise().rotatedClockwise().flippedVertically().flippedHorizontally())

    result.add(this.rotatedClockwise().rotatedClockwise().rotatedClockwise().flippedVertically())
    result.add(this.rotatedClockwise().rotatedClockwise().rotatedClockwise().flippedVertically().flippedHorizontally())
    return result
  }

  override fun toString(): String {
    return rows.joinToString("/")
  }

}
