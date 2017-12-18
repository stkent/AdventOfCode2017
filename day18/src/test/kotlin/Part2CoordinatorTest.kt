import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class Part2CoordinatorTest : BehaviorSpec({

  Given("a coordinator") {
    val cpu = Part2Coordinator()

    When("we count the number of times program 1 sent a value while running two instances of a short program") {
      val count = cpu.performDuet(listOf(
          "snd 1",
          "snd 2",
          "snd p",
          "rcv a",
          "rcv b",
          "rcv c",
          "rcv d"
      ))

      Then("the result should be 3") {
        count shouldBe 3
      }
    }
  }


})
