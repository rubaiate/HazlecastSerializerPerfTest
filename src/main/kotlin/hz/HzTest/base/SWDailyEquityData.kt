package com.mdaq.stockwatcher2.base.message

import java.math.BigDecimal
import java.time.LocalDateTime

interface SWDailyEquityData {
    var exchangeCode: String
    var instrumentId: String
    var orderBookType: String
    var open: BigDecimal
    var high: BigDecimal
    var low: BigDecimal
    var volume: BigDecimal
    var exchangeTime: LocalDateTime
    var collectionTime: LocalDateTime
}