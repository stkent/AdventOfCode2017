class Tower(rawData: List<String>) {

  // Nested types --------------------------------------------------------------------------------------------------- //

  private data class ProgramDetails(val weight: Int, val children: Set<String>)
  private data class Program(val name: String, val weight: Int, val children: Set<Program>)
  private data class BalanceInfo(val program: Program, val goodChildWeight: Int, val badChild: Program?)

  // Instance variables, initialized at construction time ----------------------------------------------------------- //

  private val allProgramDetails: Map<String, ProgramDetails> = parseProgramDetails(rawData)
  val rootProgramName: String = computeRootProgramName(allProgramDetails)
  private val tree: Program = buildTree(allProgramDetails, rootProgramName)

  // Initialization methods ----------------------------------------------------------------------------------------- //

  private fun parseProgramDetails(rawData: List<String>): Map<String, ProgramDetails> {
    val regex = Regex("(\\w+) \\((\\d+)\\)(?: -> (.+))?")

    val result = mutableMapOf<String, ProgramDetails>()

    rawData.forEach {
      val groups = regex.matchEntire(it)!!.groupValues
      val programName = groups[1]
      val programWeight = groups[2].toInt()
      val children = if (groups[3].isNotEmpty()) groups[3].split(", ").toSet() else emptySet()

      result.put(programName, ProgramDetails(programWeight, children))
    }

    return result
  }

  private fun computeRootProgramName(allProgramDetails: Map<String, ProgramDetails>): String {
    val allProgramNames = allProgramDetails.keys.toSet()
    val childProgramNames = allProgramDetails.values.map { it.children }.flatten().toSet()

    // Assumes exactly one result:
    return (allProgramNames - childProgramNames).first()
  }

  private fun buildTree(allProgramDetails: Map<String, ProgramDetails>, rootProgramName: String): Program {
    return buildNode(allProgramDetails, rootProgramName)
  }

  private fun buildNode(allProgramDetails: Map<String, ProgramDetails>, programName: String): Program {
    val programDetails = allProgramDetails[programName]!!

    return Program(
        programName,
        programDetails.weight,
        programDetails.children.map { buildNode(allProgramDetails, it) }.toSet())
  }

  // Post-initialization public methods ----------------------------------------------------------------------------- //

  fun computeWeightAdjustment(): Int {
    // Root is guaranteed to not be balanced.
    val rootBalanceInfo = computeBalanceInfo(tree)

    val balanceInfoList = mutableListOf(rootBalanceInfo)
    var currentBadChild = balanceInfoList.last().badChild

    // Iterate until we find a balanced subtree or hit a leaf.
    while (currentBadChild != null && currentBadChild.children.isNotEmpty()) {
      balanceInfoList.add(computeBalanceInfo(balanceInfoList.last().badChild!!))
      currentBadChild = balanceInfoList.last().badChild
    }

    val lastUnbalancedProgramInfo = balanceInfoList.last()

    return if (lastUnbalancedProgramInfo.badChild != null) {
      // Leaf program has the wrong weight.
      lastUnbalancedProgramInfo.goodChildWeight
    } else {
      // Non-leaf program has the wrong weight.
      val badProgram = lastUnbalancedProgramInfo.program
      val rootProgramInfo = balanceInfoList.first()
      val adjustmentSize = rootProgramInfo.goodChildWeight - accWeight(rootProgramInfo.badChild!!)
      badProgram.weight + adjustmentSize
    }
  }

  // Post-initialization private methods ---------------------------------------------------------------------------- //

  // Computes balance info for the given program.
  private fun computeBalanceInfo(program: Program): BalanceInfo {
    val children = program.children

    require(children.isNotEmpty()) { "This method can only be called on programs with children." }

    val weightCounts = children.map { accWeight(it) }.elementCounts()
    val goodChildAccWeight = weightCounts.filter { it.value != 1 }.map { it.key }.first()
    val badChild = children.firstOrNull { accWeight(it) != goodChildAccWeight }

//    TODO: this buggy line (replaces previous^) is not caught by the current test suite but breaks for real input.
//    val badChild = children.firstOrNull { it.weight != goodChildAccWeight }

    return BalanceInfo(program, goodChildAccWeight, badChild)
  }

  // Recursively computes the accumulated weight of a program and its children.
  private fun accWeight(program: Program): Int {
    return program.weight + program.children.map { accWeight(it) }.sum()
  }

}
