package reader.kart.domain

import reader.kart.exception.InvalidLapException
import reader.kart.exception.RaceAlreadyFinishedException

data class Lap(val number : Int, private val racerLaps: ArrayList<RacerLap> = arrayListOf()){

    fun addRacerLap(racerLap: RacerLap) =  racerLaps.add(racerLap)

    fun validate() {

        if(number <= 0) throw InvalidLapException("The lap number should be > 0")

        if(number > 4) throw RaceAlreadyFinishedException("The race is finished at the 4th lap")

    }

}
