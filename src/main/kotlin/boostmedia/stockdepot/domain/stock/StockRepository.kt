package boostmedia.stockdepot.domain.stock

interface StockRepository {
    fun createStock(stock: Stock)
}
