package boostmedia.stockdepot.domain.depotowner

import boostmedia.stockdepot.infrasturctur.depotowner.DepotOwnerDto
import org.springframework.stereotype.Repository

interface DepotOwnerRepository {

    fun createDepotOwner(depotOwnerDto: DepotOwnerDto)
}
