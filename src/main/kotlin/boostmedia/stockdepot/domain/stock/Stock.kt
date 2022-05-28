package boostmedia.stockdepot.domain.stock

import boostmedia.stockdepot.domain.dividend.Dividend
import java.time.LocalDateTime

class Stock(
    val name: String,
    val depotId: Int,
    val wkn: String,
    val isin: String,
    val stockExchangeBuy: String,
    val stockExchangeSell: String?,
    val buyDate: LocalDateTime,
    val buyPrice: Double,
    val sellDate: LocalDateTime?,
    val sellPrice: Double?,
    val quantity: Int,
    val currency: String,
    val dividends: List<Dividend>?
)
