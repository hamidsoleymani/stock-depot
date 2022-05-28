package boostmedia.stockdepot.application.dividend

import boostmedia.stockdepot.domain.dividend.Dividend
import boostmedia.stockdepot.domain.dividend.DividendRepository
import org.springframework.stereotype.Service

@Service
class DividendService(val dividendRepository: DividendRepository) {
    fun createDividend(dividend: Dividend) {
        dividendRepository.createDividend(dividend)
    }
}
