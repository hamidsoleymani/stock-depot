import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { DepotOwnerView } from "../../share/be_to_fe";
import {  Observable } from "rxjs";


@Injectable({
  providedIn: 'root' /* injector goes here */
})
export class DepotOwnerService {
  // @ts-ignore
  depotOwnerView: DepotOwnerView = null;
  url: string = 'http://localhost:8080/api/stock-depot';

  constructor(private _http: HttpClient){
  }

  createDepotOwner(depotOwnerView: DepotOwnerView): Observable<number>{
     var formData: any = new FormData();
    formData.append("depotOwnerView",depotOwnerView);
    return this._http.post<number>(this.url + '/new/depot-owner', depotOwnerView);
  }

  getDepotOwnerById(id: number) : Observable<DepotOwnerView>{
    return this._http.get<DepotOwnerView>(this.url+ '/id/'+id)
  }

  setDepotOwner(depotOwnerView: DepotOwnerView){
    this.depotOwnerView = depotOwnerView;
  }

  fromLocalStorage(): DepotOwnerView{
   // @ts-ignore
    return <DepotOwnerView>JSON.parse(localStorage.getItem("depotOwnerView"));
  }
}
