import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class DanceTest : BehaviorSpec({

  Given ("") {
    val dance = Dance("abcde", listOf("s1"))

    When("") {
      val finalOrder = dance.computeFinalOrder(repetitions = 1)

      Then("") {
        finalOrder shouldBe "eabcd"
      }
    }
  }

  Given ("") {
    val dance = Dance("eabcd", listOf("x3/4"))

    When("") {
      val finalOrder = dance.computeFinalOrder(repetitions = 1)

      Then("") {
        finalOrder shouldBe "eabdc"
      }
    }
  }

  Given ("") {
    val dance = Dance("eabdc", listOf("pe/b"))

    When("") {
      val finalOrder = dance.computeFinalOrder(repetitions = 1)

      Then("") {
        finalOrder shouldBe "baedc"
      }
    }
  }

  Given ("") {
    val dance = Dance("abcde", listOf("s1","x3/4","pe/b"))

    When("") {
      val finalOrder = dance.computeFinalOrder(repetitions = 1)

      Then("") {
        finalOrder shouldBe "baedc"
      }
    }
  }

})
