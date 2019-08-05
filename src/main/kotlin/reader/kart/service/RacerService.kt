package reader.kart.service

import org.springframework.stereotype.Service
import reader.kart.domain.Racer
import reader.kart.repository.RacerRepository

@Service
class RacerService(val racerRepository: RacerRepository) {

    fun save(racer: Racer): Racer {
        val persisted = racerRepository.find(racer.code)
        if(persisted == null)
            racerRepository.save(racer)
        return persisted!!
    }

}