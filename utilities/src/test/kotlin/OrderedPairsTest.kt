import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldThrow
import io.kotlintest.specs.BehaviorSpec

class OrderedPairsTest : BehaviorSpec({

  Given("An empty collection") {
    val empty: Collection<Int> = emptyList()

    When("We ask for the unordered pairs of elements in that collection") {
      Then("An IllegalStateException should be thrown") {
        shouldThrow<IllegalStateException> {
          empty.unorderedPairs()
        }
      }
    }
  }

  Given("A collection of size 1") {
    val collection: Collection<Int> = listOf(9)

    When("We ask for the unordered pairs of elements in that collection") {
      Then("An IllegalStateException should be thrown") {
        shouldThrow<IllegalStateException> {
          collection.unorderedPairs()
        }
      }
    }
  }

  Given("A collection of size 2") {
    val collection: Collection<Int> = listOf(4, 7)

    When("We ask for the ordered pairs of elements in that collection") {
      val orderedPairs = collection.orderedPairs()

      Then("The result should contain both the expected pairs") {
        orderedPairs shouldBe setOf(
            Pair(4, 7),
            Pair(7, 4)
        )
      }
    }
  }

  Given("A collection of size 3") {
    val collection: Collection<Int> = listOf(2, 5, 8)

    When("We ask for the ordered pairs of elements in that collection") {
      val orderedPairs = collection.orderedPairs()

      Then("The result should contain all 6 expected pairs") {
        orderedPairs shouldBe setOf(
            Pair(2, 5),
            Pair(2, 8),
            Pair(5, 8),
            Pair(5, 2),
            Pair(8, 2),
            Pair(8, 5)
        )
      }
    }
  }

  Given("A collection of size 4") {
    val collection: Collection<Int> = listOf(3, 6, 9, 11)

    When("We ask for the ordered pairs of elements in that collection") {
      val orderedPairs = collection.orderedPairs()

      Then("The result should contain all 12 expected pairs") {
        orderedPairs shouldBe setOf(
            Pair( 3,  6),
            Pair( 3,  9),
            Pair( 3, 11),
            Pair( 6,  9),
            Pair( 6, 11),
            Pair( 9, 11),
            Pair( 6,  3),
            Pair( 9,  3),
            Pair(11,  3),
            Pair( 9,  6),
            Pair(11,  6),
            Pair(11,  9)
        )
      }
    }
  }

})
