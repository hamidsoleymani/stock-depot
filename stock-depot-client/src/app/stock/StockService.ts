import {Injectable} from "@angular/core";
import {DepotView, StockView} from "../../share/be_to_fe";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";

@Injectable({
  providedIn: 'root' /* injector goes here */
})
export class StockService {

  url: string = 'http://localhost:8080/api/stock-depot';
  stockSubject: BehaviorSubject<StockView> = new BehaviorSubject<StockView>(null);
  stockView$ = this.stockSubject.asObservable();

  constructor(private _http: HttpClient) {

  }

  save(stockView: DepotView): Observable<void> {
    return this._http.post<void>(this.url + '/new/stock', stockView);
  }

  loadStocks() {

  }
}
