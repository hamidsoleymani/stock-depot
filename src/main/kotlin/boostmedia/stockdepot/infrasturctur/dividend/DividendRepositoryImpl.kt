package boostmedia.stockdepot.infrasturctur.dividend

import boostmedia.stockdepot.domain.dividend.Dividend
import boostmedia.stockdepot.domain.dividend.DividendRepository
import domain.depotowner.Tables.DIVIDEND
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class DividendRepositoryImpl(val context: DSLContext) : DividendRepository {
    override fun createDividend(dividend: Dividend) {

        context.insertInto(
            DIVIDEND,
            DIVIDEND.WKN,
            DIVIDEND.DIVIDEND_DATE,
            DIVIDEND.CURRENCY,
            DIVIDEND.DEPOTID,
            DIVIDEND.DIVIDEND_AMOUNT
        ).values(dividend.wkn, dividend.dividendDate, dividend.currency, dividend.depotId, dividend.dividend)
            .execute()
    }

    override fun getDividentsByDepotIdAndWkn(depotId: Int, wkn: String?): List<Dividend>? {
        val dividends: MutableList<Dividend> = mutableListOf()

        val fetchRecords = context.selectFrom(DIVIDEND)
            .where(
                DIVIDEND.DEPOTID.eq(depotId)
                    .and(DIVIDEND.WKN.eq(wkn))
            )
            .fetch()

        for (d in fetchRecords) {
            val dividend = Dividend(d.dividendAmount, d.dividendDate, d.wkn, d.currency, d.depotid)
            dividends.add(dividend)
        }
        return dividends
    }
}
