package reader.kart.service

import org.springframework.stereotype.Service
import reader.kart.domain.FileLine
import reader.kart.domain.Lap
import reader.kart.domain.Racer

@Service
class RaceService(val racerService: RacerService, val lapService: LapService) {

    fun saveLineInformation(fileLine: FileLine) {
        val racer = racerService.save(fileLine.toRacer())
        val lap = lapService.save(fileLine.toLap())
        racer.addLap(lap)
    }

    fun getAllRacerSortedByFinishLine() : List<Racer> {
        val allRacers = racerService.findAll()
        allRacers.sortWith(compareBy({- it.greaterLapNumber()}, {it.finalLapTime()}))
        return allRacers
    }

    fun getRacersBestLaps(): List<Lap> {
        val racers = racerService.findAll()
        val bestLaps = arrayListOf<Lap>()
        racers.forEach { bestLaps.add(it.bestLap()) }
        return bestLaps
    }

    fun getRaceBestLap() {
        lapService.findAll()


    }


}