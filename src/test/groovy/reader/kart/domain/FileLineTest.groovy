package reader.kart.domain


import reader.kart.factory.FileLineFactory
import spock.lang.Specification

class FileLineTest extends Specification {


    def 'Given a valid FileLine it should be able to create a Racer'(){
        given: 'A valid fileLine'
        FileLine fileLine = FileLineFactory.VALID

        when: 'It is converted to Racer'
        def racer = fileLine.toRacer()

        then: 'it should create a valid Racer'
        racer
        racer.code == '038'
        racer.name == 'F.MASSA'
    }

    def 'Given a valid FileLine it should be able to create a Lap'(){
        given: 'A valid fileLine'
        FileLine fileLine = FileLineFactory.VALID

        when: 'It is converted to Racer'
        def lap = fileLine.toLap()

        then: 'it should create a valid Lap'
        lap
        lap.number == 1
    }

    def 'Given a valid FileLine it should be able to create a RacerLap'(){
        given: 'A valid fileLine'
        FileLine fileLine = FileLineFactory.VALID

        when: 'It is converted to RacerLap'
        def racerLap = fileLine.toRacerLap()

        then: 'it should create a valid RacerLap'
        racerLap
        racerLap.time
        racerLap.lapTime
        racerLap.averageSpeed == 45.40D
    }

}