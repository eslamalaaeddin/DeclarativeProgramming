package session_one

fun main() {
    val hello = Hello(0,0)

    hello.updateX(4)
    hello.updateY(2)

    println(hello.getZ())
}

class Hello(x1: Int, y1: Int) {
    private var x = x1
    private var y = y1

    fun updateX(v: Int) {
        x = v * 2
    }

    fun updateY(v: Int) {
        y = v * 3
    }

    fun getZ() = if (x > 10) x * 2 + 3 * y else x * 3 + 2 * y
}