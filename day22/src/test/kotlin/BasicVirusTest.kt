import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class BasicVirusTest : BehaviorSpec({

  Given("a basic virus and a simple initial infection map") {
    val virus = BasicVirus()

    val rawMap = listOf(
        "..#",
        "#..",
        "..."
    )

    When("we count new infections introduced within 7 steps") {
      val count = virus.countInfections(rawMap, 7)

      Then("the result should be 5") {
        count shouldBe 5
      }
    }
  }

  Given("a basic virus and a simple initial infection map") {
    val virus = BasicVirus()

    val rawMap = listOf(
        "..#",
        "#..",
        "..."
    )

    When("we count new infections introduced within 70 steps") {
      val count = virus.countInfections(rawMap, 70)

      Then("the result should be 41") {
        count shouldBe 41
      }
    }
  }

  Given("a basic virus and a simple initial infection map") {
    val virus = BasicVirus()

    val rawMap = listOf(
        "..#",
        "#..",
        "..."
    )

    When("we count new infections introduced within 10000 steps") {
      val count = virus.countInfections(rawMap, 10000)

      Then("the result should be 5587") {
        count shouldBe 5587
      }
    }
  }

  Given("an evolved virus and a simple initial infection map") {
    val virus = EvolvedVirus()

    val rawMap = listOf(
        "..#",
        "#..",
        "..."
    )

    When("we count new infections introduced within 100 steps") {
      val count = virus.countInfections(rawMap, 100)

      Then("the result should be 26") {
        count shouldBe 26
      }
    }
  }

  Given("an evolved virus and a simple initial infection map") {
    val virus = EvolvedVirus()

    val rawMap = listOf(
        "..#",
        "#..",
        "..."
    )

    When("we count new infections introduced within 10000000 steps") {
      val count = virus.countInfections(rawMap, 10000000)

      Then("the result should be 2511944") {
        count shouldBe 2511944
      }
    }
  }

})
