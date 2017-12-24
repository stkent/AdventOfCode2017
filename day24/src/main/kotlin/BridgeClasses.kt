class Link(val portsL: Int, val portsR: Int) {

  companion object {
    fun parse(s: String): Link {
      val counts = s.split('/')
      return Link(counts[0].toInt(), counts[1].toInt())
    }
  }

  val ports = listOf(portsL, portsR)

}

data class Bridge(private val portsL: Int, val links: List<Link>) {

  constructor(portsL: Int, link: Link) : this(portsL, listOf(link))

  val length   = links.size
  val strength = links.sumBy { it.ports.sum() }

  val portsR by lazy {
    links.fold(portsL) { rPorts, link ->
      return@lazy if (link.portsL == rPorts) link.portsR else link.portsL
    }
  }

  operator fun plus(bridge: Bridge): Bridge {
    require(portsR == bridge.portsL)
    return Bridge(portsL, links + bridge.links)
  }

}
