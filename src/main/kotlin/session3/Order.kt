package session3

data class Order(
    val orderId: Int,
    val productIndex: Int,
    val quantity: Int,
    val unitPrice: Int,
    var disocunt: Double = 0.0
){
    override fun toString(): String {
        return "Discount: $disocunt"
    }
}