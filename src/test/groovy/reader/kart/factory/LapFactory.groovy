package reader.kart.factory

import reader.kart.domain.Lap
import reader.kart.domain.RacerLap

class LapFactory {

    static Lap VALID = new Lap(1, new ArrayList<RacerLap>())
    static Lap VALID2 = new Lap(1, [RacerLapFactory.VALID])
    static Lap INVALID_LAP = new Lap(0, new ArrayList<RacerLap>())
    static Lap ALREADY_FINISHED = new Lap(5, new ArrayList<RacerLap>())


}
