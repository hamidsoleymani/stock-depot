package boostmedia.stockdepot.application.stock

import boostmedia.stockdepot.domain.stock.Stock
import boostmedia.stockdepot.domain.stock.StockRepository
import org.springframework.stereotype.Service

@Service
class StockService(val stockRepository: StockRepository) {
    fun createStock(stock: Stock) {
        stockRepository.createStock(stock)
    }
}
