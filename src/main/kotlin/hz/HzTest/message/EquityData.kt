package hz.HzTest.message

import com.mdaq.stockwatcher2.base.message.SWEquityData
import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDateTime

class EquityData : SWEquityData, Serializable {
    override var exchangeCode: String = ""
    override var instrumentId: String = ""


    override var orderBookType: String = ""


    override var tradeId: String? = ""


    override var tradePrice: BigDecimal? = null


    override var high: BigDecimal? = null


    override var low: BigDecimal? = null


    override var bid: BigDecimal? = null


    override var ask: BigDecimal? = null


    override var last: BigDecimal? = null


    override var volume: Long? = null


    override var tradeTime: LocalDateTime? = null


    override var receivedTime: LocalDateTime = LocalDateTime.MIN


}