data class Action(val on: Boolean, val move: Int, val state: String) {

  companion object {
    fun parse(l: List<String>): Action {
      val write  = Regex("\\s*- Write the value (\\w)\\."            ).matchEntire(l[0])!!.groupValues[1]
      val move   = Regex("\\s*- Move one slot to the (right|left)\\.").matchEntire(l[1])!!.groupValues[1]
      val state  = Regex("\\s*- Continue with state (\\w)\\."        ).matchEntire(l[2])!!.groupValues[1]

      return Action(
          on    = write.toInt() == 1,
          move  = if (move == "right") 1 else - 1,
          state = state)
    }
  }

}

data class StateActions(private val offAction: Action, private val onAction: Action) {

  fun get(current: Boolean): Action = if (current) onAction else offAction

}
