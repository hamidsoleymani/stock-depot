package boostmedia.stockdepot.infrasturctur.depotowner
import boostmedia.stockdepot.application.depotowner.DepotOwnerService
import boostmedia.stockdepot.domain.depotowner.DepotOwner
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController()
class DepotOwnerController(val depotOwnerService: DepotOwnerService) {
    @PostMapping("/api/stock-depot/new/depot-owner")
    fun createDepotOwner(@RequestBody depotOwnerView: DepotOwnerView){
        val depotOwner = DepotOwner(depotOwnerView.firstName, depotOwnerView.lastName, null)
        depotOwnerService.createDepotOwner(depotOwner)
    }
}
