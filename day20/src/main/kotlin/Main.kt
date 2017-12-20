import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()
      val swarm = Swarm(rawParticleStates = input)

      println("Part 1 solution: ${swarm.eventualClosest()}")
      println("Part 2 solution, probably: ${swarm.survivorCount()}")
    }
  }

}
