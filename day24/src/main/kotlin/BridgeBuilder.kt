class BridgeBuilder(rawComponents: List<String>) {

  private val allComponents = rawComponents.map(Link.Companion::parse)
  private val allBridges by lazy { computeBridges(0, allComponents).toSet() }

  fun strongestBridge() = allBridges.maxBy { it.strength }!!

  fun strongestLongestBridge(): Bridge {
    return allBridges.maxWith(compareBy(Bridge::length) then compareBy(Bridge::strength))!!
  }

  private fun computeBridges(lPorts: Int, links: List<Link>): List<Bridge> {
    val heads = links.filter { it.ports.contains(lPorts) }
                     .map    { Bridge(lPorts, it) }

    return heads + heads.flatMap { head ->
      val tails = computeBridges(head.portsR, links - head.links.last())
      return@flatMap tails.map { tail -> head + tail }
    }
  }

}
