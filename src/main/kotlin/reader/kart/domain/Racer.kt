package reader.kart.domain

data class Racer(val code : String, val name : String, private val laps : ArrayList<RacerLap> = arrayListOf()){

    fun addLap(racerLap: RacerLap) = laps.add(racerLap)

}
