import {Component, Input, OnInit} from "@angular/core";
import {FormBuilder} from "@angular/forms";
import {DepotService} from "../depot/DepotService";
import { StockView} from "../../share/be_to_fe";
import {StockService} from "./StockService";


@Component({
  selector: 'app-stock',
  templateUrl: 'stock.component.html',
  styleUrls: ['stock.component.css'],
})
export class StockComponent implements OnInit {

  @Input() dataSource: StockView[];

  displayedColumns : string[] = ['name', 'wkn', 'stockExchangeBuy', 'buyDate', 'quantity','currency'];

  constructor(fb: FormBuilder,
              private _depotService: DepotService,
              private _stockService: StockService) {
    this._stockService.loadStocks()
  }

  ngOnInit(): void {
  }


}
