import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class RouterTest : BehaviorSpec({

  Given("a router") {
    val router = Router()

    When("we route through a small example diagram") {
      val result = router.route(listOf(
          "     |          ",
          "     |  +--+    ",
          "     A  |  C    ",
          " F---|----E|--+ ",
          "     |  |  |  D ",
          "     +B-+  +--+ ",
          "                "
      ))

      Then("the characters encountered, in order, should be \"ABCDEF\"") {
        result.chars shouldBe "ABCDEF"
      }
    }
  }

  Given("a router") {
    val router = Router()

    When("we route through a small example diagram") {
      val result = router.route(listOf(
          "     |          ",
          "     |  +--+    ",
          "     A  |  C    ",
          " F---|----E|--+ ",
          "     |  |  |  D ",
          "     +B-+  +--+ ",
          "                "
      ))

      Then("the number of steps taken should be 38") {
        result.nSteps shouldBe 38
      }
    }
  }

})
