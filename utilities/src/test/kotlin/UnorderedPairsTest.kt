import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldThrow
import io.kotlintest.specs.BehaviorSpec

class UnorderedPairsTest : BehaviorSpec({

  Given("an empty collection") {
    val empty: Collection<Int> = emptyList()

    When("we ask for the unordered pairs of elements in that collection") {
      Then("an IllegalStateException should be thrown") {
        shouldThrow<IllegalStateException> {
          empty.unorderedPairs()
        }
      }
    }
  }

  Given("a collection of size 1") {
    val collection: Collection<Int> = listOf(9)

    When("we ask for the unordered pairs of elements in that collection") {
      Then("an IllegalStateException should be thrown") {
        shouldThrow<IllegalStateException> {
          collection.unorderedPairs()
        }
      }
    }
  }

  Given("a collection of size 2") {
    val collection: Collection<Int> = listOf(4, 7)

    When("we ask for the unordered pairs of elements in that collection") {
      val unorderedPairs = collection.unorderedPairs()

      Then("the result should contain a single unordered pair containing the elements in the original collection") {
        unorderedPairs shouldBe setOf(setOf(4, 7))
      }
    }
  }

  Given("a collection of size 3") {
    val collection: Collection<Int> = listOf(2, 5, 8)

    When("we ask for the unordered pairs of elements in that collection") {
      val unorderedPairs = collection.unorderedPairs()

      Then("the result should contain all 3 expected pairs") {
        unorderedPairs shouldBe setOf(
            setOf(2, 5),
            setOf(2, 8),
            setOf(5, 8)
        )
      }
    }
  }

  Given("a collection of size 4") {
    val collection: Collection<Int> = listOf(3, 6, 9, 11)

    When("we ask for the unordered pairs of elements in that collection") {
      val unorderedPairs = collection.unorderedPairs()

      Then("the result should contain all 6 expected pairs") {
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
