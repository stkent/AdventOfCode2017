class Swarm(rawParticleStates: List<String>) {

  private val particleStates = rawParticleStates.mapNotNull(ParticleState.Companion::parse).toMutableList()

  fun eventualClosest(): Int {
    val comparator = compareBy<ParticleState>(
        { it.a.l1Magnitude },
        { it.v.l1Magnitude },
        { it.p.l1DistanceTo(GridPoint3d.origin) })

    val closest = particleStates.sortedWith(comparator).first()
    return particleStates.indexOf(closest)
  }

  fun survivorCount(): Int {
    repeat(1000) {
      particleStates.forEachIndexed { i, state -> particleStates[i] = state.tick() }

      val collisions = particleStates.map { it.p }.elementCounts().filter { it.value > 1 }.keys
      collisions.forEach { position -> particleStates.removeIf { state -> state.p == position } }
    }

    return particleStates.size
  }

}
