package reader.kart.factory

import reader.kart.domain.Lap

import java.time.LocalTime

class LapFactory {

    static Lap VALID = new Lap(1,
            LocalTime.now().withHour(12).withMinute(12).withSecond(12),
            LocalTime.now().withHour(0).withMinute(1).withSecond(12)
            ,35.44D)
    static Lap SECOND = new Lap(2,
            LocalTime.now().withHour(12).withMinute(20).withSecond(12).withNano(0),
            LocalTime.now().withHour(0).withMinute(1).withSecond(20).withNano(0)
            ,35.44D)
    static Lap INVALID_LAP = new Lap(0, LocalTime.now(),
            LocalTime.now().withHour(0).withMinute(2)
            ,35.44D)
    static Lap ALREADY_FINISHED = new Lap(5, LocalTime.now(),
            LocalTime.now().withHour(0).withMinute(2)
            ,35.44D)


}
