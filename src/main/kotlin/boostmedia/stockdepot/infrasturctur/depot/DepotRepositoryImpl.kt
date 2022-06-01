package boostmedia.stockdepot.infrasturctur.depot

import boostmedia.stockdepot.domain.depot.Depot
import boostmedia.stockdepot.domain.depot.DepotRepository
import boostmedia.stockdepot.domain.stock.StockRepository
import domain.depotowner.Tables.DEPOT
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class DepotRepositoryImpl(val context: DSLContext, val stockRepository: StockRepository) : DepotRepository {

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
        val depos: MutableList<Depot> = mutableListOf()
        for (r in fetch) {
            val stocksList = stockRepository.getStockByDepotId(r.depotId)
            val d = Depot(r.depotName, r.brokerName, r.depotId, r.depotOwnerId, stocksList)
            depos.add(d)
        }
        return depos
    }

    override fun loadDepotById(id: Int): Depot {
        val depotR = context.selectFrom(DEPOT)
            .where(DEPOT.DEPOT_ID.eq(id))
            .fetchOne()
        val stocksList = stockRepository.getStockByDepotId(id)
        val depot = Depot(depotR?.depotName!!, depotR.brokerName, depotR.depotId, depotR.depotOwnerId, stocksList)
        return depot
    }
}


