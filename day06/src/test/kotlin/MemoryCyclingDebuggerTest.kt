import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class MemoryCyclingDebuggerTest : BehaviorSpec({

  Given("a memory cycling debugger") {
    val debugger = MemoryCyclingDebugger()

    When("debugging with initial block counts `2 4 1 2`") {
      val result = debugger.debug(listOf(2, 4, 1, 2))

      Then("it should be reported that a memory configuration is first repeated after 5 redistributions") {
        result.cyclesToRepeat shouldBe 5
      }
    }
  }

  Given("a memory cycling debugger") {
    val debugger = MemoryCyclingDebugger()

    When("debugging with initial block counts `2 4 1 2`") {
      val result = debugger.debug(listOf(2, 4, 1, 2))

      Then("it should be reported that memory configuration first loops after 4 redistributions") {
        result.loopLength shouldBe 4
      }
    }
  }

})
