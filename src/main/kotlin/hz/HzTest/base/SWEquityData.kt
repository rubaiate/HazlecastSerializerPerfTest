package com.mdaq.stockwatcher2.base.message

import java.math.BigDecimal
import java.time.LocalDateTime

interface SWEquityData {
    var exchangeCode: String
    var instrumentId: String
    var orderBookType: String
    var tradeId: String?
    var tradePrice: BigDecimal?
    var high: BigDecimal?
    var low: BigDecimal?
    var bid: BigDecimal?
    var ask: BigDecimal?
    var last: BigDecimal?
    var volume: Long?
    var tradeTime: LocalDateTime?
    var receivedTime: LocalDateTime
}