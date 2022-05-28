package boostmedia.stockdepot.infrasturctur.stock

import boostmedia.stockdepot.domain.stock.Stock
import boostmedia.stockdepot.domain.stock.StockRepository
import domain.depotowner.Tables.STOCK
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class StockRepositoryImpl(val context: DSLContext) : StockRepository {
    override fun createStock(stock: Stock) {
        context.insertInto(
            STOCK,
            STOCK.STOCK_NAME,
            STOCK.DEPOT_ID,
            STOCK.WKN,
            STOCK.ISIN,
            STOCK.BUY_DATE,
            STOCK.BUY_PRICE,
            STOCK.STOCK_EXCHANGE_BUY,
            STOCK.QUANTITY,
            STOCK.CURRENCY
        ).values(
            stock.name,
            stock.depotId,
            stock.wkn,
            stock.isin,
            stock.buyDate,
            stock.buyPrice,
            stock.stockExchangeBuy,
            stock.quantity,
            stock.currency
        )
            .execute()
    }
}
