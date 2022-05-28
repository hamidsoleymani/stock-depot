package boostmedia.stockdepot.infrasturctur.dividend

import boostmedia.stockdepot.application.dividend.DividendService
import boostmedia.stockdepot.domain.dividend.Dividend
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DividendController(val dividendService: DividendService){

    @PostMapping("/api/stock-depot/new/dividend")
fun createDividend(@RequestBody  dividendView: DividendView){
        val dividend = Dividend(dividendView.dividend,
            dividendView.dividendDate,
            dividendView.wkn,
            dividendView.currency,
            dividendView.depotId)
    dividendService.createDividend(dividend)
}
}
