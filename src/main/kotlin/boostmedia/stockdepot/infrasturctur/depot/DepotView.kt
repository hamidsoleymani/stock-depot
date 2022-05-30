package boostmedia.stockdepot.infrasturctur.depot

import boostmedia.stockdepot.infrasturctur.stock.StockView

class DepotView(val depotName: String, val brokerName: String, val depotId: Int?, val depotOwnerId: Int, val stockViews: List<StockView>?)
