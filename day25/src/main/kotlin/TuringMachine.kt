class TuringMachine(blueprint: List<String>) {

  private val initialState by lazy {
    Regex("Begin in state (\\w)\\.")
        .matchEntire(blueprint[0])!!
        .groupValues[1]
  }

  private val stepCount by lazy {
    Regex("Perform a diagnostic checksum after (\\d+) steps\\.")
        .matchEntire(blueprint[1])!!
        .groupValues[1]
        .toInt()
  }

  private val stateActionMap = blueprint.drop(3).chunked(10).map { lines ->
    val name      = Regex("In state (\\w):").matchEntire(lines.first())!!.groupValues[1]
    val offAction = Action.parse(lines.slice(2..4))
    val onAction  = Action.parse(lines.slice(6..8))

    return@map Pair(name, StateActions(offAction, onAction))
  }.toMap()

  fun computeChecksum(): Int {
    var state = initialState
    val tape  = mutableSetOf<Int>()
    var index = 0

    repeat(stepCount) {
      val current = tape.contains(index)
      val action  = stateActionMap[state]!!.get(current)

      if (action.on) tape.add(index) else tape.remove(index)
      index += action.move
      state =  action.state
    }

    return tape.count()
  }

}
