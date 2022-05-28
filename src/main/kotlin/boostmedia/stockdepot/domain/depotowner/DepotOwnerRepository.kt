package boostmedia.stockdepot.domain.depotowner
interface DepotOwnerRepository {
    fun createDepotOwner(depotOwner: DepotOwner): Int
    fun getDepotOwnerById(id: Int): DepotOwner
}
