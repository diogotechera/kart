package reader.kart.service

import org.springframework.beans.factory.annotation.Autowired
import reader.kart.KartReaderApplicationTest
import reader.kart.domain.Lap
import reader.kart.factory.LapFactory

class LapServiceTest extends KartReaderApplicationTest {

    @Autowired
    LapService service

    def 'Should save a lap when it does not exists'(){

        given: 'A valid lap'
        Lap lap = LapFactory.VALID

        when: 'It tries to save'
        def save = service.save(lap)

        then: 'it should save it'
        save
        save.number == 1
        save.averageSpeed == 35.44D
    }

}