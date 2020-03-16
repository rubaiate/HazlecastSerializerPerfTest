import com.hazelcast.client.HazelcastClient
import com.hazelcast.config.Config
import com.hazelcast.core.IMap
import hz.HzTest.message.EquityData
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.math.abs
import kotlin.random.Random

class DataConsumer {
    private val equityCount = 60000
    private val queryCount = 500

    init {
        val config = Config()
        config.networkConfig.interfaces.addInterface("192.168.40.169")
        val hzInstance = HazelcastClient.newHazelcastClient()


        val rnd = Random(System.nanoTime())
        val executorServiceConsumer = Executors.newSingleThreadScheduledExecutor()
        executorServiceConsumer.scheduleAtFixedRate({

            val querySet = HashSet<String>()
            for (equityIndex in 0..queryCount) {
                val equityQueryIndex = abs(rnd.nextInt()) % equityCount
                val instrument = "EQ_$equityQueryIndex"
                querySet.add(instrument)

            }

            val start = System.nanoTime()
            val equityMap: IMap<String, EquityData> = hzInstance.getMap("equityData")
            equityMap.getAll(querySet)
            println((System.nanoTime() - start) / 1000 / 1000)
        }, 0, 500, TimeUnit.MILLISECONDS)
        println("Started")
    }
}

fun main(args: Array<String>) {
    DataConsumer()
}