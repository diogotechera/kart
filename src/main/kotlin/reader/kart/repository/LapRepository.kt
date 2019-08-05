package reader.kart.repository

import org.springframework.stereotype.Repository
import reader.kart.domain.Lap

@Repository
class LapRepository(override val list: ArrayList<Lap> = arrayListOf()) : ListRepository<Lap> {

    fun find(number: Int, racerCode: String) =  list.find{it.number == number}

}