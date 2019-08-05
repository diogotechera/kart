package reader.kart.domain

import java.time.LocalTime

data class RacerLap(val lap : Lap, val racer : Racer, val time : LocalTime,
                    val lapTime : LocalTime, val averageSpeed : Double)