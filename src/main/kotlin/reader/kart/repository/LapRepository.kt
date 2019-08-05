package reader.kart.repository

import org.springframework.stereotype.Repository
import reader.kart.domain.Lap
import reader.kart.domain.Racer

@Repository
class LapRepository(override val list: ArrayList<Lap> = arrayListOf()) : ListRepository<Lap>