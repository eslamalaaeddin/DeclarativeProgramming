package models

import java.time.LocalDate
import java.util.*

data class MyOrder(var customer: Customer? = null, var date: LocalDate? = null, var cost: Double = 0.0)