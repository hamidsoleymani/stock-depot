package boostmedia.stockdepot.infrasturctur.stock

import boostmedia.stockdepot.application.stock.StockService
import boostmedia.stockdepot.domain.stock.Stock
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class StockController(val stockService: StockService) {

    @PostMapping("/api/stock-depot/new/stock")
    fun createStock(@RequestBody stockView: StockView) {
        val stock = Stock(
            stockView.name,
            stockView.depotId,
            stockView.wkn,
            stockView.isin,
            stockView.stockExchangeBuy,
            null,
            stockView.buyDate,
            stockView.buyPrice,
            null, null,
            stockView.quantity,
            stockView.currency,
            stockView.dividends
        )
        stockService.createStock(stock)

    }
}
