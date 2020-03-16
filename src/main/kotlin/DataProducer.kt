import com.hazelcast.core.Hazelcast
import com.hazelcast.core.IMap
import hz.HzTest.message.EquityData
import java.math.BigDecimal
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class DataProducer {
    private val equityCount = 60000

    init {
        val executorServiceProducer = Executors.newSingleThreadScheduledExecutor()
        val hzInstance = Hazelcast.newHazelcastInstance()
        val equityDataMap = HashMap<String, EquityData>()

        for (equityIndex in 0..equityCount) {
            equityDataMap["EQ_$equityIndex"] = EquityData()
        }
        executorServiceProducer.scheduleAtFixedRate({


            for (equityIndex in 0..equityCount) {
                val equityData = EquityData()
                equityData.instrumentId = "EQ_$equityIndex"
                equityData.ask = BigDecimal.valueOf(Math.random())
                equityData.bid = BigDecimal.valueOf(Math.random())
                equityDataMap["EQ_$equityIndex"] = equityData
            }


            val start = System.nanoTime() / 1000 / 1000
            val equityMap: IMap<String, EquityData> = hzInstance.getMap("equityData")
            equityMap.putAll(equityDataMap)
            println((System.nanoTime() / 1000 / 1000 - start))
        }, 0, 1000, TimeUnit.MILLISECONDS)

        println("Started")
    }


}

fun main(args: Array<String>) {
    DataProducer()
}