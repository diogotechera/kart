package reader.kart.repository

import org.springframework.stereotype.Repository
import reader.kart.domain.Racer

@Repository
class RacerRepository(override val list: ArrayList<Racer> = arrayListOf()) : ListRepository<Racer>{

    fun find(code: String) : Racer? {
        return list.find { it.code == code }
    }

}