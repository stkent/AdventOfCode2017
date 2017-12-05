import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class CPUTest: BehaviorSpec({

  Given("a CPU") {
    val cpu = CPU()

    When("we compute the number of steps required to exit the instructions `0 3 0 1 -3` when adding 1") {
      val stepCount = cpu.stepsToExitAdding1(listOf(0, 3, 0, 1, -3))

      Then("the result should be 5") {
        stepCount shouldBe 5
      }
    }
  }

  Given("a CPU") {
    val cpu = CPU()

    When("we compute the number of steps required to exit the instructions `0 3 0 1 -3` when adding or subtracting 1") {
      val stepCount = cpu.stepsToExitAddingOrSubtracting1(listOf(0, 3, 0, 1, -3))

      Then("the result should be 10") {
        stepCount shouldBe 10
      }
    }
  }

})
