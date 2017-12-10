import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class KnotHasherTest : BehaviorSpec({

  Given("a knot hasher") {
    val hasher = KnotHasher()

    When("we knot a short input once through") {
      val result = hasher.knot(lengths = listOf(3, 4, 1, 5), inList = listOf(0, 1, 2, 3, 4)).list

      Then("the resulting list should begin with the numbers 3 and 4") {
        result[0] shouldBe 3
        result[1] shouldBe 4
      }
    }
  }

  Given("a knot hasher") {
    val hasher = KnotHasher()

    When("we hash the empty string") {
      val result = hasher.hash("")

      Then("the result should be \"a2582a3a0e66e6e86e3812dcb672a272\"") {
        result shouldBe "a2582a3a0e66e6e86e3812dcb672a272"
      }
    }
  }

  Given("a knot hasher") {
    val hasher = KnotHasher()

    When("we hash the string \"AoC 2017\"") {
      val result = hasher.hash("AoC 2017")

      Then("the result should be \"33efeb34ea91902bb2f59c9920caa6cd\"") {
        result shouldBe "33efeb34ea91902bb2f59c9920caa6cd"
      }
    }
  }

  Given("a knot hasher") {
    val hasher = KnotHasher()

    When("we hash the string \"1,2,3\"") {
      val result = hasher.hash("1,2,3")

      Then("the result should be \"3efbe78a8d82f29979031a4aa0b16a9d\"") {
        result shouldBe "3efbe78a8d82f29979031a4aa0b16a9d"
      }
    }
  }

  Given("a knot hasher") {
    val hasher = KnotHasher()

    When("we hash the string \"1,2,4\"") {
      val result = hasher.hash("1,2,4")

      Then("the result should be \"63960835bcdc130f0b66d7ff4f6a5a8e\"") {
        result shouldBe "63960835bcdc130f0b66d7ff4f6a5a8e"
      }
    }
  }

  Given("a knot hasher") {
    val hasher = KnotHasher()

    When("we hash the string \"183,0,31,146,254,240,223,150,2,206,161,1,255,232,199,88\"") {
      val result = hasher.hash("183,0,31,146,254,240,223,150,2,206,161,1,255,232,199,88")

      Then("the result should be \"90adb097dd55dea8305c900372258ac6\"") {
        result shouldBe "90adb097dd55dea8305c900372258ac6"
      }
    }
  }

})
