import { Component, EventEmitter, Output } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";
import { DepotService } from "./DepotService";
import { DepotOwnerService } from "../depot-owner/DepotOwnerService";
import { DepotView } from "../../share/be_to_fe";
import {StockFormDialog} from "../stock/StockFormDialog";
import {MatDialog} from "@angular/material/dialog";


@Component({
  selector: 'app-depot',
  templateUrl: 'depot.component.html',
  styleUrls: ['./depot.component.css'],
})
export class DepotComponent {
  depotFormGroup: FormGroup;

  // @ts-ignore
  depots: DepotView[];

  @Output() onDepotCreated = new EventEmitter<number>();

  constructor(fb: FormBuilder, private depotService: DepotService,
              private _depotOwnerService: DepotOwnerService,
              private _depotService: DepotService,
              public dialog: MatDialog){
    this.depotFormGroup = fb.group({depotName: [''], brokerName: ['']})
   this.loadDepots();
  }

  loadDepots(){
    this._depotService.loadDepots().subscribe(
      depots => this.depots = depots
    )
  }

  addNewStock(depotId: number | null | undefined) {
   // this.showStockForm = true;
    const dialogRef = this.dialog.open(StockFormDialog, {
      width: '250px',
      data: {'depotId': depotId},
    });

    dialogRef.afterClosed().subscribe(result => {

    })
  }

  createDepot(){
    let depotView: DepotView = this.depotFormGroup.value;
    // @ts-ignore
    depotView.depotOwnerId = this._depotOwnerService.fromLocalStorage().id;
    this.depotService.createDepot(depotView).subscribe(
      a => {
        this.onDepotCreated.emit(a);
        this.depotFormGroup.reset();
        this.loadDepots();
      }
    )
  }
}
