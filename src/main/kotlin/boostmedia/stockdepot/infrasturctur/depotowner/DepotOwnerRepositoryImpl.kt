package boostmedia.stockdepot.infrasturctur.depotowner

import boostmedia.stockdepot.domain.depotowner.DepotOwnerRepository
import domain.depotowner.Tables
import boostmedia.stockdepot.infrasturctur.depotowner.DepotOwnerDto
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class DepotOwnerRepositoryImpl(val context: DSLContext) : DepotOwnerRepository {


    override fun createDepotOwner(depotOwnerDto: DepotOwnerDto) {
        context.insertInto(Tables.DEPOT_OWNER, Tables.DEPOT_OWNER.FIRST_NAME,
        Tables.DEPOT_OWNER.LAST_NAME)
            .values(depotOwnerDto.firstName, depotOwnerDto.lastName)
            .execute()
    }
}
