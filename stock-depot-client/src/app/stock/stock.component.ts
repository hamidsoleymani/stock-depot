import { Component } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";


@Component({
  selector: 'app-stock',
  templateUrl: 'stock.component.html'
})
 export class StockComponent{

  stockFormGroup: FormGroup;

  constructor(fb: FormBuilder){

    this.stockFormGroup = fb.group({stockName:[],
      wkn:[],
      isin:[],
      stockExchangeBuy:[],
      buyDate:[],
      buyPrice:[],
      quantity:[],
      currency:[],
    })
  }

  createStock(){

  }
}
