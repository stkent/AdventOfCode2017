import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class EnhancerTest : BehaviorSpec({

  Given("a simple enhancer with two transforms") {
    val rawTransforms = listOf(
        "../.# => ##./#../...",
        ".#./..#/### => #..#/..../..../#..#"
    )

    val enhancer = Enhancer(rawTransforms)

    When("we enhance the example 3x3 grid once") {
      val seed = listOf(
          ".#.",
          "..#",
          "###"
      )

      val enhancedImage = enhancer.enhance(seed = seed, repeats = 1)

      Then("the result should be correct") {
        val expected = Pattern(listOf(
            "#..#",
            "....",
            "....",
            "#..#"
        ))

        enhancedImage shouldBe expected
      }
    }
  }

  Given("a simple enhancer with two transforms") {
    val rawTransforms = listOf(
        "../.# => ##./#../...",
        ".#./..#/### => #..#/..../..../#..#"
    )

    val enhancer = Enhancer(rawTransforms)

    When("we enhance the example 3x3 grid twice") {
      val seed = listOf(
          ".#.",
          "..#",
          "###"
      )

      val enhancedImage = enhancer.enhance(seed = seed, repeats = 2)

      Then("the result should be correct") {
        val expected = Pattern(listOf(
            "##.##.",
            "#..#..",
            "......",
            "##.##.",
            "#..#..",
            "......"
        ))

        enhancedImage shouldBe expected
      }
    }
  }

})
