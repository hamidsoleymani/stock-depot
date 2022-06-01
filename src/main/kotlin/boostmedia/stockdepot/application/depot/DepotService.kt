package boostmedia.stockdepot.application.depot

import boostmedia.stockdepot.domain.depot.Depot
import boostmedia.stockdepot.domain.depot.DepotRepository
import org.springframework.stereotype.Service

@Service
class DepotService(val depotRepository: DepotRepository) {


    fun createDepot(depot: Depot) {
        depotRepository.createDepot(depot)
    }

    fun loadDepotsByDepotOwnerId(id: Int): List<Depot>{
       return depotRepository.loadDepotsByDepotOwnerId(id)
    }

    fun loadDepotById(id: Int): Depot {
        return depotRepository.loadDepotById(id)
    }
}
