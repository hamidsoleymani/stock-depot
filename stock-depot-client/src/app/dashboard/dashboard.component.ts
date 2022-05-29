import { Component, OnInit } from '@angular/core';
import { DepotOwnerService } from "../depot-owner/DepotOwnerService";
import { DepotOwnerView } from "../../share/be_to_fe";
import { Router } from "@angular/router";
import { DepotService } from "../depot/DepotService";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  depotOwnerView: DepotOwnerView | undefined;
  showStockForm = false;
  showDepotForm = false;

  constructor(private _depotOwnerService: DepotOwnerService,
              private _router: Router,
              private _depotService: DepotService){
  }

  ngOnInit(): void{
    this.depotOwnerView = this._depotOwnerService.fromLocalStorage()
  }

  onShowDepotForm(){
    this.showDepotForm = true;
    this.showStockForm = false;
  }

  onShowStockForm(){
    this.showStockForm = true;
    this.showDepotForm = false
  }

  depotCreated(){
    this.showStockForm = true;
  }
}
