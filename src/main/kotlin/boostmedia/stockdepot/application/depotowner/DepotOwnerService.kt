package boostmedia.stockdepot.application.depotowner

import boostmedia.stockdepot.domain.depotowner.DepotOwner
import boostmedia.stockdepot.domain.depotowner.DepotOwnerRepository
import org.springframework.stereotype.Service

@Service
class DepotOwnerService(val depotOwnerRepository: DepotOwnerRepository) {
    fun createDepotOwner(depotOwner: DepotOwner) {
        depotOwnerRepository.createDepotOwner(depotOwner)
    }
}
