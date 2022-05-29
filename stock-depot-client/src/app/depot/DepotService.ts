import { Injectable } from "@angular/core";
import { DepotView } from "../../share/be_to_fe";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";


@Injectable({
  providedIn: 'root' /* injector goes here */
})
export class DepotService {
  url: string = 'http://localhost:8080/api/stock-depot';

  constructor(private _http: HttpClient){
}

  createDepot(depotView: DepotView): Observable<number>{
    return this._http.post<number>(this.url + '/new/depot', depotView);
  }
}
