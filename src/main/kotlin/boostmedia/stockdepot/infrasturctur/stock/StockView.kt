package boostmedia.stockdepot.infrasturctur.stock

import boostmedia.stockdepot.domain.dividend.Dividend
import java.time.LocalDateTime

class StockView(val name: String,
                val depotId: Int,
                val wkn: String,
                val isin: String,
                val stockExchangeBuy: String,
                val sockExchangeSell: String?= null,
                val buyDate: LocalDateTime,
                val buyPrice: Double,
                val sellDate: LocalDateTime?,
                val sellPrice: Double?,
                val quantity: Int,
                val currency: String,
                val dividends: List<Dividend>?)
