package reader.kart.factory

import reader.kart.domain.Lap
import reader.kart.domain.Racer

class RacerFactory {

    static Racer VALID = new Racer('001', 'S.MOCK',new ArrayList<Lap>())
    static Racer VALID2 = new Racer('001', 'S.MOC',new ArrayList<Lap>())

    static Racer VALID_WITH_LAPS = new Racer('775', 'D.MOCK', [LapFactory.VALID,LapFactory.SECOND])


}
