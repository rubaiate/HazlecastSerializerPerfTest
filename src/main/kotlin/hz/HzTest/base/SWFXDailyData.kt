package com.mdaq.stockwatcher2.base.message

import java.math.BigDecimal
import java.time.LocalDateTime

interface SWFXDailyData {
    var currencyPair: String
    var price: BigDecimal
    var time: LocalDateTime
    var group: String
}