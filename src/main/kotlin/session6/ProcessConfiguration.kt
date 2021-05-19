package session6

class ProcessConfiguration {

    lateinit var invoiceChoice: InvoiceChoice
    lateinit var shippingChoice: ShippingChoice
    lateinit var freightChoice: FreightChoice
    lateinit var availabilityChoice: AvailabilityChoice
    lateinit var shippingDateChoice: ShippingDateChoice
}

enum class InvoiceChoice {
    Inv1,
    Inv2,
    Inv3,
    Inv4,
    Inv5
}

enum class ShippingChoice {
    Sh1,
    Sh2,
    Sh3,
}

enum class FreightChoice {
    FR1,
    FR2,
    FR3,
    FR4,
    FR5,
    FR6
}

enum class AvailabilityChoice {
    AV1,
    AV2,
    AV3,
    AV4
}

enum class ShippingDateChoice {
    SD1,
    SD2,
    SD3,
    SD4,
    SD5
}