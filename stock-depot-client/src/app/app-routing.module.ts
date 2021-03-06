import { RouterModule, Routes } from "@angular/router";
import { AppComponent } from "./app.component";
import { NgModule } from "@angular/core";
import { DepotOwnerComponent } from "./depot-owner/depot-owner.component";
import { DashboardComponent } from "./dashboard/dashboard.component";

const routes: Routes = [
  { path: '', component: DepotOwnerComponent},
  { path: 'dashboard', component: DashboardComponent}
];

export const routing = RouterModule.forRoot(routes);

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
