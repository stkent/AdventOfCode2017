import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class DiskTest : BehaviorSpec({

  Given("a disk with key \"flqrgnkx\"") {
    val disk = Disk("flqrgnkx")

    When("we count how many squares are 'used'") {
      val count = disk.countUsedSquares()

      Then("the result should be 8108") {
        count shouldBe 8108
      }
    }
  }

  Given("a disk with key \"flqrgnkx\"") {
    val disk = Disk("flqrgnkx")

    When("we count how many distinct groups exist") {
      val count = disk.countGroups()

      Then("the result should be 1242") {
        count shouldBe 1242
      }
    }
  }

})
