import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class FirewallTest : BehaviorSpec({

  Given("a simple firewall") {
    val firewall = Firewall(listOf(
        "0: 3",
        "1: 2",
        "4: 4",
        "6: 4"
    ))

    When("we compute the score incurred by departing immediately") {
      val score = firewall.scoreForDelay(0)

      Then("the result should be 24") {
        score shouldBe 24
      }
    }
  }

  Given("a simple firewall") {
    val firewall = Firewall(listOf(
        "0: 3",
        "1: 2",
        "4: 4",
        "6: 4"
    ))

    When("we compute the earliest departure time for escape") {
      val score = firewall.firstEscapeDelay()

      Then("the result should be 10") {
        score shouldBe 10
      }
    }
  }

})
