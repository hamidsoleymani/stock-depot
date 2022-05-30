package boostmedia.stockdepot.domain.depot

import boostmedia.stockdepot.domain.stock.Stock

class Depot(val depotName: String, val brokerName: String, val depotId: Int?, val depotOwnerId: Int, val stockViews: List<Stock>?) {

}
