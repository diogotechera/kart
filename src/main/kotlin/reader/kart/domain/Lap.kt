package reader.kart.domain

data class Lap(val number : Int, val racerLaps: ArrayList<RacerLap> = arrayListOf()){

    fun addRacerLap(racerLap: RacerLap) =  racerLaps.add(racerLap)

}
