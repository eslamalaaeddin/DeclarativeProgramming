package session6

import models.Customer
import models.Freight
import models.MyOrder
import models.ShippingDate
import java.time.LocalDate


fun main() {
    val invoicePath = InvoicePath()
    val availabilityPath = AvailabilityPath()
    val configs: Pair<MyOrder, ProcessConfiguration> = setConfiguration()

    val processConfiguration = ProcessConfiguration()
    processConfiguration.invoiceChoice = InvoiceChoice.Inv3
    processConfiguration.shippingChoice = ShippingChoice.Sh2
    processConfiguration.freightChoice = FreightChoice.FR3
    processConfiguration.availabilityChoice = AvailabilityChoice.AV2
    processConfiguration.shippingDateChoice = ShippingDateChoice.SD2

    val costOfOrder : (MyOrder) -> Double =calcAdjustedCostOfOrder(processConfiguration, invoicePath, availabilityPath)

    val order = MyOrder(Customer(), LocalDate.now(), 250.0)

    println(costOfOrder.invoke(order))

}

fun setConfiguration(): Pair<MyOrder, ProcessConfiguration> {
    val processConfiguration = ProcessConfiguration()
    val customer = Customer()
    val order = MyOrder()

    processConfiguration.invoiceChoice = InvoiceChoice.Inv3
    processConfiguration.shippingChoice = ShippingChoice.Sh2
    processConfiguration.freightChoice = FreightChoice.FR3
    processConfiguration.availabilityChoice = AvailabilityChoice.AV2
    processConfiguration.shippingDateChoice = ShippingDateChoice.SD2
    order.customer = customer
    order.date = LocalDate.now()
    order.cost = 2000.0

    return Pair(order, processConfiguration)
}


private fun calcAdjustedCostOfOrder(
    processConfig: ProcessConfiguration,
    invoicePath: InvoicePath,
    availabilityPath: AvailabilityPath
): (MyOrder) -> Double {
    return { order ->
        adjustCost(
            order,
            invoicePath(processConfig, invoicePath),
            availabilityPath(processConfig, availabilityPath)
        )
    }
}


private fun adjustCost(
    order: MyOrder,
    calcFreight: (MyOrder) -> Freight,
    calcShippingDate: (MyOrder) -> ShippingDate
): Double {
    val freight = calcFreight(order)
    val shippingDate = calcShippingDate(order)

    val cost = if (shippingDate.date?.dayOfWeek.toString() == "Monday") freight.cost + 1000 else freight.cost + 500

    return cost
}

private fun invoicePath(processConfig: ProcessConfiguration, invoicePath: InvoicePath): (MyOrder) -> Freight {

    return compose(
        compose(
            invoicePath.invoiceLambdas.filter { it.first == processConfig.invoiceChoice }.map { it.second }.first(),
            invoicePath.shippingLambdas.filter { it.first == processConfig.shippingChoice }.map { it.second }.first()
        ),

        invoicePath.freightLambdas.filter { it.first == processConfig.freightChoice }.map { it.second }.first()
    )

}

private fun availabilityPath(
    processConfig: ProcessConfiguration,
    availabilityPath: AvailabilityPath
): (MyOrder) -> ShippingDate {
    return compose(
        availabilityPath.availabilityLambdas.filter { it.first == processConfig.availabilityChoice }.map { it.second }
            .first(),
        availabilityPath.shippingDateLambdas.filter { it.first == processConfig.shippingDateChoice }.map { it.second }
            .first()
    )
}


fun <T1, T2, T3> compose(fun1: (T1) -> T2, fun2: (T2) -> T3): (T1) -> T3 {
    return { t -> fun2.invoke(fun1.invoke(t)) }
}