import { Component, OnInit } from '@angular/core';
import { DepotOwnerService } from "../depot-owner/DepotOwnerService";
import { DepotOwnerView } from "../../share/be_to_fe";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
 depotOwnerView: DepotOwnerView | undefined;
  constructor(private _depotOwnerService: DepotOwnerService) { }

  ngOnInit(): void {
   this.depotOwnerView = this._depotOwnerService.depotOwnerView;
  }

}
