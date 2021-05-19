package session5

val myData = listOf(3.0, 5.0, 7.0, 8.0)

fun main() {
//    val myFunctionTest: (Double) -> Double = test()
//    println(myFunctionTest.invoke(1.0))


    println(myData
        .map { n -> addOne(n) }
        .map { n -> square(n) }
        .map { n -> subtractTen(n) })


    //Compact
    println(myData.map { n -> subtractTen(square(addOne(n))) })


    //Composed
    println(myData.map { n -> myComposedFunction().invoke(n) })


    //Using the beautiful composer :)
    println(myData.map { n -> addOneSquareSubtractTen().invoke(n) })

}

//fun test(): (Double) -> Double = { x: Double -> x + 1 }

fun addOne(num: Double) = num + 1
fun square(num: Double) = num * num
fun subtractTen(num: Double) = num - 10

val lambdaAddOne: (Double) -> Double = { n -> n + 1 }
val lambdaSquare: (Double) -> Double = { n -> n * n }
val lambdaSubtractTen: (Double) -> Double = { n -> n - 10 }

fun myComposedFunction(): (Double) -> Double = composeFunction(lambdaAddOne, lambdaSquare, lambdaSubtractTen)

fun composeFunction(
    addOne: (Double) -> Double,
    square: (Double) -> Double,
    subtractTen: (Double) -> Double
): (Double) -> Double {
    return { number -> subtractTen.invoke(square.invoke(addOne.invoke(number))) }
}

fun addOneSquareSubtractTen(): (Double) -> Double{
    return compose(compose(lambdaAddOne, lambdaSquare), lambdaSubtractTen)
}

fun<T1, T2, T3> compose(fun1: (T1) -> T2, fun2: (T2) -> T3): (T1) -> T3 {
    return { t -> fun2.invoke(fun1.invoke(t)) }
}
