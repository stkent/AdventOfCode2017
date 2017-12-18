import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class DanceTest : BehaviorSpec({

  Given ("a dance consisting of a single spin") {
    val dance = Dance("abcde", listOf("s1"))

    When("we compute the final program order after performing that dance once") {
      val finalOrder = dance.computeFinalOrder(repetitions = 1)

      Then("the order should be correct") {
        finalOrder shouldBe "eabcd"
      }
    }
  }

  Given ("a dance consisting of a single exchange") {
    val dance = Dance("eabcd", listOf("x3/4"))

    When("we compute the final program order after performing that dance once") {
      val finalOrder = dance.computeFinalOrder(repetitions = 1)

      Then("the order should be correct") {
        finalOrder shouldBe "eabdc"
      }
    }
  }

  Given ("a dance consisting of a single partner") {
    val dance = Dance("eabdc", listOf("pe/b"))

    When("we compute the final program order after performing that dance once") {
      val finalOrder = dance.computeFinalOrder(repetitions = 1)

      Then("the order should be correct") {
        finalOrder shouldBe "baedc"
      }
    }
  }

  Given ("a short dance") {
    val dance = Dance("abcde", listOf("s1","x3/4","pe/b"))

    When("we compute the final program order after performing that dance once") {
      val finalOrder = dance.computeFinalOrder(repetitions = 1)

      Then("the order should be correct") {
        finalOrder shouldBe "baedc"
      }
    }
  }

})
