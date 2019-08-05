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
        lines.forEachIndexed { index, line -> processLine(index,line) }
        printResults()
    }

    private fun processLine(index: Int, lineValue: String) {
        try {
            val line  = FileLineBuilder.build(lineValue)
            raceService.saveLineInformation(line)
        }catch (e : InvalidLineException){
            log.warn("Invalid line $index! Ignoring...")
        }

    }

    private fun printResults() {
        val sortedRacers = raceService.getAllRacerSortedByFinishLine()
        val firstPlaceTime = sortedRacers.first().finalLapTime()

        log.info("===================================== RESULT  ===================")
        sortedRacers.forEachIndexed { index, racer ->
            log.info("Position: ${index + 1}")
            log.info("Racer code: ${racer.code}")
            log.info("Racer name: ${racer.name}")
            log.info("# of laps: ${racer.lastLapNumber()}")
            log.info("Total time: ${racer.totalTime()}")
            log.info("Best lap:  ${racer.bestLap().number} " +
                    "(Lap time: ${racer.bestLap().lapTime} average Speed: ${racer.bestLap().averageSpeed})")
            log.info("Race average speed: ${racer.averageSpeed()}")
            if(index != 0 && racer.finishedRace())
                log.info("Difference between the first place: ${racer.differenceBetween(firstPlaceTime)}")
            log.info("====================================================================")

        }
    }


}