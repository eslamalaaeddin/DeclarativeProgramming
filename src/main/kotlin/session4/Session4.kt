package session4

import session3.Order

val isAQualified: (Order) -> Boolean = { order: Order -> true }
val calcA: (Order) -> Double = { order: Order -> 10.0 }

val isBQualified: (Order) -> Boolean = { order: Order -> true }
val calcB: (Order) -> Double = { order: Order -> 20.0 }

val isCQualified: (Order) -> Boolean = { order: Order -> true }
val calcC: (Order) -> Double = { order: Order -> 30.0 }

//If we want to add a new rule and add a new pair containing them to rules list
//val isDQualified: (Order) -> Boolean = { order: Order -> true }
//val calcD: (Order) -> Double = { order: Order -> 3=40.0 }

fun main() {

    val orders = listOf(
        Order(1, 100, 10, 10),
        Order(2, 200, 20, 20),
        Order(3, 300, 30, 30),
        Order(4, 400, 40, 40),
        Order(5, 500, 50, 50),
        Order(6, 600, 60, 60),
        Order(7, 700, 70, 70),
        Order(8, 800, 80, 80),
        Order(9, 900, 90, 90),
    )

    val rules: List<Pair<(Order) -> Boolean, (Order) -> Double>> = listOf(
        Pair(isAQualified, calcA),
        Pair(isBQualified, calcB),
        Pair(isCQualified, calcC)
    )

    orders.forEach { order -> println(getOrderWithDiscount(order, rules)) }


}

fun getOrderWithDiscount(order: Order, rules: List<Pair<(Order) -> Boolean, (Order) -> Double>>): Order {
    val discount: Double = rules
        .filter { pair -> pair.first.invoke(order) }
        .map { pair -> pair.second.invoke(order) }
        .sorted()
        .take(3)
        .average()

    //Will be replaced -- Immutability concept
    val newOrder: Order = order.copy()
    newOrder.disocunt = discount

    return newOrder
}
