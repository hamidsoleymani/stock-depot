package boostmedia.stockdepot.domain.depot

interface DepotRepository {

    fun createDepot(depot: Depot)
    fun loadDepotsByDepotOwnerId(id: Int):  List<Depot>
}
