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
        save.racerLaps.size() == 0
    }

    def 'Should retrieve a lap if already exists'(){

        given: 'A saved lap'
        Lap lap = LapFactory.VALID
        service.save(lap)

        when: 'It tries to save again'
        Lap lap2 = LapFactory.VALID2
        def save = service.save(lap2)

        then: 'it should not save, just retrieve with the old value'
        save
        save.number == 1
        save.racerLaps.size() == 0
    }

}