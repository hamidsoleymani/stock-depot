package boostmedia.stockdepot.infrasturctur.depot

import boostmedia.stockdepot.domain.depot.Depot
import boostmedia.stockdepot.domain.depot.DepotRepository
import domain.depotowner.Tables.DEPOT
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class DepotRepositoryImpl(val context: DSLContext) : DepotRepository {

    override fun createDepot(depot: Depot) {
        context.insertInto(
            DEPOT,
            DEPOT.DEPOT_NAME,
            DEPOT.BROKER_NAME,
            DEPOT.DEPOT_OWNER_ID
        )
            .values(depot.depotName, depot.brokerName, depot.depotOwnerId)
            .execute()
    }

    override fun loadDepotsByDepotOwnerId(id: Int): List<Depot> {
        val fetch = context.selectFrom(DEPOT)
            .where(DEPOT.DEPOT_OWNER_ID.eq(id))
            .fetch()
        var depos: MutableList<Depot> = mutableListOf()
        for (r in fetch) {
            val d = Depot(r.depotName, r.brokerName, r.depotId, r.depotOwnerId);
            depos.add(d)
        }
        return depos;
    }
}


