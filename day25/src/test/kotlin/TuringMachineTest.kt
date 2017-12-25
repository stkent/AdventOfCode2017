import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class TuringMachineTest : BehaviorSpec({

  Given("a sample two-state machine") {
    val blueprint = listOf(
        "Begin in state A.",
        "Perform a diagnostic checksum after 6 steps.",
        "",
        "In state A:",
        "  If the current value is 0:",
        "    - Write the value 1.",
        "    - Move one slot to the right.",
        "    - Continue with state B.",
        "  If the current value is 1:",
        "    - Write the value 0.",
        "    - Move one slot to the left.",
        "    - Continue with state B.",
        "",
        "In state B:",
        "  If the current value is 0:",
        "    - Write the value 1.",
        "    - Move one slot to the left.",
        "    - Continue with state A.",
        "  If the current value is 1:",
        "    - Write the value 1.",
        "    - Move one slot to the right.",
        "    - Continue with state A."
    )

    val machine = TuringMachine(blueprint)

    When("we compute the checksum") {
      val checksum = machine.computeChecksum()

      Then("the result should be 3") {
        checksum shouldBe 3
      }
    }
  }

})
