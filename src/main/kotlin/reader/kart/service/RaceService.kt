package reader.kart.service

import org.springframework.stereotype.Service
import reader.kart.domain.FileLine
import reader.kart.domain.Racer

@Service
class RaceService(val racerService: RacerService) {

    fun saveLineInformation(fileLine: FileLine) {
        val racer = racerService.save(fileLine.toRacer())
        val lap = fileLine.toLap()
        lap.validate()
        racer.addLap(lap)
    }

    fun getAllRacerSortedByFinishLine() : MutableList<Racer> {
        val allRacers = racerService.findAll()
        allRacers.sortWith(compareBy({- it.lastLapNumber()}, {it.finalLapTime()}))
        return allRacers
    }

}