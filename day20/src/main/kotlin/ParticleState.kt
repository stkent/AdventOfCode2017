data class ParticleState(val p: GridPoint3d, val v: GridVector3d, val a: GridVector3d) {

  companion object {
    fun parse(s: String): ParticleState? {
      val regex = Regex("p=<(-?.+),(-?.+),(-?.+)>, v=<(-?.+),(-?.+),(-?.+)>, a=<(-?.+),(-?.+),(-?.+)>")
      val groups = regex.matchEntire(s)!!.groupValues.drop(1).map { it.toInt() }

      return ParticleState(
          p = GridPoint3d(groups[0], groups[1], groups[2]),
          v = GridVector3d(groups[3], groups[4], groups[5]),
          a = GridVector3d(groups[6], groups[7], groups[8]))
    }
  }

  fun tick(): ParticleState {
    val newV = v + a
    val newP = p + newV
    return copy(p = newP, v = newV)
  }

}
