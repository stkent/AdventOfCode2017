import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class Part1CpuTest : BehaviorSpec({

  Given("a CPU") {
    val cpu = Part1Cpu()

    When("we compute the frequency of the last sound played for a short program") {
      val firstRecover = cpu.findFirstNonZeroRecover(listOf(
          "set a 1",
          "add a 2",
          "mul a a",
          "mod a 5",
          "snd a",
          "set a 0",
          "rcv a",
          "jgz a -1",
          "set a 1",
          "jgz a -2"
      ))

      Then("the result should be 4") {
        firstRecover shouldBe 4L
      }
    }
  }

})
