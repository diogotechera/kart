package reader.kart.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reader.kart.builder.FileLineBuilder
import reader.kart.exception.InvalidLineException
import java.io.File

@Service
class RaceFileReaderService(val raceService: RaceService) {

    private val log = LoggerFactory.getLogger(RaceFileReaderService::class.java)

    fun processFile(fileName: String) {
        val lines = File(fileName).useLines { it.toList() }
        lines.forEach{ processLine(it) }
        printResult()
        printRacersBestLaps()
        printRaceBestLap()

    }

    private fun printRaceBestLap() {
        val bestLap = raceService.getRaceBestLap()
    }

    private fun printRacersBestLaps() {
        val bestLaps = raceService.getRacersBestLaps()

        log.info("===================================== MELHORES VOLTAS ===================")
        bestLaps.forEach {  it ->
//            log.info(" ${it.racer.code} - ${it.racer.name}: ${it.number}, ${it.lapTime}, ${it.averageSpeed}")
        }
    }

    private fun printResult() {
        val sortedRacers = raceService.getAllRacerSortedByFinishLine()
        log.info("===================================== RESULTADO FINAL ===================")
        sortedRacers.forEachIndexed { index, racer ->
            log.info("${index + 1}, ${racer.code}, ${racer.name}, ${racer.greaterLapNumber()}, ${racer.totalTime()}")
        }
    }

    private fun processLine(lineValue: String) {
        try {
            val line  = FileLineBuilder.build(lineValue)
            raceService.saveLineInformation(line)
        }catch (e : InvalidLineException){
            log.warn("Invalid line! Ignoring...", e)
        }

    }

}