import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class PatternTest : BehaviorSpec({

  Given("a pattern") {
    val pattern = Pattern(listOf(
        "##.##.",
        "#..#..",
        "......",
        "##.##.",
        "#..#..",
        "......"
    ))

    When("we count how many pixels are on") {
      val count = pattern.onCount

      Then("the result should be correct") {
        count shouldBe 12
      }
    }
  }

})
