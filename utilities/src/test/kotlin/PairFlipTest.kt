import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class PairFlipTest : BehaviorSpec({

  Given("a pair (a, a)") {
    val a = 1
    val pair = Pair(a, a)

    When("we flip the pair") {
      val flippedPair = pair.flip()

      Then("the result should be equal to the original pair") {
        flippedPair shouldBe pair
      }
    }
  }

  Given("a pair (a, b) with a != b") {
    val a = 1
    val b = 2
    assert(a != b)

    val pair = Pair(a, b)

    When("we flip the pair") {
      val flippedPair = pair.flip()

      Then("the result should be the pair (b, a)") {
        flippedPair shouldBe Pair(b, a)
      }
    }
  }

})
