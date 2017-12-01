import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class CaptchaCalculatorTest : BehaviorSpec({

  Given("The input 1122") {
    val calculator = CaptchaCalculator("1122")

    When("We calculate the Captcha solution using adjacent pairs") {
      val solution = calculator.getSolutionAdjacentPairs()

      Then("The solution should equal 3") {
        solution shouldBe 3
      }
    }
  }

  Given("The input 1111") {
    val calculator = CaptchaCalculator("1111")

    When("We calculate the Captcha solution using adjacent pairs") {
      val solution = calculator.getSolutionAdjacentPairs()

      Then("The solution should equal 4") {
        solution shouldBe 4
      }
    }
  }

  Given("The input 1234") {
    val calculator = CaptchaCalculator("1234")

    When("We calculate the Captcha solution using adjacent pairs") {
      val solution = calculator.getSolutionAdjacentPairs()

      Then("The solution should equal 0") {
        solution shouldBe 0
      }
    }
  }

  Given("The input 91212129") {
    val calculator = CaptchaCalculator("91212129")

    When("We calculate the Captcha solution using adjacent pairs") {
      val solution = calculator.getSolutionAdjacentPairs()

      Then("The solution should equal 9") {
        solution shouldBe 9
      }
    }
  }

  Given("The input 1212") {
    val calculator = CaptchaCalculator("1212")

    When("We calculate the Captcha solution using opposite pairs") {
      val solution = calculator.getSolutionOppositePairs()

      Then("The solution should equal 6") {
        solution shouldBe 6
      }
    }
  }

  Given("The input 1221") {
    val calculator = CaptchaCalculator("1221")

    When("We calculate the Captcha solution using opposite pairs") {
      val solution = calculator.getSolutionOppositePairs()

      Then("The solution should equal 6") {
        solution shouldBe 0
      }
    }
  }

  Given("The input 123425") {
    val calculator = CaptchaCalculator("123425")

    When("We calculate the Captcha solution using opposite pairs") {
      val solution = calculator.getSolutionOppositePairs()

      Then("The solution should equal 4") {
        solution shouldBe 4
      }
    }
  }

  Given("The input 123123") {
    val calculator = CaptchaCalculator("123123")

    When("We calculate the Captcha solution using opposite pairs") {
      val solution = calculator.getSolutionOppositePairs()

      Then("The solution should equal 12") {
        solution shouldBe 12
      }
    }
  }

  Given("The input 12131415") {
    val calculator = CaptchaCalculator("12131415")

    When("We calculate the Captcha solution using opposite pairs") {
      val solution = calculator.getSolutionOppositePairs()

      Then("The solution should equal 12") {
        solution shouldBe 4
      }
    }
  }

})
