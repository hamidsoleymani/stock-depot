package boostmedia.stockdepot.infrasturctur.depotowner

import boostmedia.stockdepot.application.depotowner.DepotOwnerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController()
class DepotOwnerController(val depotOwnerService: DepotOwnerService) {

    @PostMapping("/api/stock-depot/stock-owner")
    fun createDepotOwner(@RequestBody depotOwnerDto: DepotOwnerDto){
        depotOwnerService.createDepotOwner(depotOwnerDto)
    }
}
