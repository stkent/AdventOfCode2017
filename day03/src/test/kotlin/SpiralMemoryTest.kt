import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class SpiralMemoryTest: BehaviorSpec({

  Given("a spiral memory structure") {
    val memory = SpiralMemory()

    When("we compute the distance to address 1") {
      val distance = memory.getDistanceToAddress(1)

      Then("the result should be 0") {
        distance shouldBe 0
      }
    }
  }

  Given("a spiral memory structure") {
    val memory = SpiralMemory()

    When("we compute the distance to address 12") {
      val distance = memory.getDistanceToAddress(12)

      Then("the result should be 3") {
        distance shouldBe 3
      }
    }
  }

  Given("a spiral memory structure") {
    val memory = SpiralMemory()

    When("we compute the distance to address 23") {
      val distance = memory.getDistanceToAddress(23)

      Then("the result should be 2") {
        distance shouldBe 2
      }
    }
  }

  Given("a spiral memory structure") {
    val memory = SpiralMemory()

    When("we compute the distance to address 1024") {
      val distance = memory.getDistanceToAddress(1024)

      Then("the result should be 31") {
        distance shouldBe 31
      }
    }
  }

  Given("a spiral memory structure") {
    val memory = SpiralMemory()

    When("we compute the first stress test value exceeding 1") {
      val value = memory.getFirstStressTestValueExceeding(1)

      Then("the result should be 2") {
        value shouldBe 2
      }
    }
  }

  Given("a spiral memory structure") {
    val memory = SpiralMemory()

    When("we compute the first stress test value exceeding 10") {
      val value = memory.getFirstStressTestValueExceeding(10)

      Then("the result should be 11") {
        value shouldBe 11
      }
    }
  }

  Given("a spiral memory structure") {
    val memory = SpiralMemory()

    When("we compute the first stress test value exceeding 100") {
      val value = memory.getFirstStressTestValueExceeding(100)

      Then("the result should be 122") {
        value shouldBe 122
      }
    }
  }

})
