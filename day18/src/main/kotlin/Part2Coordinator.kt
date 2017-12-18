import java.util.*

class Part2Coordinator {

  fun performDuet(rawInstructions: List<String>): Int {
    val queue0To1 = LinkedList<Long>()
    val queue1To0 = LinkedList<Long>()

    val cpu0 = Part2Cpu(id = 0, inQueue = queue1To0, outQueue = queue0To1)
    val cpu1 = Part2Cpu(id = 1, inQueue = queue0To1, outQueue = queue1To0)

    cpu0.setInstructions(rawInstructions)
    cpu1.setInstructions(rawInstructions)

    while (true) {
      val cpu0DidExecute = cpu0.maybeExecuteNext()
      val cpu1DidExecute = cpu1.maybeExecuteNext()

      if (!cpu0DidExecute && !cpu1DidExecute) {
        return cpu1.sentMessageCount
      }
    }
  }

}
