class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = "183,0,31,146,254,240,223,150,2,206,161,1,255,232,199,88"
      val hasher = KnotHasher()

      val part1Lengths = input.split(",").map(String::toInt)
      val part1List = hasher.knot(part1Lengths).list

      println("Part 1 solution: ${part1List[0] * part1List[1]}")
      println("Part 2 solution: ${hasher.hash(input)}")
    }
  }

}
