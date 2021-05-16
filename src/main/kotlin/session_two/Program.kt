package session_two

fun main() {
    val numbers = listOf(7, 4, 5, 6, 3, 8, 10)

    //Imperative
    numbers.forEach { n -> print("${subtractTen(square(addOne(n)))} ") }

    println("\n--------------------------")

    //Declarative
    println(numbers.map { n -> addOne(n) }
        .map { n -> square(n) }
        .filter { n -> n < 70 }
        .sorted()
        .take(2)
        .map { n -> subtractTen(n) }
    )

}

fun square(n: Int) = n * n
fun addOne(n: Int) = n + 1
fun subtractTen(n: Int) = n - 10