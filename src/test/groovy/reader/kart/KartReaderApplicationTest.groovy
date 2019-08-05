package reader.kart

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration(classes = [KartReaderApplication])
class KartReaderApplicationTest extends Specification {}
