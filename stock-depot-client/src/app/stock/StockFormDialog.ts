import {Component, Inject} from "@angular/core";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {StockView} from "../../share/be_to_fe";
import {FormBuilder, FormGroup} from "@angular/forms";
import {DepotService} from "../depot/DepotService";
import {StockService} from "./StockService";


@Component({
  selector: 'stock-form-dialog',
  templateUrl: 'stock-form-dialog.html',
})
export class StockFormDialog {

  stockFormGroup: FormGroup;

  constructor(@Inject(MAT_DIALOG_DATA) public data: StockView,
              fb: FormBuilder,
              private _depotService: DepotService, private _stockService: StockService,
              public dialogRef: MatDialogRef<StockFormDialog>) {

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
    if (stockView.name == null || stockView.buyPrice == null) {
      return
    }
    stockView.depotId = this.data.depotId;
    this._depotService.save(stockView).subscribe(() => {
      this.stockFormGroup.reset();
      this._stockService.stockSubject.next(stockView);
      //this._depotService.loadStocksByDepotId(stockView.depotId);
    });
  }

  cancel() {
    this.dialogRef.close()
  }
}
