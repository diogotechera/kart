package reader.kart.service

import org.springframework.stereotype.Service
import reader.kart.domain.Lap
import reader.kart.repository.LapRepository

@Service
class LapService(val lapRepository: LapRepository) {

    fun save(lap: Lap): Lap {
        lap.validate()
        return lapRepository.find(lap.number) ?: lapRepository.save(lap)
    }

}