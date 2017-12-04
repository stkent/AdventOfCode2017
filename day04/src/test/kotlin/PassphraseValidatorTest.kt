import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class PassphraseValidatorTest : BehaviorSpec({

  Given("a passphrase validator") {
    val validator = PassphraseValidator()

    When("we check whether \"aa bb cc dd ee\" is valid under the no-duplicates policy") {
      val valid = validator.isValidNoDuplicates("aa bb cc dd ee")

      Then("the result should be true") {
        valid shouldBe true
      }
    }
  }

  Given("a passphrase validator") {
    val validator = PassphraseValidator()

    When("we check whether \"aa bb cc dd aa\" is valid under the no-duplicates policy") {
      val valid = validator.isValidNoDuplicates("aa bb cc dd aa")

      Then("the result should be false") {
        valid shouldBe false
      }
    }
  }

  Given("a passphrase validator") {
    val validator = PassphraseValidator()

    When("we check whether \"aa bb cc dd aaa\" is valid under the no-duplicates policy") {
      val valid = validator.isValidNoDuplicates("aa bb cc dd aaa")

      Then("the result should be false") {
        valid shouldBe true
      }
    }
  }

  Given("a passphrase validator") {
    val validator = PassphraseValidator()

    When("we check whether \"abcde fghij\" is valid under the no-anagrams policy") {
      val valid = validator.isValidNoAnagrams("abcde fghij")

      Then("the result should be true") {
        valid shouldBe true
      }
    }
  }

  Given("a passphrase validator") {
    val validator = PassphraseValidator()

    When("we check whether \"abcde xyz ecdab\" is valid under the no-anagrams policy") {
      val valid = validator.isValidNoAnagrams("abcde xyz ecdab")

      Then("the result should be false") {
        valid shouldBe false
      }
    }
  }

  Given("a passphrase validator") {
    val validator = PassphraseValidator()

    When("we check whether \"a ab abc abd abf abj\" is valid under the no-anagrams policy") {
      val valid = validator.isValidNoAnagrams("a ab abc abd abf abj")

      Then("the result should be true") {
        valid shouldBe true
      }
    }
  }

  Given("a passphrase validator") {
    val validator = PassphraseValidator()

    When("we check whether \"iiii oiii ooii oooi oooo\" is valid under the no-anagrams policy") {
      val valid = validator.isValidNoAnagrams("iiii oiii ooii oooi oooo")

      Then("the result should be true") {
        valid shouldBe true
      }
    }
  }

  Given("a passphrase validator") {
    val validator = PassphraseValidator()

    When("we check whether \"oiii ioii iioi iiio\" is valid under the no-anagrams policy") {
      val valid = validator.isValidNoAnagrams("oiii ioii iioi iiio")

      Then("the result should be false") {
        valid shouldBe false
      }
    }
  }

})
