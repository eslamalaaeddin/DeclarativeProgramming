package session6

import models.Availability
import models.MyOrder
import models.ShippingDate
import java.time.LocalDate

class AvailabilityPath {

    private val calcAvailability1: (MyOrder) -> Availability = { order -> Availability(date = LocalDate.now().plusDays(3))}
    private val calcAvailability2: (MyOrder) -> Availability = { order -> Availability(date = LocalDate.now().plusDays(2))}
    private val calcAvailability3: (MyOrder) -> Availability = { order -> Availability(date = LocalDate.now().plusDays(1))}
    private val calcAvailability4: (MyOrder) -> Availability = { order -> Availability(date = LocalDate.now().plusDays(4))}


    private val calcShippingDate1: (Availability) -> ShippingDate = {a -> ShippingDate(date = LocalDate.now().plusDays(1))}
    private val calcShippingDate2: (Availability) -> ShippingDate = {a -> ShippingDate(date = LocalDate.now().plusDays(2))}
    private val calcShippingDate3: (Availability) -> ShippingDate = {a -> ShippingDate(date = LocalDate.now().plusDays(1/2 ))}
    private val calcShippingDate4: (Availability) -> ShippingDate = {a -> ShippingDate(date = LocalDate.now().plusDays(4/5))}
    private val calcShippingDate5: (Availability) -> ShippingDate = {a -> ShippingDate(date = LocalDate.now().plusDays(2/5))}


    val availabilityLambdas: List<Pair<AvailabilityChoice, (MyOrder) -> Availability>> = listOf(
        Pair(AvailabilityChoice.AV1,calcAvailability1),
        Pair(AvailabilityChoice.AV2,calcAvailability2),
        Pair(AvailabilityChoice.AV3,calcAvailability3),
        Pair(AvailabilityChoice.AV4,calcAvailability4)
    )

    val shippingDateLambdas: List<Pair<ShippingDateChoice, (Availability) -> ShippingDate>> = listOf(
        Pair(ShippingDateChoice.SD1,calcShippingDate1),
        Pair(ShippingDateChoice.SD2,calcShippingDate2),
        Pair(ShippingDateChoice.SD3,calcShippingDate3),
        Pair(ShippingDateChoice.SD4,calcShippingDate4),
        Pair(ShippingDateChoice.SD5,calcShippingDate5),
    )




}