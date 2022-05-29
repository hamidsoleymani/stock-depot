import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { DepotOwnerService } from "./DepotOwnerService";

@Component({
  selector: 'app-depot-owner',
  templateUrl: './depot-owner.component.html',
  styleUrls: ['./depot-owner.component.css']
})
export class DepotOwnerComponent implements OnInit {

  myFormModel: FormGroup;

  constructor(private _router: Router, private _depotOwnerService: DepotOwnerService) {
    this.myFormModel = new FormGroup({
      firstName: new FormControl('',[Validators.required]),
      lastName: new FormControl('',[Validators.required]),
      email: new FormControl('',[Validators.required])
    });
  }

  ngOnInit(): void {
  }

  submit(){

    let depotOwnerView = {"firstName": this.myFormModel.get('firstName')?.value, "lastName": this.myFormModel.get('lastName')?.value}
    this._depotOwnerService.createDepotOwner(depotOwnerView)
      .subscribe(idOFNewCreatedDepotOwner =>
      this._depotOwnerService.getDepotOwnerById(idOFNewCreatedDepotOwner).subscribe(
        depotOwnerView => {this._depotOwnerService.setDepotOwner(depotOwnerView)
          this._router.navigate(["/dashboard"]);
          localStorage.setItem("depotOwnerView", JSON.stringify(depotOwnerView))
        })
      )

  }
}
