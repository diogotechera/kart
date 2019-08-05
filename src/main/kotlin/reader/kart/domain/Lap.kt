package reader.kart.domain

import reader.kart.exception.InvalidLapException
import reader.kart.exception.RaceAlreadyFinishedException
import java.time.LocalTime

data class Lap(val number : Int, val currentTime : LocalTime, val lapTime : LocalTime, val averageSpeed : Double){


    fun validate() {

        if(number <= 0) throw InvalidLapException("The lap number should be > 0")

        if(number > 4) throw RaceAlreadyFinishedException("The race is finished at the 4th lap")

    }

}
