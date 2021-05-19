package session7

fun main() {
//    val q10 = test(10.0)
//    println(q10.invoke(4.0))

    val segmentSalaryPairs: List<Pair<String, Double>> = listOf(
        Pair("a", 1000.0),
        Pair("b", 2000.0),
        Pair("c", 3000.0)
    )

    val grossSalaryCalculators: List<Pair<String, (Double) -> Double>> =
        segmentSalaryPairs.map { Pair(it.first, grossSalaryCalculator(it.second)) }


    println(grossSalaryCalculators[0].second.invoke(80.0))
    println(grossSalaryCalculators[1].second.invoke(90.0))
    println(grossSalaryCalculators.first { it.first == "c" }.second.invoke(100.0))

}

private fun test(number: Double): (Double) -> Double {
    val x1 = number + 10
    return { num -> num + x1 }
}

private fun grossSalaryCalculator(basicSalary: Double): (Double) -> Double {
    val tax = .2 * basicSalary
    return { bonus -> bonus + tax + basicSalary }
}