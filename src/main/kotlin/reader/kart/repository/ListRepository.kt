package reader.kart.repository

interface ListRepository<T> {

    val list: ArrayList<T>

    fun save(t : T) = list.add(t)

    fun findAll() =  list

}
