import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup } from "@angular/forms";


@Component({
  selector: 'app-form',
  templateUrl: './form-component.html'
})

export class FormComponent {
  formGroup: FormGroup;

  constructor(fb: FormBuilder){

    this.formGroup = fb.group({
      country :  ['13'],
      city : ['24']
    });
    this.formGroup.valueChanges.subscribe(a=> console.log(a))
  }

  onSubmit(){
    console.log(this.formGroup.value)
  }

  reset(){
    this.formGroup.reset();
  }

  set(){
    this.formGroup.setValue({country: "iran", city:"tehran"})
  }

  update(){
    this.formGroup.patchValue({country:"holand"})
  }
}
