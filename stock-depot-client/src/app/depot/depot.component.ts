import { Component, EventEmitter, Output } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";
import { DepotService } from "./DepotService";
import { DepotOwnerService } from "../depot-owner/DepotOwnerService";
import { DepotView } from "../../share/be_to_fe";


@Component({
  selector: 'app-depot',
  templateUrl: 'depot.component.html',
  styleUrls: ['./depot.component.css'],
})
export class DepotComponent {
  depotFormGroup: FormGroup;

  @Output() onDepotCreated = new EventEmitter<number>();

  constructor(fb: FormBuilder, private depotService: DepotService,
              private _depotOwnerService: DepotOwnerService){
    this.depotFormGroup = fb.group({depotName: [''], brokerName: ['']})
  }

  createDepot(){
    let depotView: DepotView = this.depotFormGroup.value;
    // @ts-ignore
    depotView.depotOwnerId = this._depotOwnerService.fromLocalStorage().id;
    this.depotService.createDepot(depotView).subscribe(
      a => {
        this.onDepotCreated.emit(a)
      }
    )
  }
}
