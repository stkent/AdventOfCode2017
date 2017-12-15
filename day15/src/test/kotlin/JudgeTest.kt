import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class JudgeTest : BehaviorSpec({

  Given("a judge") {
    val judge = Judge()

    When("""- we seed generator A with 65 and generator B with 8921,
            - we accept all generated values, and
            - we count matches in the first 40 million pairs""") {

      val count = judge.countMatches(
          Generator.GeneratorA(seed = 65,   accept = { true }),
          Generator.GeneratorB(seed = 8921, accept = { true }),
          40_000_000)

      Then("the result should be 588") {
        count shouldBe 588
      }
    }
  }

  Given("a judge") {
    val judge = Judge()

    When("""- we seed generator A with 65 and generator B with 8921,
            - we accept specific generated values, and
            - we count matches in the first 5 million pairs""") {

      val count = judge.countMatches(
          Generator.GeneratorA(seed = 65,   accept = { it.rem(4) == 0L }),
          Generator.GeneratorB(seed = 8921, accept = { it.rem(8) == 0L }),
          5_000_000)

      Then("the result should be 309") {
        count shouldBe 309
      }
    }
  }

})
