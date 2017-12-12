import java.util.*

class GraphGrouper {

  fun computeGroups(pipeStrings: List<String>): Set<Set<Int>> {
    val pipeMap = pipeStrings.flatMap(Pipe.Companion::stringToPipes)
                             .groupBy(Pipe::startId) { pipe -> pipe.endId }

    val pendingPipeMap = mutableMapOf<Int, List<Int>>()
    pendingPipeMap.putAll(pipeMap)

    val allGroups = mutableSetOf<Set<Int>>()

    while (pendingPipeMap.isNotEmpty()) {
      val newId    = pendingPipeMap.keys.first()
      val newGroup = computeGroupFromId(newId, pendingPipeMap)

      allGroups.add(newGroup)

      pendingPipeMap.removeAll(newGroup)
    }

    return allGroups
  }

  private fun computeGroupFromId(id: Int, pipeMap: Map<Int, List<Int>>): Set<Int> {
    val unseenIds = ArrayDeque<Int>()
    val seenIds   = mutableSetOf<Int>()

    unseenIds.addFirst(id)

    while (unseenIds.peekFirst() != null) {
      val startId      = unseenIds.pollFirst()
      val unseenEndIds = pipeMap[startId]!!.filterNot { seenIds.contains(it) }

      unseenIds.addAll(unseenEndIds)
      seenIds.add(startId)
    }

    return seenIds
  }

}

private data class Pipe(val startId: Int, val endId: Int) {

  companion object {
    fun stringToPipes(string: String): List<Pipe> {
      val sides = string.split(" <-> ")

      val startId = sides[0].toInt()
      val endIds  = sides[1].split(", ").map(String::toInt)

      return endIds.map { endId -> Pipe(startId, endId) }
    }
  }

}
