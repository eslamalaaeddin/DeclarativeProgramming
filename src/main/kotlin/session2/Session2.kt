package session2

fun main() {
    val numbers = listOf(7, 4, 5, 6, 3, 8, 10)

    //Imperative
    for (x in numbers) { println(subtractTen(square(addOne(x)))) }

    println("\n--------------------------")

    //Declarative
    numbers
        .map(::addOne)
        .map(::square)
        .filter { it < 70 }
        .sorted()
        .take(2)
        .map(::subtractTen)
        .forEach(::println)
}

fun square(n: Int) = n * n
fun addOne(n: Int) = n + 1
fun subtractTen(n: Int) = n - 10
