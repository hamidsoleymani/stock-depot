package boostmedia.stockdepot.infrasturctur.depotowner

import boostmedia.stockdepot.domain.depotowner.DepotOwner
import boostmedia.stockdepot.domain.depotowner.DepotOwnerRepository
import domain.depotowner.Tables.DEPOT_OWNER
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class DepotOwnerRepositoryImpl(val context: DSLContext) : DepotOwnerRepository {
    override fun createDepotOwner(depotOwner: DepotOwner) {
        context.insertInto(
            DEPOT_OWNER,
            DEPOT_OWNER.FIRST_NAME,
            DEPOT_OWNER.LAST_NAME
        )
            .values(depotOwner.firstName,
                depotOwner.lastName)
            .execute()
    }
}
