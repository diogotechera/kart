package reader.kart.factory

import reader.kart.domain.Racer
import reader.kart.domain.RacerLap

import java.time.LocalTime

class RacerLapFactory {

    static RacerLap VALID = new RacerLap(LocalTime.now(),
            LocalTime.now().withHour(0).withMinute(2)
            ,35.44D)

}
