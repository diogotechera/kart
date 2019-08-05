package reader.kart.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reader.kart.builder.LineBuilder
import reader.kart.exception.InvalidLineException
import java.io.File

@Service
class RaceFileReaderService(val raceService: RaceService) {

    private val log = LoggerFactory.getLogger(RaceFileReaderService::class.java)

    fun processFile(fileName: String) {
        val lines = File(fileName).useLines { it.toList() }
        lines.forEach{ processLine(it) }
    }

    private fun processLine(lineValue: String) {
        try {
            val line  = LineBuilder.build(lineValue)
            raceService.saveLineInformation(line)
        }catch (e : InvalidLineException){
            log.warn("Invalid line! Ignoring...", e)
        }

    }

}