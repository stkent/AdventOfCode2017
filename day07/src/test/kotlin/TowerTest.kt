import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class TowerTest : BehaviorSpec({

  Given("a small example tower") {
    val tower = Tower(listOf(
        "pbga (66)",
        "xhth (57)",
        "ebii (61)",
        "havc (66)",
        "ktlj (57)",
        "fwft (72) -> ktlj, cntj, xhth",
        "qoyq (66)",
        "padx (45) -> pbga, havc, qoyq",
        "tknk (41) -> ugml, padx, fwft",
        "jptl (61)",
        "ugml (68) -> gyxo, ebii, jptl",
        "gyxo (61)",
        "cntj (57)"
    ))

    When("we compute the root program name") {
      val rootProgramName = tower.rootProgramName

      Then("the result should be \"tknk\"") {
        rootProgramName shouldBe "tknk"
      }
    }
  }

  Given("a tower with two levels and an incorrectly-weighted leaf program") {
    val tower = Tower(listOf(
        "aaa (1) -> bbb, ccc, ddd",
        "bbb (2)",
        "ccc (1)",
        "ddd (1)"
    ))

    When("we compute the weight adjustment needed to balance the tower") {
      val weightAdjustment = tower.computeWeightAdjustment()

      Then("the adjusted weight should be 1") {
        weightAdjustment shouldBe 1
      }
    }
  }

  Given("a tower with three levels and an incorrectly-weighted leaf program") {
    val tower = Tower(listOf(
        "aaa (1) -> bbb, ccc, ddd",
        "bbb (1) -> eee, fff, ggg",
        "ccc (1) -> hhh, iii, jjj",
        "ddd (1) -> kkk, mmm, nnn",
        "eee (2)",
        "fff (1)",
        "ggg (1)",
        "hhh (1)",
        "iii (1)",
        "jjj (1)",
        "kkk (1)",
        "mmm (1)",
        "nnn (1)"
    ))

    When("we compute the weight adjustment needed to balance the tower") {
      val weightAdjustment = tower.computeWeightAdjustment()

      Then("the adjusted weight should be 1") {
        weightAdjustment shouldBe 1
      }
    }
  }

  Given("a tower with three levels and an incorrectly-weighted non-leaf program") {
    val tower = Tower(listOf(
        "aaa (1) -> bbb, ccc, ddd",
        "bbb (2) -> eee, fff, ggg",
        "ccc (1) -> hhh, iii, jjj",
        "ddd (1) -> kkk, mmm, nnn",
        "eee (1)",
        "fff (1)",
        "ggg (1)",
        "hhh (1)",
        "iii (1)",
        "jjj (1)",
        "kkk (1)",
        "mmm (1)",
        "nnn (1)"
    ))

    When("we compute the weight adjustment needed to balance the tower") {
      val weightAdjustment = tower.computeWeightAdjustment()

      Then("the adjusted weight should be 1") {
        weightAdjustment shouldBe 1
      }
    }
  }

  Given("a small example tower") {
    val tower = Tower(listOf(
        "pbga (66)",
        "xhth (57)",
        "ebii (61)",
        "havc (66)",
        "ktlj (57)",
        "fwft (72) -> ktlj, cntj, xhth",
        "qoyq (66)",
        "padx (45) -> pbga, havc, qoyq",
        "tknk (41) -> ugml, padx, fwft",
        "jptl (61)",
        "ugml (68) -> gyxo, ebii, jptl",
        "gyxo (61)",
        "cntj (57)"
    ))

    When("we compute the weight adjustment needed to balance the tower") {
      val weightAdjustment = tower.computeWeightAdjustment()

      Then("the adjusted weight should be 60") {
        weightAdjustment shouldBe 60
      }
    }
  }

})
