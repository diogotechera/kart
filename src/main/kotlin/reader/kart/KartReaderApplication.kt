package reader.kart

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reader.kart.service.RaceFileReaderService

@SpringBootApplication
class KartReaderApplication(val raceFileReaderService: RaceFileReaderService) : CommandLineRunner {

    override fun run(vararg args: String?) {
        raceFileReaderService.processFile("result.txt")
    }
}

fun main(args: Array<String>) {
    runApplication<KartReaderApplication>(*args)
}