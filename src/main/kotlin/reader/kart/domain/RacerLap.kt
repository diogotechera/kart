package reader.kart.domain

import java.time.LocalTime

data class RacerLap(val time : LocalTime, val lapTime : LocalTime, val averageSpeed : Double)