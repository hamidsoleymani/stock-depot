package boostmedia.stockdepot.infrasturctur.stock

import boostmedia.stockdepot.domain.dividend.DividendRepository
import boostmedia.stockdepot.domain.stock.Stock
import boostmedia.stockdepot.domain.stock.StockRepository
import domain.depotowner.Tables.STOCK
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class StockRepositoryImpl(val context: DSLContext, val dividendRepository: DividendRepository) : StockRepository {
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

    override
    fun getStockByDepotId(depotId: Int): List<Stock> {
        val stocksList: MutableList<Stock> = mutableListOf()

        val stockRecords = context.selectFrom(STOCK)
            .where(STOCK.DEPOT_ID.eq(depotId))
            .fetch()

        for (s in stockRecords) {
            val dividends = dividendRepository.getDividentsByDepotIdAndWkn(depotId, s.wkn)
            val stock = Stock(
                s.stockName, s.depotId, s.wkn, s.isin,
                s.stockExchangeBuy, s.stockExchangeSell, s.buyDate, s.buyPrice,
                s.sellDate, s.sellPrice, s.quantity, s.currency, dividends
            )
            stocksList.add(stock)
        }
        return stocksList
    }
}
