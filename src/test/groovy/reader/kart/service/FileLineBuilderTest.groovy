package reader.kart.service

import reader.kart.builder.FileLineBuilder
import reader.kart.exception.InvalidLineException
import reader.kart.factory.LineFactory
import spock.lang.Specification

class FileLineBuilderTest extends Specification {

    FileLineBuilder lineBuilder = new FileLineBuilder()

    def 'Should build a valid FileLine'(){

        given: "a valid line"
        def line = LineFactory.VALID

        when: 'It tries to build'
        def fileLine = lineBuilder.build(line)

        then: 'it should be build a valid FileLine'
            fileLine.racerCode == '038'
            fileLine.racerName == 'F.MASSA'
            fileLine.averageSpeed == 44.275D
            fileLine.lapNumber == 1
            fileLine.time != null
            fileLine.time.hour == 23
            fileLine.time.minute == 49
            fileLine.time.second == 8
            fileLine.time.nano == 277000000
            fileLine.lapTime != null
            fileLine.lapTime.hour == 0
            fileLine.lapTime.minute == 1
            fileLine.lapTime.second == 2
            fileLine.lapTime.nano == 852000000
    }

    def 'Should not build when the line values is less than 5'(){

        given: "a line with less than 5 values"
        def line = LineFactory.LESS_THAN_FIVE_VALUES

        when: 'It tries to build'
        lineBuilder.build(line)

        then: 'it should be throw a InvalidLineException'
        def ex = thrown(InvalidLineException)
        ex.message == 'Invalid line values: 4'
    }

    def 'Should not build when the line values is more than 5'(){

        given: "a line with more than 5 values"
        def line = LineFactory.MORE_THAN_FIVE_VALUES

        when: 'It tries to build'
        lineBuilder.build(line)

        then: 'it should be throw a InvalidLineException'
        def ex = thrown(InvalidLineException)
        ex.message == 'Invalid line values: 6'
    }

    def 'Should not build when racer information has more value than {CODE} - {NAME}'(){

        given: "a line with more than 2 values on racer information"
        def line = LineFactory.MORE_THAN_TWO_RACE_INFO

        when: 'It tries to build'
        lineBuilder.build(line)

        then: 'it should be throw a InvalidLineException'
        def ex = thrown(InvalidLineException)
        ex.message == 'Invalid racer information values: 038 – F.MASSA – Ferrari'
    }


    def 'Should not build when racer information has less value than {CODE} - {NAME}'(){

        given: "a line with more than 2 values on racer information"
        def line = LineFactory.LESS_THAN_TWO_RACE_INFO

        when: 'It tries to build'
        lineBuilder.build(line)

        then: 'it should be throw a InvalidLineException'
        def ex = thrown(InvalidLineException)
        ex.message == 'Invalid racer information values: F.MASSA'
    }

    def 'Should not build when the time is invalid'(){

        given: "a line with invalid time"
        def line = LineFactory.INVALID_TIME

        when: 'It tries to build'
        lineBuilder.build(line)

        then: 'it should be throw a InvalidLineException'
        def ex = thrown(InvalidLineException)
        ex.message == 'Invalid time: 25:49:08.277'
    }

    def 'Should not build when the lap number is not an integer'(){

        given: "a line with invalid time"
        def line = LineFactory.INVALID_LAP_NUMBER

        when: 'It tries to build'
        lineBuilder.build(line)

        then: 'it should be throw a InvalidLineException'
        def ex = thrown(InvalidLineException)
        ex.message == 'Invalid lap number: NaN'
    }

    def 'Should not build when the average speed is not in the a number'(){

        given: "a line with invalid time"
        def line = LineFactory.INVALID_AVERAGE_SPEED

        when: 'It tries to build'
        lineBuilder.build(line)

        then: 'it should be throw a InvalidLineException'
        def ex = thrown(InvalidLineException)
        ex.message == 'Invalid average speed: NaN'
    }

    def 'Should not build when the lap time is given with hour'(){

        given: "a line with invalid time"
        def line = LineFactory.LAP_TIME_WITH_HOUR

        when: 'It tries to build'
        lineBuilder.build(line)

        then: 'it should be throw a InvalidLineException'
        def ex = thrown(InvalidLineException)
        ex.message == 'Invalid lap time format: 13:01:02.852'
    }

    def 'Should not build when the lap time is given without milliseconds'(){

        given: "a line with invalid time"
        def line = LineFactory.LAP_TIME_WITHOUT_MILLISECONDS

        when: 'It tries to build'
        lineBuilder.build(line)

        then: 'it should be throw a InvalidLineException'
        def ex = thrown(InvalidLineException)
        ex.message == 'Invalid lap time format: 1:02'
    }

    def 'Should not build when the lap time is invalid'(){

        given: "a line with invalid time"
        def line = LineFactory.INVALID_LAP_TIME

        when: 'It tries to build'
        lineBuilder.build(line)

        then: 'it should be throw a InvalidLineException'
        def ex = thrown(InvalidLineException)
        ex.message == 'Invalid lap time value: 89:02.852'
    }

}