package session3


fun main() {
    //val doubleLambda = { number: Double -> number }

//    //Regular invocation
//    println(test2(test1(5.0)))
//    println(test1(test2(5.0)))
//
//    //Using HOF
//    println(test3(test1(5.0), doubleLambda, 5.0))
//    println(test3(test2(5.0), doubleLambda, 5.0))

    val product = Product.RAW_MATERIAL
    val order = Order(10, 100, 20, 4)

    val parameters =
        if (product == Product.FOOD) getFoodParameters() else (if (product == Product.BEVERAGE) getBeverageParameters() else getRawMaterialParameters())

    println(calculateDiscount(parameters, order))
}

enum class Product { FOOD, BEVERAGE, RAW_MATERIAL }

fun test1(x: Double): Double = x / 2

fun test2(x: Double): Double = x / 4 + 1

fun test3(num1: Double, doubleLambda: (Double) -> Double, num2: Double): Double {
    return doubleLambda.invoke(num1) + num2
}

private fun getFoodParameters() =
    { productIndex: Int -> Pair(productIndex / productIndex + 100.0, productIndex / productIndex + 300.0) }

private fun getBeverageParameters() =
    { productIndex: Int -> Pair(productIndex / productIndex + 300.0, productIndex / productIndex + 400.0) }

private fun getRawMaterialParameters() =
    { productIndex: Int -> Pair(productIndex / productIndex + 400.0, productIndex / productIndex + 700.0) }

private fun calculateDiscount(lambdaCalcParameters: (Int) -> Pair<Double, Double>, order: Order): Double {
    val parameters = lambdaCalcParameters(order.productIndex)
    return parameters.first * order.quantity + parameters.second * order.unitPrice
}

