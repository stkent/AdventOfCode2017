import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class StreamProcessorTest : BehaviorSpec({

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"{}\"") {
      val result = processor.processStream("{}")

      Then("we should receive a score of 1") {
        result.score shouldBe 1
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"{{{}}}\"") {
      val result = processor.processStream("{{{}}}")

      Then("we should receive a score of 6") {
        result.score shouldBe 6
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"{{},{}}\"") {
      val result = processor.processStream("{{},{}}")

      Then("we should receive a score of 5") {
        result.score shouldBe 5
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"{{{},{},{{}}}}\"") {
      val result = processor.processStream("{{{},{},{{}}}}")

      Then("we should receive a score of 16") {
        result.score shouldBe 16
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"{<a>,<a>,<a>,<a>}\"") {
      val result = processor.processStream("{<a>,<a>,<a>,<a>}")

      Then("we should receive a score of 1") {
        result.score shouldBe 1
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"{{<ab>},{<ab>},{<ab>},{<ab>}}\"") {
      val result = processor.processStream("{{<ab>},{<ab>},{<ab>},{<ab>}}")

      Then("we should receive a score of 9") {
        result.score shouldBe 9
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"{{<!!>},{<!!>},{<!!>},{<!!>}}\"") {
      val result = processor.processStream("{{<!!>},{<!!>},{<!!>},{<!!>}}")

      Then("we should receive a score of 9") {
        result.score shouldBe 9
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"{{<a!>},{<a!>},{<a!>},{<ab>}}\"") {
      val result = processor.processStream("{{<a!>},{<a!>},{<a!>},{<ab>}}")

      Then("we should receive a score of 3") {
        result.score shouldBe 3
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"<>\"") {
      val result = processor.processStream("<>")

      Then("we should receive a garbage count of 0") {
        result.garbageCount shouldBe 0
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"<random characters>\"") {
      val result = processor.processStream("<random characters>")

      Then("we should receive a garbage count of 17") {
        result.garbageCount shouldBe 17
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"<<<<>\"") {
      val result = processor.processStream("<<<<>")

      Then("we should receive a garbage count of 3") {
        result.garbageCount shouldBe 3
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"<{!>}>\"") {
      val result = processor.processStream("<{!>}>")

      Then("we should receive a garbage count of 2") {
        result.garbageCount shouldBe 2
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"<!!>\"") {
      val result = processor.processStream("<!!>")

      Then("we should receive a garbage count of 0") {
        result.garbageCount shouldBe 0
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"<!!!>>\"") {
      val result = processor.processStream("<!!!>>")

      Then("we should receive a garbage count of 0") {
        result.garbageCount shouldBe 0
      }
    }
  }

  Given("a stream processor") {
    val processor = StreamProcessor()

    When("we process the stream \"<{o\"i!a,<{i<a>\"") {
      val result = processor.processStream("<{o\"i!a,<{i<a>")

      Then("we should receive a garbage count of 10") {
        result.garbageCount shouldBe 10
      }
    }
  }

})
