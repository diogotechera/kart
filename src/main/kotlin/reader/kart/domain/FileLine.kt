package reader.kart.domain

import java.time.LocalTime

data class FileLine(val time : LocalTime, val racerCode: String, val racerName : String,
                    val lapNumber : Int, val lapTime : LocalTime, val averageSpeed : Double) {

    fun toRacer() = Racer(racerCode,racerName)

    fun toLap() = Lap(lapNumber,time, lapTime, averageSpeed)

}



