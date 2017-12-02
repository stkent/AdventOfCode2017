import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class PairFlipTest : BehaviorSpec({

  Given("A pair (a, a)") {
    val a = 1
    val pair = Pair(a, a)

    When("We flip the pair") {
      val flippedPair = pair.flip()

      Then("The result should be equal to the original pair") {
        flippedPair shouldBe pair
      }
    }
  }

  Given("A pair (a, b) with a != b") {
    val a = 1
    val b = 2
    assert(a != b)

    val pair = Pair(a, b)

    When("We flip the pair") {
      val flippedPair = pair.flip()

      Then("The result should be the pair (b, a)") {
        flippedPair shouldBe Pair(b, a)
      }
    }
  }

})
