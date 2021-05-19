package session6

import models.*
import session6.FreightChoice
import session6.InvoiceChoice
import session6.ShippingChoice

class InvoicePath {

    private val calcInvoice1 : (MyOrder) -> Invoice = {order -> Invoice(order.cost * 1.1) }
    private val calcInvoice2 : (MyOrder) -> Invoice = {order -> Invoice(order.cost * 1.2) }
    private val calcInvoice3 : (MyOrder) -> Invoice = {order -> Invoice(order.cost * 1.3) }
    private val calcInvoice4 : (MyOrder) -> Invoice = {order -> Invoice(order.cost * 1.4) }
    private val calcInvoice5 : (MyOrder) -> Invoice = {order -> Invoice(order.cost * 1.5) }


    private val calcShipping1: (Invoice) -> Shipping = {invoice -> Shipping(cost = invoice.cost, shipperId = if (invoice.cost > 1000) 1 else 2) }
    private val calcShipping2: (Invoice) -> Shipping = {invoice -> Shipping(cost = invoice.cost, shipperId = if (invoice.cost > 1100) 1 else 2) }
    private val calcShipping3: (Invoice) -> Shipping = {invoice -> Shipping(cost = invoice.cost, shipperId = if (invoice.cost > 1200) 1 else 2) }


    private val calcFreightCost1: (Shipping) -> Freight = {s -> Freight(cost = if (s.shipperId == 1) s.cost * .25 else s.cost * .5) }
    private val calcFreightCost2: (Shipping) -> Freight = {s -> Freight(cost = if (s.shipperId == 1) s.cost * .28 else s.cost * .52) }
    private val calcFreightCost3: (Shipping) -> Freight = {s -> Freight(cost = if (s.shipperId == 1) s.cost * .3 else s.cost * .6) }
    private val calcFreightCost4: (Shipping) -> Freight = {s -> Freight(cost = if (s.shipperId == 1) s.cost * .35 else s.cost * .65) }
    private val calcFreightCost5: (Shipping) -> Freight = {s -> Freight(cost = if (s.shipperId == 1) s.cost * .15 else s.cost * .2) }
    private val calcFreightCost6: (Shipping) -> Freight = {s -> Freight(cost = if (s.shipperId == 1) s.cost * .1 else s.cost * .15) }




    val invoiceLambdas: List<Pair<InvoiceChoice, (MyOrder) -> Invoice>> = listOf(
        Pair(InvoiceChoice.Inv1,calcInvoice1),
        Pair(InvoiceChoice.Inv2,calcInvoice2),
        Pair(InvoiceChoice.Inv3,calcInvoice3),
        Pair(InvoiceChoice.Inv4,calcInvoice4),
        Pair(InvoiceChoice.Inv5,calcInvoice5)
    )

    val shippingLambdas: List<Pair<ShippingChoice, (Invoice) -> Shipping>> = listOf(
        Pair(ShippingChoice.Sh1,calcShipping1),
        Pair(ShippingChoice.Sh2,calcShipping2),
        Pair(ShippingChoice.Sh3,calcShipping3)
    )

    val freightLambdas: List<Pair<FreightChoice, (Shipping) -> Freight>> = listOf(
        Pair(FreightChoice.FR1,calcFreightCost1),
        Pair(FreightChoice.FR2,calcFreightCost2),
        Pair(FreightChoice.FR3,calcFreightCost3),
        Pair(FreightChoice.FR4,calcFreightCost4),
        Pair(FreightChoice.FR5,calcFreightCost5),
        Pair(FreightChoice.FR6,calcFreightCost6)
    )





}