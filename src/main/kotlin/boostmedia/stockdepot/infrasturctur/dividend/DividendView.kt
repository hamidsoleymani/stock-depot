package boostmedia.stockdepot.infrasturctur.dividend

import java.time.LocalDateTime

class DividendView(val dividend: Double,
                   val dividendDate: LocalDateTime,
                   val wkn: String,
                   val currency: String,
                   val depotId: Int)
