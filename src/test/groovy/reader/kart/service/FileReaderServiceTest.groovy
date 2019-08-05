package reader.kart.service

import org.springframework.beans.factory.annotation.Autowired
import reader.kart.KartReaderApplicationTest

class FileReaderServiceTest extends KartReaderApplicationTest {

    @Autowired
    RaceFileReaderService fileReaderService

    def 'Should build a valid FileLine'(){
         when: 'It calls processFile with a non existent file'
            fileReaderService.processFile('does-not-exists.txt')
        then: 'it should throw FileNotFoundException'
            thrown(FileNotFoundException)
    }
}