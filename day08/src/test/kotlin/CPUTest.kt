import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class CPUTest : BehaviorSpec({

  Given("a CPU") {
    val cpu = CPU()

    When("we execute a short set of instructions") {
      val result = cpu.execute(listOf(
          "b inc 5 if a > 1",
          "a inc 1 if b < 5",
          "c dec -10 if a >= 1",
          "c inc -20 if c == 10"
      ))

      Then("the max end value should be 1 and the max execution value should be 10") {
        result.maxEndValue  shouldBe 1
        result.maxExecValue shouldBe 10
      }
    }
  }

})
