package reader.kart.factory

import reader.kart.domain.Racer
import reader.kart.domain.RacerLap

class RacerFactory {

    static Racer VALID = new Racer('038', 'F.MASSA',new ArrayList<RacerLap>())
    static Racer VALID2 = new Racer('038', 'F.MASS',new ArrayList<RacerLap>())

}
