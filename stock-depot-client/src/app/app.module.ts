import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { DepotOwnerComponent } from './depot-owner/depot-owner.component';
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { MatButtonModule } from "@angular/material/button";
import { HashLocationStrategy, LocationStrategy } from "@angular/common";
import { RouterModule } from "@angular/router";
import { routing } from "./app-routing.module";
import { DashboardComponent } from './dashboard/dashboard.component';
import { HttpClientModule } from "@angular/common/http";
import { MatCardModule } from "@angular/material/card";
import { MatIconModule } from "@angular/material/icon";
import { FormModule } from "./form/form.module";
import { DepotComponent } from "./depot/depot.component";
import { StockComponent } from "./stock/stock.component";
import {StockFormDialog} from "./stock/StockFormDialog";
import {MatDialogModule} from '@angular/material/dialog';


@NgModule({
  declarations: [
    AppComponent,
    DepotOwnerComponent,
    DashboardComponent,
    DepotComponent,
    StockComponent,
    StockFormDialog
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    RouterModule,
    HttpClientModule,
    routing,
    MatCardModule,
    MatIconModule,
    FormModule,
    MatDialogModule
  ],
  providers:[{provide: LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule { }
