package boostmedia.stockdepot.infrasturctur.depot

import boostmedia.stockdepot.application.depot.DepotService
import boostmedia.stockdepot.domain.depot.Depot
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:4200"])
class DepotController(val depotService: DepotService) {

    @PostMapping("/api/stock-depot/new/depot")
    fun createDepotOwner(@RequestBody depotView: DepotView) {
        val depot = Depot(depotView.depotName, depotView.brokerName, null, depotView.depotOwnerId, null)
        depotService.createDepot(depot)
    }

    @GetMapping("/api/stock-depot/depots/depotOwner/{id}")
    fun loadDepotsByDepotOwnerId(@PathVariable id: Int): List<Depot>  { //TODO DepotView not Depot
        val depotList: List<Depot> = depotService.loadDepotsByDepotOwnerId(id)
        return depotList
    }

    @GetMapping("/api/stock-depot/depot/{id}")
    fun loadStocksByDepotId(@PathVariable id: Int): Depot  { //TODO DepotView not Depot
        val depot: Depot = depotService.loadDepotById(id)
        return depot
    }

}
