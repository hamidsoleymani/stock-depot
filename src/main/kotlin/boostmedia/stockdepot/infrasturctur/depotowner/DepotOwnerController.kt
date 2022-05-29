package boostmedia.stockdepot.infrasturctur.depotowner
import boostmedia.stockdepot.application.depotowner.DepotOwnerService
import boostmedia.stockdepot.domain.depotowner.DepotOwner
import org.springframework.web.bind.annotation.*

@RestController()
@CrossOrigin(origins = ["http://localhost:4200"])
class DepotOwnerController(val depotOwnerService: DepotOwnerService) {
    @PostMapping("/api/stock-depot/new/depot-owner")
    fun createDepotOwner(@RequestBody depotOwnerView: DepotOwnerView): Int {
        val depotOwner = DepotOwner(depotOwnerView.firstName, depotOwnerView.lastName, null)
      return  depotOwnerService.createDepotOwner(depotOwner)
    }

    @GetMapping("/api/stock-depot/id/{id}")
    fun getDepotOwnerById(@PathVariable id: Int): DepotOwnerView {
        val depotOwnerFromDb = depotOwnerService.getDepotOwnerById(id);
        val depotOwnerView = DepotOwnerView(depotOwnerFromDb.firstName, depotOwnerFromDb.lastName, depotOwnerFromDb.depotOwnerId);
        return depotOwnerView
    }
}
