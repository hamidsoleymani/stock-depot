package boostmedia.stockdepot.application.depotowner

import boostmedia.stockdepot.domain.depotowner.DepotOwnerRepository
import boostmedia.stockdepot.infrasturctur.depotowner.DepotOwnerDto
import org.springframework.stereotype.Service

@Service
class DepotOwnerService(val depotOwnerRepository: DepotOwnerRepository) {

    fun createDepotOwner(depotOwnerDto: DepotOwnerDto) {
        depotOwnerRepository.createDepotOwner(depotOwnerDto)
    }
}
