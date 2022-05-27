package boostmedia.stockdepot.domain.depotowner
import boostmedia.stockdepot.infrasturctur.depotowner.DepotOwnerDto
interface DepotOwnerRepository {
    fun createDepotOwner(depotOwnerDto: DepotOwnerDto)
}
