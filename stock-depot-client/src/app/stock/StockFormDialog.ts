import {Component, Inject} from "@angular/core";
import {MAT_DIALOG_DATA, MatDialog} from "@angular/material/dialog";
import {StockView} from "../../share/be_to_fe";
import {FormBuilder, FormGroup} from "@angular/forms";
import {DepotService} from "../depot/DepotService";


@Component({
  selector: 'stock-form-dialog',
  templateUrl: 'stock-form-dialog.html',
})
export class StockFormDialog {

  stockFormGroup: FormGroup;

  constructor(@Inject(MAT_DIALOG_DATA) public data: StockView,
              fb: FormBuilder,
              private _depotService: DepotService, public dialog: MatDialog) {

    this.stockFormGroup = fb.group({
      name: [],
      wkn: [],
      isin: [],
      stockExchangeBuy: [],
      buyDate: [],
      buyPrice: [],
      quantity: [],
      currency: [],
    })
  }

  createStock() {
    let stockView: StockView = this.stockFormGroup.value;
    stockView.depotId = this.data.depotId;
    this._depotService.save(stockView)
  }
}
