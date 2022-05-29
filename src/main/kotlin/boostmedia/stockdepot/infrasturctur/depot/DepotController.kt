package boostmedia.stockdepot.infrasturctur.depot

import boostmedia.stockdepot.application.depot.DepotService
import boostmedia.stockdepot.domain.depot.Depot
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:4200"])
class DepotController(val depotService: DepotService) {

    @PostMapping("/api/stock-depot/new/depot")
    fun createDepotOwner(@RequestBody depotView: DepotView) {
        val depot = Depot(depotView.depotName, depotView.brokerName, null, depotView.depotOwnerId)
        depotService.createDepot(depot)
    }

    @GetMapping("/api/stock-depot/depots/depotOwner/{id}")
    fun loadDepotsByDepotOwnerId(@PathVariable id: Int): List<Depot> {
      return  depotService.loadDepotsByDepotOwnerId(id);
    }
}
