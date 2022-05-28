package boostmedia.stockdepot.domain.dividend

interface DividendRepository {
    fun createDividend(dividend: Dividend)
}
