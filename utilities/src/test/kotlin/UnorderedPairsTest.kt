import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldThrow
import io.kotlintest.specs.BehaviorSpec

class UnorderedPairsTest : BehaviorSpec({

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

    When("We ask for the unordered pairs of elements in that collection") {
      val unorderedPairs = collection.unorderedPairs()

      Then("The result should contain a single unordered pair containing the elements in the original collection") {
        unorderedPairs shouldBe setOf(setOf(4, 7))
      }
    }
  }

  Given("A collection of size 3") {
    val collection: Collection<Int> = listOf(2, 5, 8)

    When("We ask for the unordered pairs of elements in that collection") {
      val unorderedPairs = collection.unorderedPairs()

      Then("The result should contain all 3 expected pairs") {
        unorderedPairs shouldBe setOf(
            setOf(2, 5),
            setOf(2, 8),
            setOf(5, 8)
        )
      }
    }
  }

  Given("A collection of size 4") {
    val collection: Collection<Int> = listOf(3, 6, 9, 11)

    When("We ask for the unordered pairs of elements in that collection") {
      val unorderedPairs = collection.unorderedPairs()

      Then("The result should contain all 6 expected pairs") {
        unorderedPairs shouldBe setOf(
            setOf(3, 6),
            setOf(3, 9),
            setOf(3, 11),
            setOf(6, 9),
            setOf(6, 11),
            setOf(9, 11)
        )
      }
    }
  }

})
