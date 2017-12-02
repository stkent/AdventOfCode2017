import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class SpreadsheetTest : BehaviorSpec({

  Given("A small example spreadsheet") {
    val rawData = listOf(
        "5\t1\t9\t5",
        "7\t5\t3",
        "2\t4\t6\t8"
    )

    val spreadsheet = Spreadsheet(rawData)

    When("We calculate the checksum of the spreadsheet") {
      val checksum = spreadsheet.checksum

      Then("The result should be 18") {
        checksum shouldBe 18
      }
    }
  }

  Given("Another small example spreadsheet") {
    val rawData = listOf(
        "5\t9\t2\t8",
        "9\t4\t7\t3",
        "3\t8\t6\t5"
    )

    val spreadsheet = Spreadsheet(rawData)

    When("We calculate the sum of divisible entries of the spreadsheet") {
      val checksum = spreadsheet.sumOfDivisibleEntries

      Then("The result should be 9") {
        checksum shouldBe 9
      }
    }
  }

})
