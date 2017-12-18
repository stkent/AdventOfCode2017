import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class SpinLockStopperTest : BehaviorSpec({

  Given("a spin lock stopper") {
    val stopper = SpinLockStopper()

    When("we compute the value after the final insert with step size 3 and final inserted value 2017") {
      val value = stopper.computeValueAfterLastInsert(3, 2017)

      Then("the result should be 638") {
        value shouldBe 638
      }
    }
  }

})
