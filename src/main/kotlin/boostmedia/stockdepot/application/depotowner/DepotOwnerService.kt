package boostmedia.stockdepot.application.depotowner

import boostmedia.stockdepot.domain.depotowner.DepotOwner
import boostmedia.stockdepot.domain.depotowner.DepotOwnerRepository
import org.springframework.stereotype.Service

@Service
class DepotOwnerService(val depotOwnerRepository: DepotOwnerRepository) {
    fun createDepotOwner(depotOwner: DepotOwner): Int {
       return depotOwnerRepository.createDepotOwner(depotOwner)
    }

    fun getDepotOwnerById( id: Int): DepotOwner{
       return depotOwnerRepository.getDepotOwnerById(id)
    }
}
