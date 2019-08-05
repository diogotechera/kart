package reader.kart.domain

import reader.kart.exception.InvalidLapException
import reader.kart.exception.RaceAlreadyFinishedException
import reader.kart.factory.LapFactory
import spock.lang.Specification

class LapTest extends Specification {


    def 'Should validate lap number'(){

        given: 'A invalid lap'
        Lap lap = LapFactory.INVALID_LAP

        when: 'It tries to validate'
        lap.validate()

        then: 'it thrown an InvalidLapException'
        thrown(InvalidLapException)
    }

    def 'Should not save lap if race is already finished'(){

        given: 'A invalid lap'
        Lap lap = LapFactory.ALREADY_FINISHED

        when: 'It tries to validate'
        lap.validate()

        then: 'it thrown an RaceAlreadyFinishedException'
        thrown(RaceAlreadyFinishedException)
    }


}