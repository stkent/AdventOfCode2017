typealias GridPoint = Pair<Int, Int>

fun GridPoint.neighbors4(): Set<GridPoint> = setOf(
    copy(first + 1, second),
    copy(first - 1, second),
    copy(first, second + 1),
    copy(first, second - 1)
)

fun GridPoint.neighbors8(): Set<GridPoint> = neighbors4().union(setOf(
    copy(first + 1, second + 1),
    copy(first + 1, second - 1),
    copy(first - 1, second - 1),
    copy(first - 1, second + 1)
))

fun GridPoint.l1DistanceFrom(target: GridPoint): Int =
    Math.abs(first - target.first) + Math.abs(second - target.second)

fun GridPoint.l2DistanceFrom(target: GridPoint): Double =
    Math.hypot((first - target.first).toDouble(), (second - target.second).toDouble())
