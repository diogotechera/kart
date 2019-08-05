package reader.kart.domain

import reader.kart.exception.InvalidLapException
import reader.kart.exception.RaceAlreadyFinishedException
import reader.kart.helper.LapHelper.LAST_LAP
import java.time.LocalTime

data class Lap(val number : Int, val currentTime : LocalTime, val lapTime : LocalTime, val averageSpeed : Double){

    fun validate() {

        if(number <= 0) throw InvalidLapException("The lap number should be > 0")
        if(number > LAST_LAP) throw RaceAlreadyFinishedException("The race is finished at the 4th lap")

    }

}
