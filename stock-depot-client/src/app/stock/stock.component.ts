import {Component, OnInit} from "@angular/core";
import {FormBuilder} from "@angular/forms";
import {DepotService} from "../depot/DepotService";
import {DepotView} from "../../share/be_to_fe";
import {MatDialog} from "@angular/material/dialog";
import {StockFormDialog} from "./StockFormDialog";


@Component({
  selector: 'app-stock',
  templateUrl: 'stock.component.html'
})
export class StockComponent implements OnInit {

  // @ts-ignore
  depots: DepotView[];
  showStockForm: boolean = false;

  constructor(fb: FormBuilder,
              private _depotService: DepotService,
              public dialog: MatDialog) {

    // @ts-ignore
    this._depotService.loadDepots().subscribe(
      depots => this.depots = depots
    )
  }

  ngOnInit(): void {
  }

  addNewStock(depotId: number | null | undefined) {
    this.showStockForm = true;
    const dialogRef = this.dialog.open(StockFormDialog, {
      width: '250px',
      data: {'depotId': depotId},
    });

    dialogRef.afterClosed().subscribe(result => {

    })
  }
}
