import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class HexGridTest : BehaviorSpec({

  Given("a hex grid") {
    val grid = HexGrid()

    When("we compute the shortest distance to the end point of the path \"ne,ne,ne\"") {
      val endDistance = grid.computeDistances("ne,ne,ne").end

      Then("the result should be 3") {
        endDistance shouldBe 3
      }
    }
  }

  Given("a hex grid") {
    val grid = HexGrid()

    When("we compute the shortest distance to the end point of the path \"ne,ne,sw,sw\"") {
      val endDistance = grid.computeDistances("ne,ne,sw,sw").end

      Then("the result should be 0") {
        endDistance shouldBe 0
      }
    }
  }

  Given("a hex grid") {
    val grid = HexGrid()

    When("we compute the shortest distance to the end point of the path \"ne,ne,s,s\"") {
      val endDistance = grid.computeDistances("ne,ne,s,s").end

      Then("the result should be 2") {
        endDistance shouldBe 2
      }
    }
  }

  Given("a hex grid") {
    val grid = HexGrid()

    When("we compute the shortest distance to the end point of the path \"se,sw,se,sw,sw\"") {
      val endDistance = grid.computeDistances("se,sw,se,sw,sw").end

      Then("the result should be 3") {
        endDistance shouldBe 3
      }
    }
  }

})
