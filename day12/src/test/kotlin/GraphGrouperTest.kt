import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class GraphGrouperTest : BehaviorSpec({

  Given("a graph grouper") {
    val graphGrouper = GraphGrouper()

    When("we group a small example graph") {
      val pipeStrings = listOf(
          "0 <-> 2",
          "1 <-> 1",
          "2 <-> 0, 3, 4",
          "3 <-> 2, 4",
          "4 <-> 2, 3, 6",
          "5 <-> 6",
          "6 <-> 4, 5"
      )

      val groups = graphGrouper.computeGroups(pipeStrings)

      Then("we should be returned 2 groups") {
        groups.size shouldBe 2
      }
    }
  }

  Given("a graph grouper") {
    val graphGrouper = GraphGrouper()

    When("we group a small example graph") {
      val pipeStrings = listOf(
          "0 <-> 2",
          "1 <-> 1",
          "2 <-> 0, 3, 4",
          "3 <-> 2, 4",
          "4 <-> 2, 3, 6",
          "5 <-> 6",
          "6 <-> 4, 5"
      )

      val groups = graphGrouper.computeGroups(pipeStrings)

      Then("the graph containing id 0 should have size 6") {
        groups.first { group -> group.contains(0) }.size shouldBe 6
      }
    }
  }

})
