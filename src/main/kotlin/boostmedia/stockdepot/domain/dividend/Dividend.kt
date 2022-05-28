package boostmedia.stockdepot.domain.dividend

import java.time.LocalDateTime

class Dividend(val dividend: Double,
               val dividendDate: LocalDateTime,
               val wkn: String,
               val currency: String,
               val depotId: Int) {

}
