package reader.kart.repository

interface ListRepository<T> {

    val list: ArrayList<T>

    fun save(t : T): T {
        list.add(t)
        return t
    }

    fun findAll() = list

}
