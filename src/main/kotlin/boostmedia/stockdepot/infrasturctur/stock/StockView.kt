package boostmedia.stockdepot.infrasturctur.stock

import boostmedia.stockdepot.domain.dividend.Dividend
import java.time.LocalDate
import java.time.LocalDateTime

class StockView(val name: String,
                val depotId: Int,
                val wkn: String,
                val isin: String,
                val stockExchangeBuy: String,
                val sockExchangeSell: String?= null,
                val buyDate: LocalDate?=null,
                val buyPrice: Double,
                val sellDate: LocalDate?,
                val sellPrice: Double?,
                val quantity: Int,
                val currency: String,
                val dividends: List<Dividend>?)
