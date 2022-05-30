package boostmedia.stockdepot.domain.dividend

interface DividendRepository {
    fun createDividend(dividend: Dividend)
    fun getDividentsByDepotIdAndWkn(depotId: Int, wkn: String?): List<Dividend>?
}
