package boostmedia.stockdepot.infrasturctur.depotowner

import boostmedia.stockdepot.domain.depotowner.DepotOwner
import boostmedia.stockdepot.domain.depotowner.DepotOwnerRepository
import domain.depotowner.Tables.DEPOT_OWNER
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class DepotOwnerRepositoryImpl(val context: DSLContext) : DepotOwnerRepository {
    override fun createDepotOwner(depotOwner: DepotOwner): Int {
         context.insertInto(
            DEPOT_OWNER,
            DEPOT_OWNER.FIRST_NAME,
            DEPOT_OWNER.LAST_NAME
        )
            .values(depotOwner.firstName,
                depotOwner.lastName)
            .execute()
        return context.lastID().intValueExact();
    }
    override fun getDepotOwnerById(id: Int): DepotOwner {
        val depotOwnerFromDB =
            context.selectFrom(DEPOT_OWNER).where(DEPOT_OWNER.DEPOT_OWNER_ID.eq(id))
                .fetchOneInto(DepotOwner::class.java)
        return depotOwnerFromDB!!;

    }
}
