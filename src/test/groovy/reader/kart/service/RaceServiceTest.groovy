package reader.kart.service

import org.springframework.beans.factory.annotation.Autowired
import reader.kart.KartReaderApplicationTest
import reader.kart.domain.Racer
import reader.kart.factory.RacerFactory

class RaceServiceTest extends KartReaderApplicationTest {

    @Autowired
    RaceService service

    def 'Should get racers sorted by finish time'(){

        when: 'It retrieves the racers'
        def racers = service.getAllRacersByFinishTime()

        then: 'it should be by finish time order'
        racers.size() == 6
        racers.first().code == '038'
        racers.last().code == '011'
    }

}