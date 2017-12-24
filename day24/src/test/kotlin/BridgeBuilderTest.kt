import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class BridgeBuilderTest : BehaviorSpec({

  Given("a short list of links and a bridge builder") {
    val links = listOf(
        "0/2",
        "2/2",
        "2/3",
        "3/4",
        "3/5",
        "0/1",
        "10/1",
        "9/10"
    )

    val builder = BridgeBuilder(links)

    When("we compute the strongest valid bridge") {
      val strength = builder.strongestBridge().strength

      Then("the result should be correct") {
        strength shouldBe 31
      }
    }
  }

  Given("a short list of links and a bridge builder") {
    val links = listOf(
        "0/2",
        "2/2",
        "2/3",
        "3/4",
        "3/5",
        "0/1",
        "10/1",
        "9/10"
    )

    val builder = BridgeBuilder(links)

    When("we compute the strongest valid bridge of maximum length") {
      val strength = builder.strongestLongestBridge().strength

      Then("the result should be correct") {
        strength shouldBe 19
      }
    }
  }

})
