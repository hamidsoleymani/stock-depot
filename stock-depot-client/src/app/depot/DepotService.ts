import {Injectable} from "@angular/core";
import {DepotView, StockView} from "../../share/be_to_fe";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {DepotOwnerService} from "../depot-owner/DepotOwnerService";
import {StockService} from "../stock/StockService";


@Injectable({
  providedIn: 'root' /* injector goes here */
})
export class DepotService {
  url: string = 'http://localhost:8080/api/stock-depot';

  constructor(private _http: HttpClient, private _depotOwnerService: DepotOwnerService, private _stockService: StockService) {
  }

  createDepot(depotView: DepotView): Observable<number> {
    return this._http.post<number>(this.url + '/new/depot', depotView);
  }

  loadDepots(): Observable<DepotView[]> {
    let id = this._depotOwnerService.fromLocalStorage().id;
    let apiUrl = this.url + '/depots/depotOwner/'+ id;
    return this._http.get<DepotView[]>(apiUrl)
  }

  save(stockView: StockView)  {
    this._stockService.save(stockView)

  }
}
