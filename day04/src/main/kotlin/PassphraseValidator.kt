class PassphraseValidator {

  fun isValidNoDuplicates(candidate: String): Boolean {
    return candidate.split(" ").allDistinct()
  }

  fun isValidNoAnagrams(candidate: String): Boolean {
    return candidate.split(" ").map { it.toCharArray().sorted() }.allDistinct()
  }

}
