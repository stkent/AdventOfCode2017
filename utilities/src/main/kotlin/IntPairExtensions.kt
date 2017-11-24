fun Pair<Int, Int>.neighbors4(): Set<Pair<Int, Int>> = setOf(
        copy(first + 1, second    ),
        copy(first - 1, second    ),
        copy(first,     second + 1),
        copy(first,     second - 1)
)

fun Pair<Int, Int>.neighbors8(): Set<Pair<Int, Int>> = neighbors4().union(setOf(
        copy(first + 1, second + 1),
        copy(first + 1, second - 1),
        copy(first - 1, second - 1),
        copy(first - 1, second + 1)
))

fun Pair<Int, Int>.l1DistanceFrom(target: Pair<Int, Int>): Int =
        Math.abs(first - target.first) + Math.abs(second - target.second)

fun Pair<Int, Int>.l2DistanceFrom(target: Pair<Int, Int>): Double =
        Math.hypot((first - target.first).toDouble(), (second - target.second).toDouble())
