import {Component, EventEmitter, Output} from "@angular/core";
import {FormBuilder, FormGroup} from "@angular/forms";
import {DepotService} from "./DepotService";
import {DepotOwnerService} from "../depot-owner/DepotOwnerService";
import {DepotView} from "../../share/be_to_fe";
import {StockFormDialog} from "../stock/StockFormDialog";
import {MatDialog} from "@angular/material/dialog";
import {StockService} from "../stock/StockService";


@Component({
  selector: 'app-depot',
  templateUrl: 'depot.component.html',
  styleUrls: ['./depot.component.css'],
})
export class DepotComponent {
  depotFormGroup: FormGroup;

  depots: DepotView[];

  @Output() onDepotCreated = new EventEmitter<number>();

  constructor(fb: FormBuilder, private depotService: DepotService, private _stockService: StockService,
              private _depotOwnerService: DepotOwnerService,
              private _depotService: DepotService,
              public dialog: MatDialog) {
    this.depotFormGroup = fb.group({depotName: [''], brokerName: ['']})
    this.loadDepots();
    this._stockService.stockView$.subscribe(stock => {
        this.depots?.forEach((einDepot, index) => {
          if (einDepot.depotId === stock.depotId) {
            einDepot.stockViews = einDepot.stockViews.concat(stock);
          }
        })
      }
    )
    /*  this.depotService.depots$.subscribe(depot => {
        this.depots?.forEach((item, index) => {
          if (item.depotId === depot.depotId) {
            this.depots.splice(index, 1);
            this.depots.push(depot);
            this.sort();
          }
        })
      }) */
  }

  loadDepots() {
    this._depotService.loadDepots().subscribe(
      depots => {
        this.depots = depots;
        this.sort();
      })
  }

  sort() {
    this.depots.sort((d1, d2) => d1.depotId - d2.depotId)

  }

  addNewStock(depotId: number) {
    const dialogRef = this.dialog.open(StockFormDialog, {
      width: '250px',
      data: {'depotId': depotId},
    });

    dialogRef.afterClosed().subscribe(result => {
    })
  }

  createDepot() {
    let depotView: DepotView = this.depotFormGroup.value;
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
