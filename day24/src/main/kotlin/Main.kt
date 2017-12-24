import java.io.File

class Main {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val input = File(Main::class.java.getResource("input.txt").file).readLines()
//
//      val input = listOf(
//          "0/2",
//          "2/2",
//          "2/3",
//          "3/4",
//          "3/5",
//          "0/1",
//          "10/1",
//          "9/10"
//      )

      val allComponents = input.map(Component.Companion::fromString)

//      println(Bridge(0, listOf(Component(0, 1), Component(10, 1))).rightPorts)
//      println(allComponents.filter { it.ports.contains(10) })
//
//      println(computeBridges(10, listOf(Component(9, 10))))
//
//      println("~~~~~~~~~~~~~")

      val bridges = computeBridges(0, allComponents)

//      println(bridges.joinToString("\n"))
//
//      println("~~~~~~~~~~~~~")
//
      println("Part 1 solution: ${bridges.map { it.strength }.max()}")

      val maxBridgeLength = bridges.map { it.length }.max()
      println("Part 2 solution: ${bridges.filter { it.length == maxBridgeLength }.map { it.strength }.max()}")
    }

    private fun computeBridges(leftPorts: Int, components: List<Component>): List<Bridge> {
      val starterBridges = components.filter { it.ports.contains(leftPorts) }
                                     .map    { Bridge(leftPorts, it) }

      return starterBridges + starterBridges.flatMap { bridge ->
        val extensions = computeBridges(bridge.rightPorts, components - bridge.components.last())
        return@flatMap extensions.map { extension -> bridge + extension }
      }
    }
  }

}

class Component(val leftPorts: Int, val rightPorts: Int) {

  companion object {
    fun fromString(s: String): Component {
      val counts = s.split('/')
      return Component(counts[0].toInt(), counts[1].toInt())
    }
  }

  val ports = listOf(leftPorts, rightPorts)

  override fun toString(): String {
    return "$leftPorts/$rightPorts"
  }

}

data class Bridge(val leftPorts: Int, val components: List<Component>) {

  constructor(leftPorts: Int, component: Component) : this(leftPorts, listOf(component))

  val strength = components.sumBy { it.ports.sum() }

  val length = components.size

  val rightPorts: Int by lazy {
    components.fold(leftPorts) { rightPorts, component ->
      return@lazy if (component.leftPorts == rightPorts) component.rightPorts else component.leftPorts
    }
  }

  operator fun plus(bridge: Bridge): Bridge {
    require(rightPorts == bridge.leftPorts)
    return Bridge(leftPorts, components + bridge.components)
  }

  override fun toString(): String {
    return "Bridge(${components.joinToString(",")})"
  }

}
