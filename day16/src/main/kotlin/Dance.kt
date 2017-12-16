class Dance(private val initialOrder: String, rawMoves: List<String>) {

  private val moves = rawMoves.mapNotNull(DanceMove.Companion::fromString)

  fun computeFinalOrder(repetitions: Int): String {
    val seenOrders = mutableListOf(initialOrder)

    repeat(repetitions) {
      val newOrder = performOnce(seenOrders.last())

      if (seenOrders.contains(newOrder)) {
        return seenOrders[repetitions.rem(seenOrders.size)]
      } else {
        seenOrders.add(newOrder)
      }
    }

    return seenOrders.last()
  }

  private fun performOnce(initialOrder: String): String {
    return moves.fold(initialOrder) { order, move ->
      when (move) {
        is DanceMove.Spin     -> order.rotate(-move.size)
        is DanceMove.Exchange -> order.swap(move.index1, move.index2)
        is DanceMove.Partner  -> order.swap(order.indexOf(move.program1), order.indexOf(move.program2))
      }
    }
  }

}
