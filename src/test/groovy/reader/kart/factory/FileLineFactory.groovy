package reader.kart.factory

import reader.kart.domain.FileLine

import java.time.LocalTime

class FileLineFactory {

    static FileLine VALID = new FileLine(LocalTime.now(), '038','F.MASSA',1,
            LocalTime.now().withHour(0).withMinute(2),45.40D)



}
